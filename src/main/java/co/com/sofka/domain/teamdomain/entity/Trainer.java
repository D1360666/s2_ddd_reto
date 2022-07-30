package co.com.sofka.domain.teamdomain.entity;

import co.com.sofka.domain.generic.Entity;
import co.com.sofka.domain.teamdomain.values.*;

import java.util.Objects;

public class Trainer extends Entity<TrainerID> {
    private TrainerID trainerID;
    private Name name;
    private Address address;
    private Phone phone;
    private Ci ci;

    public Trainer(TrainerID trainerID, Name name, Address address, Phone phone, Ci ci){
        super(trainerID);
        this.name= name;
        this.address=address;
        this.phone=phone;
        this.ci=ci;
    }

    public void updateName(Name name){
        this.name = Objects.requireNonNull(name);
    }
    public void updateAddress(Address address){
        this.address = Objects.requireNonNull(address);
    }
    public void updateName(Phone phone){
        this.phone = Objects.requireNonNull(phone);
    }
    public void updateCi(Ci ci){
        this.ci = Objects.requireNonNull(ci);
    }

    public Name name(){
        return name;
    }

    public Address address(){
        return address;
    }
    public Phone phone(){
        return phone;
    }

    public Ci ci(){
        return ci;
    }



}
