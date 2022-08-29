package co.com.sofka.domain.treasurydomain;

import co.com.sofka.domain.generic.EventChange;

import co.com.sofka.domain.treasurydomain.commands.AddMovement;
import co.com.sofka.domain.treasurydomain.entity.Account;
import co.com.sofka.domain.treasurydomain.entity.Movement;
import co.com.sofka.domain.treasurydomain.entity.Treasurer;
import co.com.sofka.domain.treasurydomain.events.*;

import java.util.HashSet;

public class TreasuryChange extends EventChange {
    public TreasuryChange(Treasury treasury){
        apply((TreasuryCreated event)->{
            treasury.name = event.getName();
        });

        apply((AccountAdded evt)->{
            Account account = new Account(evt.getAccountID(), evt.getPlayer(), evt.getBalance());
            treasury.addAccount(account.identity(), account.player(), account.balance());
        });

        apply((MovementAdded evt)->{
            Movement movement = new Movement(evt.getMovementID(), evt.getDateOfIssue(), evt.getReason(), evt.getAmount(),evt.getTypeOfMovement(), evt.getAccount());
            treasury.addMovement(movement.identity(), movement.dateOfIssue(), movement.reason(), movement.amount(), movement.typeOfMovement(), movement.account());
        });

        apply((TreasurerAdded evt)-> {
            Treasurer treasurer = new Treasurer(evt.getTreasurerID(), evt.getName(), evt.getAddress(), evt.getPhone(), evt.getCi());
            treasury.addTreasurer(treasurer.TreasurerID(), treasurer.name(), treasurer.address(), treasurer.phone(), treasurer.ci());
        });

        apply((TreasurerUpdated evt)-> {
            Treasurer treasurer = new Treasurer(evt.getTreasurerID(), evt.getName(), evt.getAddress(), evt.getPhone(), evt.getCi());
            treasury.addTreasurer(treasurer.TreasurerID(), treasurer.name(), treasurer.address(), treasurer.phone(), treasurer.ci());
        });
    }

}
