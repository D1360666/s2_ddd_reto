package co.com.sofka.domain.treasurydomain.entity;

import co.com.sofka.domain.generic.Entity;
import co.com.sofka.domain.treasurydomain.values.*;

import java.util.Objects;


public class Movement extends Entity<MovementID> {

    private MovementID movementID;
    private DateOfIssue dateOfIssue;
    private Reason reason;
    private Money amount;
    private TypeOfMovement typeOfMovement;
    private Account account;

    public Movement(MovementID movementID, DateOfIssue dateOfIssue, Reason reason, Money amount, TypeOfMovement typeOfMovement, Account account){
        super(movementID);
        this.dateOfIssue= dateOfIssue;
        this.reason = reason;
        this.amount = amount;
        this.typeOfMovement = typeOfMovement;
        this.account = account;

    }

    public void updateDateOfIssue(DateOfIssue dateOfIssue){this.dateOfIssue= Objects.requireNonNull(dateOfIssue);}
    public void updateReason(Reason reason){this.reason= Objects.requireNonNull(reason);}
    public void updateAmount(Money amount){this.amount= Objects.requireNonNull(amount);}
    public void updateTypeOfMovement(TypeOfMovement typeOfMovement){this.typeOfMovement= Objects.requireNonNull(typeOfMovement);}
    public void updateAccount(Account account){this.account= Objects.requireNonNull(account);}


    public DateOfIssue dateOfIssue() {
        return dateOfIssue;
    }

    public Reason reason() {
        return reason;
    }

    public Money amount() {
        return amount;
    }

    public TypeOfMovement typeOfMovement() {
        return typeOfMovement;
    }

    public Account account() {
        return account;
    }
}
