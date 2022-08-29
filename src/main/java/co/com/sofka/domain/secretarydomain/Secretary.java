package co.com.sofka.domain.secretarydomain;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.secretarydomain.entity.Calendar;
import co.com.sofka.domain.secretarydomain.entity.Communication;
import co.com.sofka.domain.secretarydomain.events.*;
import co.com.sofka.domain.secretarydomain.values.*;
import co.com.sofka.domain.secretarydomain.values.Name;

import java.util.List;
import java.util.Objects;
import java.util.Set;

public class Secretary extends AggregateEvent<SecretaryID> {

    protected static Name name;
    protected static Description description;
    protected static Set<Calendar> listCalendar;
    protected static Set<Communication> listCommunications;
    protected  static SecretaryID secretaryID;
    protected  static CalendarID calendarID;
    protected static DateOfEvent dateOfEvent;
    protected static Place place;


    public Secretary (SecretaryID entityId, Name name){
        super(entityId);
        appendChange(new SecretaryCreated(name)).apply();
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
    public Name name() {
        return name;
    }
    public SecretaryID getSecretaryID(){return secretaryID;}

    public Set<Calendar> getListCalendar() {
        return listCalendar;
    }

    public Set<Communication> getListCommunications() {
        return listCommunications;
    }

    public void SecretaryCreated(Name name){appendChange(new SecretaryCreated(name)).apply();}
    public void createCalendar(CalendarID calendarID, Description description, DateOfEvent dateOfEvent, Place place){
        this.calendarID = Objects.requireNonNull(calendarID);
        this.description = Objects.requireNonNull(description);
        this.dateOfEvent = Objects.requireNonNull(dateOfEvent);
        this.place = Objects.requireNonNull(place);
        appendChange(new CalendarCreated(description, dateOfEvent, place)).apply();
    }

    public void updateCalendar(CalendarID calendarID, Description description, DateOfEvent dateOfEvent, Place place){
        Objects.requireNonNull(calendarID);
        Objects.requireNonNull(dateOfEvent);
        Objects.requireNonNull(place);
        appendChange(new CalendarUpdated(calendarID, description, dateOfEvent, place)).apply();
    }
    public void createUser(UserID userID, Name name, Address address, Phone phone){
        Objects.requireNonNull(userID);
        Objects.requireNonNull(name);
        Objects.requireNonNull(address);
        Objects.requireNonNull(phone);
        appendChange(new UserCreated(name, address, phone)).apply();

    }

    public void updateUser(UserID userID, Name name, Address address, Phone phone){
        Objects.requireNonNull(userID);
        Objects.requireNonNull(name);
        Objects.requireNonNull(address);
        Objects.requireNonNull(phone);
        appendChange(new UserUpdated(userID, name, address, phone)).apply();

    }

    public void createCommunication(CommunicationID communicationID, Description description, DateOfCommunication dateOfCommunication,  SocialMedia socialMedia){
        Objects.requireNonNull(communicationID);
        Objects.requireNonNull(description);
        Objects.requireNonNull(dateOfCommunication);

        Objects.requireNonNull(socialMedia);
        appendChange(new CommunicationCreated(description, dateOfCommunication, socialMedia)).apply();
    }


}
