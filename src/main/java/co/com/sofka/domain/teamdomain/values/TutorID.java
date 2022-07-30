package co.com.sofka.domain.teamdomain.values;

import co.com.sofka.domain.generic.Identity;


public class TutorID extends Identity {
    public TutorID() {

    }

    private TutorID(String id){
        super(id);
    }
    public static TutorID of(String id){
        return new TutorID(id);
    }
}
