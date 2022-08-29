package co.com.sofka.domain.secretarydomain.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.secretarydomain.values.Address;
import co.com.sofka.domain.secretarydomain.values.Name;
import co.com.sofka.domain.secretarydomain.values.Phone;
import co.com.sofka.domain.secretarydomain.values.UserID;

public class UserCreated extends DomainEvent {

    private final Name name;
    private final Address address;
    private final Phone phone;

    public UserCreated( Name name, Address address, Phone phone){
        super("sofka.domain.secretarydomain.usercreated");

        this.name = name;
        this.address = address;
        this.phone = phone;

    }

    public UserID getUserID() {
        return null;
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
