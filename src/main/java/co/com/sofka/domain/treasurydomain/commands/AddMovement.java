package co.com.sofka.domain.treasurydomain.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.domain.treasurydomain.entity.Account;
import co.com.sofka.domain.treasurydomain.values.*;

public class AddMovement extends Command {

    private final MovementID movementID;
    private final DateOfIssue dateOfIssue;
    private final Reason reason;
    private final Money amount;
    private final TypeOfMovement typeOfMovement;
    private final Account account;

    public AddMovement(MovementID movementID, DateOfIssue dateOfIssue, Reason reason, Money amount, TypeOfMovement typeOfMovement,Account account){
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
