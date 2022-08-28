package co.com.sofka.domain.teamdomain.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.domain.teamdomain.entity.*;
import co.com.sofka.domain.teamdomain.values.*;


public class CreateTeam extends Command {

    private final TeamID teamID;
    private final Name name;

    public CreateTeam(TeamID teamID, Name name){
        this.teamID = teamID;
        this.name = name;

    }

    public TeamID getTeamID() {
        return teamID;
    }

    public Name getName() {
        return name;
    }

}
