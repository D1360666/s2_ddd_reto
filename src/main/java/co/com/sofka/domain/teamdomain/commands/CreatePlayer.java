package co.com.sofka.domain.teamdomain.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.domain.teamdomain.entity.Tutor;
import co.com.sofka.domain.teamdomain.values.Ci;
import co.com.sofka.domain.teamdomain.values.Name;
import co.com.sofka.domain.teamdomain.values.PlayerID;
import co.com.sofka.domain.teamdomain.values.TeamID;

public class CreatePlayer extends Command {
    private final PlayerID playerID;
    private final Name name;
    private final Ci ci;
    private final TeamID teamID;

    public CreatePlayer(PlayerID playerID, Name name, Ci ci, TeamID teamID) {
        this.playerID = playerID;
        this.name = name;
        this.ci = ci;
        this.teamID = teamID;
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

    public TeamID getTeamID() {
        return teamID;
    }
}

