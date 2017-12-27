package test.demo2;

import org.springframework.messaging.Message;
import org.springframework.statemachine.StateContext;
import org.springframework.statemachine.StateMachine;
import org.springframework.statemachine.state.State;
import org.springframework.statemachine.support.StateMachineInterceptor;
import org.springframework.statemachine.transition.Transition;

import java.util.Date;

public class TestSMInterceptor implements StateMachineInterceptor<String, String> {
    @Override
    public Message<String> preEvent(Message<String> message, StateMachine<String, String> stateMachine) {
        log("*********  preEvent start  ********");
        log("event: " + message.getPayload());
        log("*********  preEvent end  ********");
        return message;
    }

    @Override
    public void preStateChange(State<String, String> state, Message<String> message, Transition<String, String> transition, StateMachine<String, String> stateMachine) {
        log("*********  preStateChange start  ********");
        log("event: " + message.getPayload());
        log("state: " + state.getId());
        log("*********  preStateChange end  ********");
    }

    @Override
    public void postStateChange(State<String, String> state, Message<String> message, Transition<String, String> transition, StateMachine<String, String> stateMachine) {
        log("*********  postStateChange start  ********");
        log("event: " + message.getPayload());
        log("state: " + state.getId());
        log("*********  postStateChange end  ********");
    }

    @Override
    public StateContext<String, String> preTransition(StateContext<String, String> stateContext) {
        log("*********  preTransition start  ********");
        log("*********  preTransition end  ********");
        return stateContext;
    }

    @Override
    public StateContext<String, String> postTransition(StateContext<String, String> stateContext) {
        log("*********  postTransition start  ********");
        log("*********  postTransition end  ********");
        return stateContext;
    }

    @Override
    public Exception stateMachineError(StateMachine<String, String> stateMachine, Exception e) {
        log("*********  stateMachineError start  ********");
        log("*********  stateMachineError end  ********");
        return null;
    }

    /**
     * 日志信息打印类
     * @param message 需要打印的日志信息
     */
    private void log(String message){
        System.out.println( "time: " + new Date() +  "   info:  " + message);
    }
}
