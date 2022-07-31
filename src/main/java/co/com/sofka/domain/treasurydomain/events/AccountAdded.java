package co.com.sofka.domain.treasurydomain.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.teamdomain.entity.Player;
import co.com.sofka.domain.treasurydomain.values.AccountID;
import co.com.sofka.domain.treasurydomain.values.Money;

public class AccountAdded extends DomainEvent {
    private AccountID accountID;
    private Player player;
    private Money balance;

    public AccountAdded(AccountID accountID, Player player, Money balance){
        super("sofka.domain.treasurydomain.accountadded");
        this.accountID = accountID;
        this.player = player;
        this.balance = balance;
    }

    public AccountID getAccountID() {
        return accountID;
    }

    public Player getPlayer() {
        return player;
    }

    public Money getBalance() {
        return balance;
    }
}
