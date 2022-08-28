package co.com.sofka.domain.teamdomain.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.domain.teamdomain.values.Ci;
import co.com.sofka.domain.teamdomain.values.Name;
import co.com.sofka.domain.teamdomain.values.TeamID;
import co.com.sofka.domain.teamdomain.values.TutorID;

public class CreateTutor extends Command {
    private TutorID tutorID;
    private Name name;
    private Ci ci;

    private TeamID teamID;
    public CreateTutor(TutorID tutorID, Name name, Ci ci, TeamID teamID) {
        this.tutorID = tutorID;
        this.name = name;
        this.ci = ci;
        this.teamID = teamID;
    }

    public TutorID getTutorID() {
        return tutorID;
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
