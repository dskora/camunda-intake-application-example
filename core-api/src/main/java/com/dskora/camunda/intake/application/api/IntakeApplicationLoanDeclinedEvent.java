package com.dskora.camunda.intake.application.api;

import lombok.Value;

@Value
public class IntakeApplicationLoanDeclinedEvent {
    private String applicationId;
    private String firstname;
    private String surname;
}