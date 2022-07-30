package co.com.sofka.domain.teamdomain.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.teamdomain.values.PlayerID;

public class PlayerRemoved extends DomainEvent {
    private final PlayerID playerID;

    public PlayerRemoved(PlayerID playerID){
        super("sofka.domain.teamdomain.playerremoved");
        this.playerID = playerID;
    }

    public PlayerID getPlayerID(){
        return playerID;
    }
}
