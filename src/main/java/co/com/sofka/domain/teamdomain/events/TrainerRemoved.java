package co.com.sofka.domain.teamdomain.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.teamdomain.values.PlayerID;
import co.com.sofka.domain.teamdomain.values.TrainerID;

public class TrainerRemoved extends DomainEvent {
    private final TrainerID trainerID;

    public TrainerRemoved(TrainerID trainerID){
        super("sofka.domain.teamdomain.trainerremoved");
        this.trainerID = trainerID;
    }

    public TrainerID getTrainerID(){
        return trainerID;
    }
}
