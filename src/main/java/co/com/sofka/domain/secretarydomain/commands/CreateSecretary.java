package co.com.sofka.domain.secretarydomain.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.domain.secretarydomain.entity.User;
import co.com.sofka.domain.secretarydomain.values.Description;
import co.com.sofka.domain.secretarydomain.values.SecretaryID;

public class CreateSecretary extends Command {
    private final SecretaryID secretaryID;
    private final Description description;
    private final User user;

    public CreateSecretary(SecretaryID secretaryID, Description description, User user) {
        this.secretaryID = secretaryID;
        this.description = description;
        this.user = user;
    }

    public SecretaryID getSecretaryID() {
        return secretaryID;
    }

    public Description getDescription() {
        return description;
    }

    public User getUser() {
        return user;
    }
}
