package co.com.sofka.domain.secretarydomain.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.domain.secretarydomain.values.*;

public class CreateUser extends Command {
    private final UserID userID;
    private final Name name;
    private final Address address;
    private final Phone phone;
private final SecretaryID secretaryID;
    public CreateUser(UserID userID, Name name, Address address, Phone phone, SecretaryID secretaryID) {
        this.userID = userID;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.secretaryID = secretaryID;

    }

    public UserID getUserID() {
        return userID;
    }

    public Name getName() {
        return name;
    }

    public Address getAddress() {
        return address;
    }

    public Phone getPhone() {
        return phone;
    }

    public SecretaryID getSecretaryID() {
        return secretaryID;
    }
}
