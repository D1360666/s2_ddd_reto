package co.com.sofka.domain.teamdomain.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.teamdomain.entity.Tutor;
import co.com.sofka.domain.teamdomain.values.Ci;
import co.com.sofka.domain.teamdomain.values.Name;
import co.com.sofka.domain.teamdomain.values.PlayerID;

public class PlayerAdded extends DomainEvent {

    private PlayerID playerID;
    private Name name;
    private Ci ci;
    private Tutor tutor;

    public PlayerAdded(PlayerID playerID, Name name, Ci ci, Tutor tutor){
        super("sofka.domain.teamdomain.playeradded");
        this.playerID = playerID;
        this.name = name;
        this.ci = ci;
        this.tutor = tutor;

    }

    public PlayerID getPlayerID(){
        return playerID;
    }

    public Name getName(){
        return name;
    }

    public Ci getCi(){
        return ci;
    }

    public Tutor getTutor(){
        return tutor;
    }


}
