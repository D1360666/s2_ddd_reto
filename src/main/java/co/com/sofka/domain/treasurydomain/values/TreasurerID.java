package co.com.sofka.domain.treasurydomain.values;

import co.com.sofka.domain.generic.Identity;

public class TreasurerID extends Identity {

    public TreasurerID(){

    }

    private TreasurerID(String id){super(id);}

    public static TreasurerID of(String id){return new TreasurerID(id);}
}
