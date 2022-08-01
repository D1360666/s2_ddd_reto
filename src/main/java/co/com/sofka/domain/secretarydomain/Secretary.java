package co.com.sofka.domain.secretarydomain;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.secretarydomain.entity.Calendar;
import co.com.sofka.domain.secretarydomain.entity.Communication;
import co.com.sofka.domain.secretarydomain.entity.User;
import co.com.sofka.domain.secretarydomain.events.*;
import co.com.sofka.domain.secretarydomain.values.*;
import co.com.sofka.domain.secretarydomain.values.Name;


import javax.sound.midi.Receiver;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class Secretary extends AggregateEvent<SecretaryID> {

    protected Description description;
    protected User user;
    protected Set<Calendar> listCalendar;
    protected Set<Communication> listCommunications;

    public Description getDescription() {
        return description;
    }

    public User getUser() {
        return user;
    }

    public Set<Calendar> getListCalendar() {
        return listCalendar;
    }

    public Set<Communication> getListCommunications() {
        return listCommunications;
    }



    public Secretary (SecretaryID entityId, Description description, User user){
        super(entityId);
        appendChange(new SecretaryCreated(description, user)).apply();
    }

    private Secretary(SecretaryID entityID){
        super(entityID);
        subscribe(new SecretaryChange(this));
    }

    public static Secretary from(SecretaryID secretaryID, List<DomainEvent> domainEvents){
        Secretary secretary = new Secretary(secretaryID);
        domainEvents.forEach(secretary::applyEvent);
        return secretary;
    }


    public void addCalendar(CalendarID calendarID, Description description, DateOfEvent dateOfEvent, Place place){
        Objects.requireNonNull(calendarID);
        Objects.requireNonNull(dateOfEvent);
        Objects.requireNonNull(place);
        appendChange(new CalendarAdded(calendarID, description, dateOfEvent, place)).apply();
    }

    public void addUser(UserID userID, Name name, Address address, Phone phone){
        Objects.requireNonNull(userID);
        Objects.requireNonNull(name);
        Objects.requireNonNull(address);
        Objects.requireNonNull(phone);
        appendChange(new UserAdded(userID, name, address, phone)).apply();

    }

    public void addCommunication(CommunicationID communicationID, Description description, DateOfCommunication dateOfCommunication, Calendar calendar, SocialMedia socialMedia, Receiver receiver){
        appendChange(new CommunicationAdded(communicationID, description, dateOfCommunication, calendar, socialMedia, receiver)).apply();
    }

    public void updateCalendar(CalendarID calendarID, Description description, DateOfEvent dateOfEvent, Place place){
        Objects.requireNonNull(calendarID);
        Objects.requireNonNull(dateOfEvent);
        Objects.requireNonNull(place);
        appendChange(new CalendarUpdated(calendarID, description, dateOfEvent, place)).apply();
    }

    public void updateUser(UserID userID, Name name, Address address, Phone phone){
        Objects.requireNonNull(userID);
        Objects.requireNonNull(name);
        Objects.requireNonNull(address);
        Objects.requireNonNull(phone);
        appendChange(new UserUpdated(userID, name, address, phone)).apply();

    }

    public void updateCommunication(CommunicationID communicationID, Description description, DateOfCommunication dateOfCommunication, Calendar calendar, SocialMedia socialMedia, Receiver receiver){
        appendChange(new CommunicationUpdated(communicationID, description, dateOfCommunication, calendar, socialMedia, receiver)).apply();
    }

}
