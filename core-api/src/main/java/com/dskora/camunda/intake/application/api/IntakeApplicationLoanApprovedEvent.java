package com.dskora.camunda.intake.application.api;

import lombok.Value;

@Value
public class IntakeApplicationLoanApprovedEvent {
    private String applicationId;
    private String firstname;
    private String surname;
}