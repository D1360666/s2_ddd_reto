package co.com.sofka.domain.teamdomain.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.domain.teamdomain.entity.Trainer;
import co.com.sofka.domain.teamdomain.values.TrainerID;

public class RemoveTrainer extends Command {

    private final TrainerID trainerID;

    public RemoveTrainer(TrainerID trainerID) {
        this.trainerID = trainerID;
    }

    public TrainerID getTrainerID() {
        return trainerID;
    }
}
