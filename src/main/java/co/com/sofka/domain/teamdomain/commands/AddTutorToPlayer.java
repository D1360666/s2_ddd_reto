package co.com.sofka.domain.teamdomain.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.domain.teamdomain.entity.Tutor;
import co.com.sofka.domain.teamdomain.values.PlayerID;

public class AddTutorToPlayer extends Command {

    private final PlayerID playerID;
    private final Tutor tutor;

    public AddTutorToPlayer(PlayerID playerID, Tutor tutor) {
        this.playerID = playerID;
        this.tutor = tutor;
    }

    public PlayerID getPlayerID() {
        return playerID;
    }

    public Tutor getTutor() {
        return tutor;
    }
}
