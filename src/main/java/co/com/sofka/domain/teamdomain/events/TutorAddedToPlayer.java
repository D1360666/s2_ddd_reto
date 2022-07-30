package co.com.sofka.domain.teamdomain.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.teamdomain.entity.Tutor;
import co.com.sofka.domain.teamdomain.values.PlayerID;
import co.com.sofka.domain.teamdomain.values.TutorID;

public class TutorAddedToPlayer extends DomainEvent {
    private final PlayerID playerID;
    private final Tutor tutor;

    public TutorAddedToPlayer(PlayerID playerID, Tutor tutor){
        super("sofka.domain.teamdomain.tutoraddedtoplayer");
        this.playerID=playerID;
        this.tutor=tutor;
    }

    public PlayerID getPlayerID(){
        return playerID;
    }

    public Tutor getTutor(){
        return tutor;
    }
}
