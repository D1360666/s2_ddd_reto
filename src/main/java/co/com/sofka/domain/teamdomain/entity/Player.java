package co.com.sofka.domain.teamdomain.entity;

import co.com.sofka.domain.generic.Entity;
import co.com.sofka.domain.teamdomain.values.Ci;
import co.com.sofka.domain.teamdomain.values.Name;
import co.com.sofka.domain.teamdomain.values.PlayerID;

import java.util.Objects;

public class Player extends Entity<PlayerID> {
    public static PlayerID playerID;
    public static Name name;
    public static Ci ci;

    public Player(PlayerID playerID, Name name, Ci ci){
       super(playerID);
       this.playerID = playerID;
       this.name= name;
       this.ci=ci;
    }

    public Player(PlayerID playerID){
        super(playerID);
    }

    public void createPlayer(PlayerID playerID, Name name, Ci ci){
        this.playerID = Objects.requireNonNull(playerID);
        this.name = Objects.requireNonNull(name);
        this.ci = Objects.requireNonNull(ci);
    }

    public static Name name(){
        return name;
    }

    public static Ci ci(){
        return ci;
    }
    public static PlayerID playerID(){return playerID;}

}
