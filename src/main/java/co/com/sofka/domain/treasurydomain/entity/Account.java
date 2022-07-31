package co.com.sofka.domain.treasurydomain.entity;

import co.com.sofka.domain.generic.Entity;
import co.com.sofka.domain.teamdomain.entity.Player;
import co.com.sofka.domain.treasurydomain.values.AccountID;

import java.util.Objects;

public class Account extends Entity<AccountID> {
    private AccountID accountID;
    private Player player;
    private Balance balance;

    public Account(AccountID accountID, Player player, Balance balance){
        super(accountID);
        this.player = player;
        this.balance = balance;
    }

    public void updatePlayer(Player player){this.player= Objects.requireNonNull(player);}
    public void updateBalance(Balance balance){this.balance=Objects.requireNonNull(balance);}


    public Player player() {
        return player;
    }

    public Balance balance() {
        return balance;
    }
}


