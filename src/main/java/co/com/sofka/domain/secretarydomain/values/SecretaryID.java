package co.com.sofka.domain.secretarydomain.values;

import co.com.sofka.domain.generic.Identity;
import co.com.sofka.domain.teamdomain.values.TeamID;

public class SecretaryID extends Identity {
    public SecretaryID() {

    }

    private SecretaryID(String id){
        super(id);
    }
    public static SecretaryID of(String id){
        return new SecretaryID(id);
    }
}
