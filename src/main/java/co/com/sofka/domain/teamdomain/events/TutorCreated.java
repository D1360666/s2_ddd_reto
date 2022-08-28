package co.com.sofka.domain.teamdomain.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.teamdomain.values.Ci;
import co.com.sofka.domain.teamdomain.values.Name;
import co.com.sofka.domain.teamdomain.values.PlayerID;

public class TutorCreated extends DomainEvent {

    private final Name name;
    private final Ci ci;

    public TutorCreated(Name name, Ci ci){
        super("sofka.domain.teamdomain.tutorcreated");
        this.name = name;
        this.ci = ci;
    }


    public PlayerID getPlayerID(){return null;}

    public Name getName(){
        return name;
    }

    public Ci getCi(){
        return ci;
    }
}
