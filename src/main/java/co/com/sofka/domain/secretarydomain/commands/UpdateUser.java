package co.com.sofka.domain.secretarydomain.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.domain.secretarydomain.values.Address;
import co.com.sofka.domain.secretarydomain.values.Name;
import co.com.sofka.domain.secretarydomain.values.Phone;
import co.com.sofka.domain.secretarydomain.values.UserID;

public class UpdateUser extends Command {
    private final UserID userID;
    private final Name name;
    private final Address address;
    private final Phone phone;

    public UpdateUser(UserID userID, Name name, Address address, Phone phone) {
        this.userID = userID;
        this.name = name;
        this.address = address;
        this.phone = phone;
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
}
