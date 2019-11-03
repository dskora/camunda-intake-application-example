package com.dskora.camunda.intake.application.camunda.flow;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dskora.camunda.intake.application.api.ApproveIntakeApplicationCommand;

@Component
public class ApproveIntakeApplicationAdapter implements JavaDelegate {

    private final CommandGateway commandGateway;

    public ApproveIntakeApplicationAdapter(CommandGateway commandGateway)
    {
        this.commandGateway = commandGateway;
    }

    @Override
    public void execute(DelegateExecution context) throws Exception {
        ApproveIntakeApplicationCommand command = new ApproveIntakeApplicationCommand((String)context.getVariable("applicationId"), (String)context.getVariable("firstname"), (String)context.getVariable("firstname"));
        commandGateway.send(command);
    }
}