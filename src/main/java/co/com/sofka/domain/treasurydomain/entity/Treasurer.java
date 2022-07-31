package co.com.sofka.domain.treasurydomain.entity;

import co.com.sofka.domain.generic.Entity;
import co.com.sofka.domain.treasurydomain.values.*;

import java.util.Objects;

public class Treasurer extends Entity<TreasurerID> {
    private TreasurerID treasurerID;
    private Name name;
    private Address address;
    private Phone phone;
    private Ci ci;

    public Treasurer(TreasurerID treasurerID, Name name, Address address, Phone phone, Ci ci){
        super(treasurerID);
        this.name=name;
        this.address=address;
        this.phone=phone;
        this.ci=ci;

    }

    public void updateName(Name name){this.name = Objects.requireNonNull(name);}
    public void updateAddress(Address address){this.address = Objects.requireNonNull(address);}
    public void updatePhone(Phone phone){this.phone = Objects.requireNonNull(phone);}
    public void updateCi(Ci ci){
        this.ci = Objects.requireNonNull(ci);
    }

    public TreasurerID TreasurerID() {
        return treasurerID;
    }

    public Name name() {
        return name;
    }

    public Address address() {
        return address;
    }

    public Phone phone() {
        return phone;
    }

    public Ci ci() {
        return ci;
    }
}
