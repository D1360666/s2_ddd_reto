package co.com.sofka.domain.treasurydomain.values;

import co.com.sofka.domain.generic.Identity;

public class AccountID extends Identity {
    public AccountID(){

    }

    private AccountID(String id){super(id);}
    public static AccountID of(String id){return new AccountID(id);}

}
