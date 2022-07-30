package co.com.sofka.domain.teamdomain;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.teamdomain.entity.Player;
import co.com.sofka.domain.teamdomain.entity.Trainer;
import co.com.sofka.domain.teamdomain.entity.Tutor;
import co.com.sofka.domain.teamdomain.values.Name;
import co.com.sofka.domain.teamdomain.values.TeamID;

import java.util.List;
import java.util.Set;


public class Team extends AggregateEvent<TeamID>{
    protected Set<Player>playerList;
    protected Set<Tutor> tutorList;
    protected Trainer trainer;
    protected Name name;

    public Team (TeamID entityId, Name name){
        super(entityId);
        appendChange(new TeamCreated(name)).apply();
    }

    private Team(TeamID entityId){
        super(entityId);
        subscribe(new TeamChange(this));
    }

    public static Team from(TeamID teamID, List<DomainEvent> domainEvents){
        Team team = new Team(teamID);
        domainEvents.forEach(team::applyEvent);
        return team;
    }
}
