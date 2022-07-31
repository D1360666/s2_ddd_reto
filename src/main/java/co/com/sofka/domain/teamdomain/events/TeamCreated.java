package co.com.sofka.domain.teamdomain.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.teamdomain.entity.Trainer;
import co.com.sofka.domain.teamdomain.values.Name;

public class TeamCreated extends DomainEvent {
    private final Name name;
    private final Trainer trainer;

    public TeamCreated(Name name, Trainer trainer){
        super("sofka.domain.teamdomain.teamcreated");
        this.name=name;
        this.trainer=trainer;
    }

    public Name getName(){
        return name;
    }

    public Trainer getTrainer(){
        return trainer;
    }
}
