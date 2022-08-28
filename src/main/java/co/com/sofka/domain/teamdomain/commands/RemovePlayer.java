package co.com.sofka.domain.teamdomain.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.domain.teamdomain.values.*;

public class RemovePlayer extends Command {

    private final PlayerID playerID;

    public RemovePlayer(PlayerID playerID) {
        this.playerID = playerID;
    }

    public PlayerID getPlayerID() {
        return playerID;
    }
}
