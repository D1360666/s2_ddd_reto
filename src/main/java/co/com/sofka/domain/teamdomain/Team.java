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
    protected static Set<Player>playerList;
    protected static Trainer trainer;
    protected static Set<Tutor> tutorList;
    protected static Name name;
    protected static PlayerID playerID;
    protected static Address address;
    protected static Phone phone;
    protected static TrainerID trainerID;
    protected static Ci ci;

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

    public void createTrainer(TrainerID trainerID, Name name, Address address, Phone phone, Ci ci){
        this.trainerID = Objects.requireNonNull(trainerID);
        this.name = Objects.requireNonNull(name);
        this.address = Objects.requireNonNull(address);
        this.phone = Objects.requireNonNull(phone);
        this.ci = Objects.requireNonNull(ci);
        appendChange(new TrainerCreated( name, address, phone, ci)).apply();
    }

    public void createPlayer(PlayerID playerID, Name name, Ci ci) {
        this.playerID = Objects.requireNonNull(playerID);
        this.name = Objects.requireNonNull(name);
        this.ci = Objects.requireNonNull(ci);
        appendChange(new PlayerCreated(name, ci)).apply();
    }
    public void addPlayer(Player player){
        this.playerList.add(player);
    }

    public void addTutorToPlayer(PlayerID playerID, Tutor tutor){
        appendChange(new TutorAddedToPlayer(playerID, tutor)).apply();
    }

    public void updatedPlayer(PlayerID playerID, Name name, Ci ci){
        appendChange(new PlayerUpdated(playerID, name, ci )).apply();
    }

    public void updatedTrainer(TrainerID trainerID, Name name,Address address, Phone phone, Ci ci){
        appendChange(new TrainerUpdated(trainerID, name, address, phone, ci)).apply();
    }

    public void removePlayer(PlayerID playerID){
        appendChange(new PlayerRemoved(playerID)).apply();
    }

    public void removeTrainer(TrainerID trainerID){appendChange(new TrainerRemoved(trainerID)).apply();}

    public void TeamCreated(Name name) {
        appendChange(new TeamCreated(name)).apply();
    }

}
