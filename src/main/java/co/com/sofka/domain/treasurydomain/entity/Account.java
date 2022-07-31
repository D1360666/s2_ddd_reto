package co.com.sofka.domain.treasurydomain.entity;

import co.com.sofka.domain.generic.Entity;
import co.com.sofka.domain.teamdomain.entity.Player;
import co.com.sofka.domain.treasurydomain.values.AccountID;
import co.com.sofka.domain.treasurydomain.values.Money;

import java.util.Objects;

public class Account extends Entity<AccountID> {
    private AccountID accountID;
    private Player player;
    private Money balance;

    public Account(AccountID accountID, Player player, Money balance){
        super(accountID);
        this.player = player;
        this.balance = balance;
    }

    public void updatePlayer(Player player){this.player= Objects.requireNonNull(player);}
    public void updateBalance(Money balance){this.balance=Objects.requireNonNull(balance);}


    public Player player() {
        return player;
    }

    public Money balance() {
        return balance;
    }
}


