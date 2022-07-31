package co.com.sofka.domain.secretarydomain.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.secretarydomain.values.Address;
import co.com.sofka.domain.secretarydomain.values.Name;
import co.com.sofka.domain.secretarydomain.values.Phone;
import co.com.sofka.domain.secretarydomain.values.UserID;

public class UserUpdated extends DomainEvent {
    private UserID userID;
    private Name name;
    private Address address;
    private Phone phone;

    public UserUpdated(UserID userID, Name name, Address address, Phone phone){
        super("sofka.domain.secretarydomain.usercreated");
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
