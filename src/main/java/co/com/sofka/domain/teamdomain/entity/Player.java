package co.com.sofka.domain.teamdomain.entity;

import co.com.sofka.domain.generic.Entity;
import co.com.sofka.domain.teamdomain.values.Ci;
import co.com.sofka.domain.teamdomain.values.Name;
import co.com.sofka.domain.teamdomain.values.PlayerID;

import java.util.Objects;

public class Player extends Entity<PlayerID> {

    private Name name;
    private Ci ci;

    private Tutor tutor;

    public Player(PlayerID playerID, Name name, Ci ci, Tutor tutor){
       super(playerID);
       this.name= name;
       this.ci=ci;
       this.tutor=tutor;
    }

    public void updateName(Name name){
        this.name = Objects.requireNonNull(name);
    }

    public void updateCi(Ci ci){
        this.ci = Objects.requireNonNull(ci);
    }

    public void updateTutor(Tutor tutor){
        this.tutor = Objects.requireNonNull(tutor);
    }

    public Name name(){
        return name;
    }

    public Ci ci(){
        return ci;
    }

    public Tutor tutor(){
        return tutor;
    }
}
