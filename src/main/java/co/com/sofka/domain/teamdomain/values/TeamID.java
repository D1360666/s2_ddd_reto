package co.com.sofka.domain.teamdomain.values;

import co.com.sofka.domain.generic.Identity;

public class TeamID extends Identity {
    public TeamID() {

    }

    public TeamID(String id){
        super(id);
    }
    public static TeamID of(String id){
        return new TeamID(id);
    }
}
