package co.com.sofka.domain.secretarydomain.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.secretarydomain.values.CalendarID;
import co.com.sofka.domain.secretarydomain.values.DateOfEvent;
import co.com.sofka.domain.secretarydomain.values.Description;
import co.com.sofka.domain.secretarydomain.values.Place;

public class CalendarCreated extends DomainEvent {
    private final Description description;
    private final DateOfEvent dateOfEvent;
    private final Place place;

    public CalendarCreated(Description description, DateOfEvent dateOfEvent, Place place){
        super("sofka.domain.secretarydomain.calendaradded");
        this.description = description;
        this.dateOfEvent= dateOfEvent;
        this.place = place;
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

    public CalendarID getCalendarID() {
        return null;
    }
}
