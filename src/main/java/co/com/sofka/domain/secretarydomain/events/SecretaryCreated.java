package co.com.sofka.domain.secretarydomain.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.secretarydomain.entity.User;
import co.com.sofka.domain.secretarydomain.values.Description;
import co.com.sofka.domain.secretarydomain.values.Name;

public class SecretaryCreated extends DomainEvent {
    private final Name name;
    public SecretaryCreated(Name name){
        super("sofka.domain.secretarydomain.secretarycreated");
        this.name = name;


    }

    public Name getName() {
        return name;
    }


}
