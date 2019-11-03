package com.dskora.camunda.intake.application.web.controller;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dskora.camunda.intake.application.api.CreateIntakeApplicationCommand;
import com.dskora.camunda.intake.application.web.dto.IntakeApplicationDto;

import java.util.UUID;

@RestController
public class IntakeApplicationController {

    private final CommandGateway commandGateway;

    public IntakeApplicationController(CommandGateway commandGateway)
    {
        this.commandGateway = commandGateway;
    }

    @RequestMapping(value = "/intake-application", method=RequestMethod.POST)
    public void intakeApplication(IntakeApplicationDto dto)
    {
        CreateIntakeApplicationCommand command = new CreateIntakeApplicationCommand(UUID.randomUUID().toString(), dto.getFirstname(), dto.getSurname());
        commandGateway.send(command);
    }
}