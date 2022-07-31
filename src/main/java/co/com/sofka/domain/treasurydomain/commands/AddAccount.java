package co.com.sofka.domain.treasurydomain.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.domain.teamdomain.entity.Player;
import co.com.sofka.domain.treasurydomain.values.AccountID;
import co.com.sofka.domain.treasurydomain.values.Money;

public class AddAccount extends Command {
    private final AccountID accountID;
    private final Player player;
    private Money balance;

    public AddAccount(AccountID accountID, Player player, Money balance){
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
