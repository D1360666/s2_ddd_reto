package co.com.sofka.domain.secretarydomain.values;

import co.com.sofka.domain.generic.Identity;

public class UserID extends Identity {
    public UserID() {

    }

    public UserID(String id){
        super(id);
    }
    public static UserID of(String id){
        return new UserID(id);
    }
}
