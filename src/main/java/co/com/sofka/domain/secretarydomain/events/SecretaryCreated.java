package co.com.sofka.domain.secretarydomain.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.secretarydomain.entity.User;
import co.com.sofka.domain.secretarydomain.values.Description;

public class SecretaryCreated extends DomainEvent {
    private final Description description;
    private final User user;

    public SecretaryCreated(Description description, User user){
        super("sofka.domain.secretarydomain.secretarycreated");
        this.description = description;
        this.user = user;

    }

    public Description getDescription() {
        return description;
    }

    public User getUser() {
        return user;
    }
}
