package co.com.sofka.domain.treasurydomain.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.treasurydomain.entity.Treasurer;
import co.com.sofka.domain.treasurydomain.values.Name;

public class TreasuryCreated extends DomainEvent {
    private final Name name;
    //private final Treasurer treasurer;

    public TreasuryCreated(Name name){
        super("domain.treasurydomain.treasurycreated");
        this.name = name;

    }

    public Name getName() {
        return name;
    }

    /*public Treasurer getTreasurer() {
        return treasurer;
    }*/
}
