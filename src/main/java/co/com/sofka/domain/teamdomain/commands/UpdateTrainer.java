package co.com.sofka.domain.teamdomain.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.domain.teamdomain.values.*;

public class UpdateTrainer extends Command {
    private final TrainerID trainerID;
    private final Name name;
    private final Address address;
    private final Phone phone;
    private final Ci ci;

    public UpdateTrainer(TrainerID trainerID, Name name, Address address, Phone phone, Ci ci) {
        this.trainerID = trainerID;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.ci = ci;
    }

    public TrainerID getTrainerID() {
        return trainerID;
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
