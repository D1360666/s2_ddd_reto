package co.com.sofka.domain.teamdomain.entity;

import co.com.sofka.domain.generic.Entity;
import co.com.sofka.domain.teamdomain.values.*;

import java.util.Objects;

public class Trainer extends Entity<TrainerID> {
    public static TrainerID trainerID;
    public static Name name;
    public static Address address;
    public static Phone phone;
    public static Ci ci;

    public Trainer(TrainerID trainerID, Name name, Address address, Phone phone, Ci ci){
        super(trainerID);
        this.name= name;
        this.address=address;
        this.phone=phone;
        this.ci=ci;
    }

    public Trainer(TrainerID trainerID){super(trainerID);}

  /*  public void updateName(Name name){
        this.name = Objects.requireNonNull(name);
    }
    public void updateAddress(Address address) {
        this.address = Objects.requireNonNull(address);
    }
    public void updateName(Phone phone){
        this.phone = Objects.requireNonNull(phone);
    }
    public void updateCi(Ci ci){
        this.ci = Objects.requireNonNull(ci);
    }*/
    public void CreateTrainer(TrainerID trainerID, Name name, Address address, Phone phone, Ci ci){
        this.trainerID = Objects.requireNonNull(trainerID);
        this.name = Objects.requireNonNull(name);
        this.address = Objects.requireNonNull(address);
        this.phone = Objects.requireNonNull(phone);
        this.ci = Objects.requireNonNull(ci);
    }

    public static Name name(){
        return name;
    }
    public static Address address(){
        return address;
    }
    public static Phone phone(){
        return phone;
    }
    public static Ci ci(){
        return ci;
    }

}
