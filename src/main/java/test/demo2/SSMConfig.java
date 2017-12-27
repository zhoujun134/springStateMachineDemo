package test.demo2;
import org.springframework.statemachine.config.model.*;
import org.springframework.statemachine.state.PseudoStateKind;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 配置必要的配置信息
 */
public class SSMConfig {
    private static final HashSet<String> states = new HashSet<String>();
    private static final HashSet<ConfigEntity> configEntities = new HashSet<ConfigEntity>();

    protected static final StateData<String, String> initState = new StateData<String, String>("初始状态" ,true);
    protected static final StateData<String, String> endState = new StateData<String, String>("结束状态");
    /**
     * 配置的构造方法
     */
    static {
        //构造配置信息列表，这个可以根据业务实际需求设置，可自定义
        Set<ConfigEntity> configEntities2 = new HashSet <ConfigEntity>(Arrays.asList(
                new ConfigEntity(1,"初始状态","状态1","事件1","",001),
                new ConfigEntity(1,"状态１","状态２","事件2","",001),
                new ConfigEntity(1,"状态２","状态1","事件3","",001),
                new ConfigEntity(1,"状态２","结束状态","事件4","",001)));
        for(ConfigEntity configEntity : configEntities2){
            states.add(configEntity.getSource());
            configEntities.add(configEntity);
        }
    }


    public static HashSet <String> getStates() {
        return states;
    }

    public static HashSet <ConfigEntity> getConfigEntities() {
        return configEntities;
    }


    /**
     * 构建　ConfigurationData，在这一步也可以构建为分布式的，如基于zookeeper
     * @return
     */
    public static ConfigurationData<String,String> getConfigurationData(){
        return new ConfigurationData<String, String>();
    }
    /**
     * 构建状态数据信息对象, 这一步是构建状态机的各个状态字段，用于装载状态机的状态转换之间的状态配置
     * @return
     */
    public static StatesData<String,String> getStatesData(){
        HashSet<StateData<String, String>> stateDatas = new HashSet<StateData<String, String>>();
        //初始状态
        initState.setPseudoStateKind(PseudoStateKind.INITIAL);
        stateDatas.add(initState);
        //结束状态
        endState.setEnd(true);
        endState.setPseudoStateKind(PseudoStateKind.END);
        stateDatas.add(endState);
        //其他状态加载
        for (String state: states){
            StateData<String, String> stateData = new StateData<String, String>(state);
            stateDatas.add(stateData);
        }
        //构建
        return new StatesData<String, String>(stateDatas);
    }
    /**
     * 状态事物转换的流程配置
     * @return
     */
    public static TransitionsData<String,String> getTransitionsData(){
        HashSet<TransitionData<String,String>> transitionDatas = new HashSet<TransitionData<String,String>>();
        for (ConfigEntity configEntity : configEntities ){

            TransitionData<String,String> transitionData = new TransitionData<String,String>(configEntity.getSource(),
                    configEntity.getTarget(),
                    configEntity.getEvent()
            );
            transitionDatas.add(transitionData);
        }
        return new TransitionsData<String,String>(transitionDatas);
    }
}
