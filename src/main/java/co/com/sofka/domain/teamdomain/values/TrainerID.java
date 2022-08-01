package co.com.sofka.domain.teamdomain.values;

import co.com.sofka.domain.generic.Identity;

public class TrainerID extends Identity {
    public TrainerID() {

    }

    public TrainerID(String id){
        super(id);
    }
    public static TrainerID of(String id){
        return new TrainerID(id);
    }
}
