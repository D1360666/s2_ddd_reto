package co.com.sofka.domain.secretarydomain.values;

import co.com.sofka.domain.generic.Identity;

public class CommunicationID extends Identity {
    public CommunicationID() {

    }

    private CommunicationID(String id){
        super(id);
    }
    public static CommunicationID of(String id){
        return new CommunicationID(id);
    }
}
