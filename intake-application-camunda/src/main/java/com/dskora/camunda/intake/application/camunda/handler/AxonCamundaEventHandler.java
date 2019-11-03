package com.dskora.camunda.intake.application.camunda;

import java.util.logging.Logger;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import org.camunda.bpm.engine.ProcessEngine;
import org.axonframework.eventhandling.EventHandler;

import com.dskora.camunda.intake.application.api.IntakeApplicationReceivedEvent;
import com.dskora.camunda.intake.application.api.IntakeApplicationDeclinedEvent;
import com.dskora.camunda.intake.application.api.IntakeApplicationLoanApprovedEvent;
import com.dskora.camunda.intake.application.api.IntakeApplicationLoanDeclinedEvent;
import com.dskora.camunda.intake.application.api.IntakeApplicationQualityAcceptedEvent;
import com.dskora.camunda.intake.application.api.IntakeApplicationQualityDeclinedEvent;

@Component
public class AxonCamundaEventHandler {
	private final static Logger log = Logger.getLogger(AxonCamundaEventHandler.class.getCanonicalName());

    @Autowired
    private ProcessEngine camunda;

    @EventHandler
    public void handle(IntakeApplicationReceivedEvent event) {
        camunda.getRuntimeService().createMessageCorrelation("IntakeApplicationReceived")
            .processInstanceBusinessKey(event.getApplicationId())
            .setVariable("applicationId", event.getApplicationId())
            .setVariable("firstname", event.getFirstname())
            .setVariable("surname", event.getSurname())
            .correlateStartMessage();
    }

    @EventHandler
    public void handle(IntakeApplicationLoanApprovedEvent event) {
        camunda.getRuntimeService().createMessageCorrelation("IntakeApplicationLoanApproved")
            .processInstanceBusinessKey(event.getApplicationId())
            .setVariable("applicationId", event.getApplicationId())
            .setVariable("firstname", event.getFirstname())
            .setVariable("surname", event.getSurname())
            .correlate();
    }

    @EventHandler
    public void handle(IntakeApplicationLoanDeclinedEvent event) {
        camunda.getRuntimeService().createMessageCorrelation("IntakeApplicationLoanDeclined")
            .processInstanceBusinessKey(event.getApplicationId())
            .setVariable("applicationId", event.getApplicationId())
            .setVariable("firstname", event.getFirstname())
            .setVariable("surname", event.getSurname())
            .correlate();
    }

    @EventHandler
    public void handle(IntakeApplicationQualityAcceptedEvent event) {
        camunda.getRuntimeService().createMessageCorrelation("IntakeApplicationQualityAccepted")
            .processInstanceBusinessKey(event.getApplicationId())
            .setVariable("applicationId", event.getApplicationId())
            .setVariable("firstname", event.getFirstname())
            .setVariable("surname", event.getSurname())
            .correlate();
    }

    @EventHandler
    public void handle(IntakeApplicationQualityDeclinedEvent event) {
        camunda.getRuntimeService().createMessageCorrelation("IntakeApplicationQualityDeclined")
            .processInstanceBusinessKey(event.getApplicationId())
            .setVariable("applicationId", event.getApplicationId())
            .setVariable("firstname", event.getFirstname())
            .setVariable("surname", event.getSurname())
            .correlate();
    }
}