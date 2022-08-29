package co.com.sofka.domain.secretarydomain.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.domain.secretarydomain.events.SecretaryCreated;
import co.com.sofka.domain.secretarydomain.values.*;

public class CreateCalendar extends Command {
    private final CalendarID calendarID;
    private final Description description;
    private final DateOfEvent dateOfEvent;
    private final Place place;
    private SecretaryID secretaryID;


    public CreateCalendar(CalendarID calendarID, Description description, DateOfEvent dateOfEvent, Place place, SecretaryID secretaryID) {
        this.calendarID = calendarID;
        this.description = description;
        this.dateOfEvent = dateOfEvent;
        this.place = place;
        this.secretaryID = secretaryID;
    }

    public CalendarID getCalendarID() {
        return calendarID;
    }

    public Description getDescription() {
        return description;
    }

    public DateOfEvent getDateOfEvent() {
        return dateOfEvent;
    }

    public Place getPlace() {
        return place;
    }

    public SecretaryID getSecretaryID(){
        return secretaryID;
    }
}
