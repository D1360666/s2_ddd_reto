package co.com.sofka.domain.treasurydomain.values;

import co.com.sofka.domain.generic.Identity;

public class MovementID extends Identity {
    public MovementID(){

    }

    private MovementID(String id){super(id);}

    public static MovementID of(String id){return new MovementID(id);}
}
