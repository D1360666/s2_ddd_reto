package co.com.sofka.domain.teamdomain.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.teamdomain.entity.Trainer;
import co.com.sofka.domain.teamdomain.values.*;

public class TrainerCreated extends DomainEvent {

    private final Name name;
    private final Ci ci;
    private final Address address;
    private final Phone phone;

    public TrainerCreated( Name name, Address address, Phone phone, Ci ci){
        super("sofka.domain.teamdomain.trainercreated");

        this.name = name;
        this.ci = ci;
        this.address = address;
        this.phone = phone;

    }

   // public TrainerID getTrainerID(){
      //  return trainerID;
   // }

    public Name getName(){
        return name;
    }

    public Ci getCi(){
        return ci;
    }
    public Address getAddress(){
        return address;
    }
    public Phone getPhone(){
        return phone;
    }


    public TrainerID getTrainerID() {
        return null;
    }
}
