package co.com.sofka.domain.teamdomain.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.domain.teamdomain.entity.Tutor;
import co.com.sofka.domain.teamdomain.values.Ci;
import co.com.sofka.domain.teamdomain.values.Name;
import co.com.sofka.domain.teamdomain.values.PlayerID;

public class UpdatePlayer extends Command {
    private final PlayerID playerID;
    private final Name name;
    private final Ci ci;
    private final Tutor tutor;

    public UpdatePlayer(PlayerID playerID, Name name, Ci ci, Tutor tutor) {
        this.playerID = playerID;
        this.name = name;
        this.ci = ci;
        this.tutor = tutor;
    }

    public PlayerID getPlayerID() {
        return playerID;
    }

    public Name getName() {
        return name;
    }

    public Ci getCi() {
        return ci;
    }

    public Tutor getTutor() {
        return tutor;
    }
}
