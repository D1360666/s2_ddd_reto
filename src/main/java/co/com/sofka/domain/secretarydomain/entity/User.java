package co.com.sofka.domain.secretarydomain.entity;

import co.com.sofka.domain.generic.Entity;
import co.com.sofka.domain.secretarydomain.values.Address;
import co.com.sofka.domain.secretarydomain.values.Name;
import co.com.sofka.domain.secretarydomain.values.Phone;
import co.com.sofka.domain.secretarydomain.values.UserID;


import java.util.Objects;

public class User extends Entity<UserID> {

    public static UserID userID;
    public static Address address;
    public static Phone phone;
    public static Name name;

    public User(UserID entityId, Name name, Address address, Phone phone) {
        super(entityId);
        this.name = name;
        this.address = address;
        this.phone = phone;
    }
    public void updateName(Name name){this.name= Objects.requireNonNull(name);}
    public void updateAddress(Address address){this.address= Objects.requireNonNull(address);}
    public void updatePhone(Phone phone){this.phone= Objects.requireNonNull(phone);}

    public Name name() {
        return name;
    }

    public Address address() {
        return address;
    }

    public Phone phone() {
        return phone;
    }
}
