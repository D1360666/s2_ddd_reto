package co.com.sofka.domain.teamdomain.values;

import co.com.sofka.domain.generic.Identity;

public class PlayerID extends Identity {

    public PlayerID() {

    }

    private PlayerID(String id){
        super(id);
    }
    public static PlayerID of(String id){
        return new PlayerID(id);
    }


}
