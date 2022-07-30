package co.com.sofka.domain.teamdomain;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.teamdomain.entity.Player;
import co.com.sofka.domain.teamdomain.entity.Trainer;
import co.com.sofka.domain.teamdomain.entity.Tutor;
import co.com.sofka.domain.teamdomain.events.*;
import co.com.sofka.domain.teamdomain.values.*;

import java.util.List;
import java.util.Objects;
import java.util.Set;


public class Team extends AggregateEvent<TeamID>{
    protected Set<Player>playerList;
    protected Set<Tutor> tutorList;
    protected Trainer trainer;
    protected Name name;

    public Team (TeamID entityId, Name name, Trainer trainer){
        super(entityId);
        appendChange(new TeamCreated(name, trainer)).apply();
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


    public void addTrainer(TrainerID trainerID, Name name, Address address, Phone phone, Ci ci){
        Objects.requireNonNull(trainerID);
        Objects.requireNonNull(name);
        Objects.requireNonNull(address);
        Objects.requireNonNull(phone);
        Objects.requireNonNull(ci);
        appendChange(new TrainerAdded(trainerID, name, address, phone, ci)).apply();
    }

    public void addPlayer(PlayerID playerID, Name name, Ci ci, Tutor tutor){
        appendChange(new PlayerAdded(playerID, name, ci, tutor)).apply();
    }

    public void addTutorToPlayer(PlayerID playerID, Tutor tutor){
        appendChange(new TutorAddedToPlayer(playerID, tutor)).apply();
    }

    public void updatedPlayer(PlayerID playerID, Name name, Ci ci, Tutor tutor){
        appendChange(new PlayerUpdated(playerID, name, ci, tutor)).apply();
    }

    public void updatedTrainer(TrainerID trainerID, Name name,Address address, Phone phone, Ci ci){
        appendChange(new TrainerUpdated(trainerID, name, address, phone, ci)).apply();
    }

    public void removePlayer(PlayerID playerID){
        appendChange(new PlayerRemoved(playerID)).apply();
    }

    public void removeTrainer(TrainerID trainerID){appendChange(new TrainerRemoved(trainerID)).apply();}


}
