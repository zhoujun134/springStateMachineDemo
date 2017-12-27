package test.demo2;
import org.springframework.beans.factory.support.StaticListableBeanFactory;
import org.springframework.statemachine.StateMachine;
import org.springframework.statemachine.config.ObjectStateMachineFactory;
import org.springframework.statemachine.config.StateMachineBuilder;
import org.springframework.statemachine.config.model.ConfigurationData;
import org.springframework.statemachine.config.model.DefaultStateMachineModel;
import org.springframework.statemachine.config.model.StatesData;
import org.springframework.statemachine.config.model.TransitionsData;
import org.springframework.statemachine.support.StateMachineInterceptor;

import java.util.Collection;
import java.util.HashSet;

public class MakeStateMachine {
    /**
     * 构建状态机，方式一
     * @return
     * @throws Exception
     */
    public static StateMachine<String,String> createStateMachine() throws Exception {
        ConfigurationData<String, String> configData = SSMConfig.getConfigurationData();
        StatesData<String, String> statesData = SSMConfig.getStatesData();
        TransitionsData<String, String> transitionsData = SSMConfig.getTransitionsData();
        DefaultStateMachineModel<String,String> machineModel = new DefaultStateMachineModel<String, String>(configData,statesData,transitionsData);
        ObjectStateMachineFactory<String, String> machineFactory = new ObjectStateMachineFactory<String, String>(machineModel);
        StateMachine<String, String> stateMachine  = machineFactory.getStateMachine();
        //添加状态机的监听器，自行实现
        stateMachine.addStateListener(new TestSMListener());

        //添加状态机的拦截器，自行实现内部接口即可
        stateMachine.getStateMachineAccessor()
                         .withRegion()
                         .addStateMachineInterceptor(new TestSMInterceptor());
        return stateMachine;
    }

    /**
     * 构建状态机，方式二
     */
    public static StateMachine<String,String> getStateMachine() throws Exception {
        StateMachineBuilder.Builder<String,String> builder = StateMachineBuilder.builder();
        builder.configureConfiguration()
                .withConfiguration()
                //添加状态机监听器
                .listener(new TestSMListener())
                .beanFactory(new StaticListableBeanFactory());//添加构建bean的工厂类，可以自行实现，这里是使用系统的默认

        Collection<ConfigEntity> data = SSMConfig.getConfigEntities();
        HashSet<String> states = new HashSet<String>();
        for (ConfigEntity configEntity : data) {
            states.add(configEntity.getTarget());
            builder.configureTransitions()
                    .withExternal()
                    .source(configEntity.getSource())
                    .target(configEntity.getTarget())
                    .event(configEntity.getEvent());
        }
        builder.configureStates()
                .withStates()
                .initial(SSMConfig.initState.getState())
                .state(SSMConfig.initState.getState())
                .end(SSMConfig.endState.getState())
                .states(states);

        StateMachine<String, String> stateMachine  = builder.build();
                stateMachine.getStateMachineAccessor()
                .withRegion()
                .addStateMachineInterceptor(new TestSMInterceptor());

        return stateMachine;
    }

}