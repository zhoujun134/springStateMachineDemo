package test.demo2;

import org.springframework.messaging.support.MessageBuilder;
import org.springframework.statemachine.StateMachine;

public class Main {

    public static void main(String[] args) throws Exception {

        StateMachine<String, String> stateMachine = MakeStateMachine.getStateMachine();
        stateMachine.getTransitions().forEach(stringStringTransition -> {
            System.out.println("xxxxxx  events: " + stringStringTransition.getTrigger().getEvent());
        });
        // 启动状态机
        stateMachine.start();
        //方式一，　发送触发事件，改变状态
        stateMachine.sendEvent("事件1");
        stateMachine.sendEvent("事件2");

        //方式二，　发送触发事件，改变状态
        // header中可以存放相关数据信息，
        // 这些信息，在执行过程中，可以在监听器和拦截器中获取到，通过拦截器你可以在做额外的一些事情
//        stateMachine.sendEvent(
//                MessageBuilder.withPayload("事件1")
//                              .setHeader("testStateMachine", "测试头部")
//                               .build());
    }
}