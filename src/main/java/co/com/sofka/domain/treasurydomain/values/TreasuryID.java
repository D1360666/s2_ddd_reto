package co.com.sofka.domain.treasurydomain.values;

import co.com.sofka.domain.generic.Identity;


public class TreasuryID extends Identity {

    public TreasuryID() {

    }

    private TreasuryID(String id){
        super(id);
    }
    public static TreasuryID of(String id){
        return new TreasuryID(id);
    }

}
