package com.dskora.camunda.intake.application.web.domain;

import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.spring.stereotype.Aggregate;
import static org.axonframework.modelling.command.AggregateLifecycle.apply;

import com.dskora.camunda.intake.application.api.*;

@Aggregate
public class IntakeApplication {
    @AggregateIdentifier
    private String applicationId;

    private String firstname;
    private String surname;

    private IntakeApplication() { }

    @CommandHandler
    public IntakeApplication(CreateIntakeApplicationCommand cmd)
    {
        apply(new IntakeApplicationReceivedEvent(cmd.getApplicationId(), cmd.getFirstname(), cmd.getSurname()));
    }

    @CommandHandler
    public void approveLoan(ApproveIntakeApplicationLoanCommand cmd)
    {
        apply(new IntakeApplicationLoanApprovedEvent(cmd.getApplicationId(), cmd.getFirstname(), cmd.getSurname()));
    }

    @CommandHandler
    public void declineLoan(DeclineIntakeApplicationLoanCommand cmd)
    {
        apply(new IntakeApplicationLoanDeclinedEvent(cmd.getApplicationId(), cmd.getFirstname(), cmd.getSurname()));
    }

    @CommandHandler
    public void acceptQuality(AcceptIntakeApplicationQualityCommand cmd)
    {
        apply(new IntakeApplicationQualityAcceptedEvent(cmd.getApplicationId(), cmd.getFirstname(), cmd.getSurname()));
    }

    @CommandHandler
    public void declineQuality(DeclineIntakeApplicationQualityCommand cmd)
    {
        apply(new IntakeApplicationQualityDeclinedEvent(cmd.getApplicationId(), cmd.getFirstname(), cmd.getSurname()));
    }

    @CommandHandler
    public void approve(ApproveIntakeApplicationCommand cmd)
    {
        apply(new IntakeApplicationApprovedEvent(cmd.getApplicationId(), cmd.getFirstname(), cmd.getSurname()));
    }

    @CommandHandler
    public void on(DeclineIntakeApplicationCommand cmd)
    {
        apply(new IntakeApplicationDeclinedEvent(cmd.getApplicationId(), cmd.getFirstname(), cmd.getSurname()));
    }

    @EventSourcingHandler
    public void on(IntakeApplicationReceivedEvent event)
    {
        applicationId = event.getApplicationId();
        firstname = event.getFirstname();
        surname = event.getSurname();
    }
}
