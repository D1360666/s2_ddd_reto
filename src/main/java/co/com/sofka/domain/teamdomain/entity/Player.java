package co.com.sofka.domain.teamdomain.entity;

import co.com.sofka.domain.generic.Entity;
import co.com.sofka.domain.teamdomain.values.Ci;
import co.com.sofka.domain.teamdomain.values.Name;
import co.com.sofka.domain.teamdomain.values.PlayerID;

import java.util.Objects;

public class Player extends Entity<PlayerID> {

    private Name name;
    private Ci ci;

    public Player(PlayerID playerID, Name name, Ci ci){
       super(playerID);
       this.name= name;
       this.ci=ci;
    }

    public void updateName(Name name){
        this.name = Objects.requireNonNull(name);
    }

    public void updateCi(Ci ci){
        this.ci = Objects.requireNonNull(ci);
    }

    public Name name(){
        return name;
    }

    public Ci ci(){
        return ci;
    }
}
