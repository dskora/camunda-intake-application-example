package com.dskora.camunda.intake.application.quality.handler;

import java.util.Random;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.commandhandling.gateway.CommandGateway;

import com.dskora.camunda.intake.application.api.CheckIntakeApplicationQualityCommand;
import com.dskora.camunda.intake.application.api.AcceptIntakeApplicationQualityCommand;
import com.dskora.camunda.intake.application.api.DeclineIntakeApplicationQualityCommand;

@Component
public class IntakeApplicationHandler {
    private final CommandGateway commandGateway;

    @Autowired
    public IntakeApplicationHandler(CommandGateway commandGateway)
    {
        this.commandGateway = commandGateway;
    }

    @CommandHandler
    public void handle(CheckIntakeApplicationQualityCommand cmd)
    {
        Random rand = new Random();
        if (rand.nextInt(2) == 1) {
            AcceptIntakeApplicationQualityCommand command = new AcceptIntakeApplicationQualityCommand(cmd.getApplicationId(), cmd.getFirstname(), cmd.getSurname());
            commandGateway.send(command);
        } else {
            DeclineIntakeApplicationQualityCommand command = new DeclineIntakeApplicationQualityCommand(cmd.getApplicationId(), cmd.getFirstname(), cmd.getSurname());
            commandGateway.send(command);
        }
    }
}