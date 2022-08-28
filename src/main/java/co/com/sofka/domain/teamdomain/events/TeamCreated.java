package co.com.sofka.domain.teamdomain.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.teamdomain.entity.Trainer;
import co.com.sofka.domain.teamdomain.values.Name;

public class TeamCreated extends DomainEvent {
    private final Name name;


    public TeamCreated(Name name){
        super("sofka.domain.teamdomain.teamcreated");
        this.name=name;
    }

    public Name getName(){
        return name;
    }


}
