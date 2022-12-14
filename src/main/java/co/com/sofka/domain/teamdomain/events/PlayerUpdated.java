package co.com.sofka.domain.teamdomain.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.teamdomain.entity.Tutor;
import co.com.sofka.domain.teamdomain.values.Ci;
import co.com.sofka.domain.teamdomain.values.Name;
import co.com.sofka.domain.teamdomain.values.PlayerID;

public class PlayerUpdated extends DomainEvent{

    private PlayerID playerID;
    private Name name;
    private Ci ci;


    public PlayerUpdated(PlayerID playerID, Name name, Ci ci){
        super("sofka.domain.teamdomain.playerupdated");
        this.playerID = playerID;
        this.name = name;
        this.ci = ci;
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


}
