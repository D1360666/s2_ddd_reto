package co.com.sofka.domain.teamdomain.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.teamdomain.entity.Tutor;
import co.com.sofka.domain.teamdomain.values.*;

public class TrainerAdded extends DomainEvent {
    private TrainerID trainerID;
    private Name name;
    private Ci ci;
    private Address address;
    private Phone phone;

    public TrainerAdded(TrainerID trainerID, Name name, Address address, Phone phone, Ci ci){
        super("sofka.domain.teamdomain.traineradded");
        this.trainerID = trainerID;
        this.name = name;
        this.ci = ci;
        this.address = address;
        this.phone = phone;

    }

    public TrainerID getTrainerID(){
        return trainerID;
    }

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


}
