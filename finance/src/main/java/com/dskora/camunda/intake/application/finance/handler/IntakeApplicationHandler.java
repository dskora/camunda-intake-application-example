package com.dskora.camunda.intake.application.finance.handler;

import java.util.Random;

import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.commandhandling.CommandHandler;

import com.dskora.camunda.intake.application.api.CheckIntakeApplicationLoanEligibilityCommand;
import com.dskora.camunda.intake.application.api.ApproveIntakeApplicationLoanCommand;
import com.dskora.camunda.intake.application.api.DeclineIntakeApplicationLoanCommand;

@Component
public class IntakeApplicationHandler {
    private final CommandGateway commandGateway;

    @Autowired
    public IntakeApplicationHandler(CommandGateway commandGateway)
    {
        this.commandGateway = commandGateway;
    }

    @CommandHandler
    public void handle(CheckIntakeApplicationLoanEligibilityCommand cmd)
    {
        Random rand = new Random();
        if (rand.nextInt(2) == 1) {
            ApproveIntakeApplicationLoanCommand command = new ApproveIntakeApplicationLoanCommand(cmd.getApplicationId(), cmd.getFirstname(), cmd.getSurname());
            commandGateway.send(command);
        } else {
            DeclineIntakeApplicationLoanCommand command = new DeclineIntakeApplicationLoanCommand(cmd.getApplicationId(), cmd.getFirstname(), cmd.getSurname());
            commandGateway.send(command);
        }
    }
}