package co.com.sofka.domain.treasurydomain.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.treasurydomain.entity.Account;
import co.com.sofka.domain.treasurydomain.values.*;

public class MovementAdded extends DomainEvent {
    private MovementID movementID;
    private DateOfIssue dateOfIssue;
    private Reason reason;
    private Money amount;
    private TypeOfMovement typeOfMovement;
    private Account account;

    public MovementAdded(MovementID movementID, DateOfIssue dateOfIssue, Reason reason, Money amount, TypeOfMovement typeOfMovement, Account account){
        super("sofka.domain.treasurydomain.movementeadded");
        this.movementID = movementID;
        this.dateOfIssue = dateOfIssue;
        this.reason = reason;
        this.amount = amount;
        this.typeOfMovement = typeOfMovement;
        this.account = account;
    }

    public MovementID getMovementID() {
        return movementID;
    }

    public DateOfIssue getDateOfIssue() {
        return dateOfIssue;
    }

    public Reason getReason() {
        return reason;
    }

    public Money getAmount() {
        return amount;
    }

    public TypeOfMovement getTypeOfMovement() {
        return typeOfMovement;
    }

    public Account getAccount() {
        return account;
    }
}
