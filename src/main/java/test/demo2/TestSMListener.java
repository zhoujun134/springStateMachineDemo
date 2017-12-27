package test.demo2;

import org.springframework.messaging.Message;
import org.springframework.statemachine.StateContext;
import org.springframework.statemachine.StateMachine;
import org.springframework.statemachine.listener.StateMachineListener;
import org.springframework.statemachine.state.State;
import org.springframework.statemachine.transition.Transition;

import java.util.Date;

public class TestSMListener implements StateMachineListener<String, String> {
    @Override
    public void stateChanged(State<String, String> state, State<String, String> state1) {
        log("*********  stateChanged start  ********");
        log("*********  stateChanged end  ********");
    }

    @Override
    public void stateEntered(State<String, String> state) {
        log("*********  stateEntered start  ********");
        log("*********  stateEntered end  ********");

    }

    @Override
    public void stateExited(State<String, String> state) {
        log("*********  stateExited start  ********");
        log("*********  stateExited end  ********");

    }

    @Override
    public void eventNotAccepted(Message<String> message) {
        log("*********  eventNotAccepted start  ********");
        log("event: " + message.getPayload());
        log("*********  eventNotAccepted end  ********");

    }

    @Override
    public void transition(Transition<String, String> transition) {
        log("*********  transition start  ********");
        log("*********  transition end  ********");

    }

    @Override
    public void transitionStarted(Transition<String, String> transition) {
        log("*********  transitionStarted start  ********");
        log("*********  transitionStarted end  ********");

    }

    @Override
    public void transitionEnded(Transition<String, String> transition) {
        log("*********  transitionEnded start  ********");
        log("*********  transitionEnded end  ********");

    }

    @Override
    public void stateMachineStarted(StateMachine<String, String> stateMachine) {
        log("*********  stateMachineStarted start  ********");
        log("*********  stateMachineStarted end  ********");

    }

    @Override
    public void stateMachineStopped(StateMachine<String, String> stateMachine) {
        log("*********  stateMachineStopped start  ********");
        log("*********  stateMachineStopped end  ********");

    }

    @Override
    public void stateMachineError(StateMachine<String, String> stateMachine, Exception e) {
        log("*********  stateMachineError start  ********");
        log("*********  stateMachineError end  ********");

    }

    @Override
    public void extendedStateChanged(Object o, Object o1) {
        log("*********  extendedStateChanged start  ********");
        log("*********  extendedStateChanged end  ********");

    }

    @Override
    public void stateContext(StateContext<String, String> stateContext) {
        log("*********  stateContext start  ********");
        log("*********  stateContext end  ********");
    }

    /**
     * 日志信息打印类
     * @param message 需要打印的日志信息
     */
    private void log(String message){
        System.out.println( "time: " + new Date() +  "   info:  " + message);
    }
}
