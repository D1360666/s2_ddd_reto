package co.com.sofka.domain.teamdomain;

import co.com.sofka.domain.generic.EventChange;
import co.com.sofka.domain.teamdomain.events.TeamCreated;

import java.util.HashSet;

public class TeamChange extends EventChange {
    public TeamChange(Team team){
        apply((TeamCreated event)-> {
            team.name = event.getName();
            team.playerList= new HashSet<>();
            team.tutorList=new HashSet<>();

        });
    }
}
