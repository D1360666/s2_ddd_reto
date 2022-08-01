package co.com.sofka.domain.teamdomain.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.domain.teamdomain.entity.Trainer;
import co.com.sofka.domain.teamdomain.values.Name;
import co.com.sofka.domain.teamdomain.values.TeamID;

public class CreateTeam extends Command {

    private final TeamID teamID;
    private final Name name;
    private final Trainer trainer;

    public CreateTeam(TeamID teamID, Name name, Trainer trainer){
        this.teamID = teamID;
        this.name = name;
        this.trainer = trainer;
    }

    public TeamID getTeamID() {
        return teamID;
    }

    public Name getName() {
        return name;
    }

    public Trainer getTrainer() {
        return trainer;
    }
}
