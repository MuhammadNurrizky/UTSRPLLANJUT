package com.uts.spring_uts;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

@Component("sayHelloWorld")
public class SayHelloWorld implements JavaDelegate {

    @Override
    public void execute(DelegateExecution execution) throws Exception {
        System.out.println("==================================================");
        System.out.println(" Hello World");
        System.out.println("==================================================");
    }
}