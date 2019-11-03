package com.dskora.camunda.intake.application.api;

import lombok.Value;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

@Value
public class IntakeApplicationApprovedEvent {
    @TargetAggregateIdentifier
    private String applicationId;

    private String firstname;
    private String surname;
}