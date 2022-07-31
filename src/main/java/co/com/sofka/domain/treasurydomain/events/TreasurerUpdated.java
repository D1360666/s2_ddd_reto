package co.com.sofka.domain.treasurydomain.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.treasurydomain.values.*;

public class TreasurerUpdated extends DomainEvent {
    private TreasurerID treasurerID;
    private Name name;
    private Address address;
    private Phone phone;
    private Ci ci;

    public TreasurerUpdated(TreasurerID treasurerID, Name name, Address address, Phone phone, Ci ci){
        super("sofka.domain.treasurydomain.accountadded");
        this.treasurerID =treasurerID;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.ci = ci;
    }

    public TreasurerID getTreasurerID() {
        return treasurerID;
    }

    public Name getName() {
        return name;
    }

    public Address getAddress() {
        return address;
    }

    public Phone getPhone() {
        return phone;
    }

    public Ci getCi() {
        return ci;
    }
}