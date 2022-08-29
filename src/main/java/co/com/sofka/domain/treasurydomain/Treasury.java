package co.com.sofka.domain.treasurydomain;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.teamdomain.entity.Player;
import co.com.sofka.domain.teamdomain.entity.Trainer;
import co.com.sofka.domain.teamdomain.events.TeamCreated;
import co.com.sofka.domain.teamdomain.events.TrainerCreated;
import co.com.sofka.domain.teamdomain.values.TeamID;
import co.com.sofka.domain.treasurydomain.entity.Account;
import co.com.sofka.domain.treasurydomain.entity.Treasurer;
import co.com.sofka.domain.treasurydomain.events.*;
import co.com.sofka.domain.treasurydomain.values.*;

import javax.lang.model.element.TypeParameterElement;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class Treasury extends AggregateEvent<TreasuryID> {
    protected static Name name;
    protected static Treasurer treasurer;
    protected static Set<Account> AccoutList;
    protected static Set<Player> PlayerList;

    public Name getName() {
        return name;
    }

    public Treasurer getTreasurer() {
        return treasurer;
    }

    public Set<Account> getAccoutList() {
        return AccoutList;
    }

    public Set<Player> getPlayerList() {
        return PlayerList;
    }

    public Treasury (TreasuryID entityId, Name name){
        super(entityId);
        appendChange(new TreasuryCreated(name)).apply();
    }

    private Treasury(TreasuryID treasuryID){
        super(treasuryID);
     //   appendChange(new TreasuryCreated(name)).apply();
        subscribe(new TreasuryChange(this));
    }

    public static Treasury from(TreasuryID treasuryID, List<DomainEvent> domainEvents){
        Treasury treasury = new Treasury(treasuryID);
        domainEvents.forEach(treasury::applyEvent);
        return treasury;
    }

    public void addTreasurer(TreasurerID treasurerID, Name name, Address address, Phone phone, Ci ci){
        Objects.requireNonNull(treasurerID);
        Objects.requireNonNull(name);
        Objects.requireNonNull(address);
        Objects.requireNonNull(phone);
        Objects.requireNonNull(ci);
        appendChange(new TreasurerAdded(treasurerID, name, address, phone, ci)).apply();
    }
    public void addAccount(AccountID accountID, Player player, Money balance){
        Objects.requireNonNull(accountID);
        Objects.requireNonNull(player);
        Objects.requireNonNull(balance);
        appendChange(new AccountAdded(accountID, player, balance)).apply();
    }

    public void addMovement(MovementID movementID, DateOfIssue dateOfIssue, Reason reason, Money amount, TypeOfMovement typeMovement, Account account){
        Objects.requireNonNull(movementID);
        Objects.requireNonNull(dateOfIssue);
        Objects.requireNonNull(reason);
        Objects.requireNonNull(amount);
        Objects.requireNonNull(typeMovement);
        Objects.requireNonNull(account);
        appendChange(new MovementAdded(movementID, dateOfIssue, reason, amount, typeMovement, account)).apply();
    }

    public void UpdateTreasurer(TreasurerID treasurerID, Name name, Address address, Phone phone, Ci ci){
        appendChange(new TreasurerUpdated(treasurerID, name, address, phone, ci)).apply();
    }

    public void TreasuryCreated(Name name) {
        appendChange(new TreasuryCreated(name)).apply();
    }
}
