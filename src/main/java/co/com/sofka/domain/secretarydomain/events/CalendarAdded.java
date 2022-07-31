package co.com.sofka.domain.secretarydomain.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.secretarydomain.values.CalendarID;
import co.com.sofka.domain.secretarydomain.values.DateOfEvent;
import co.com.sofka.domain.secretarydomain.values.Description;
import co.com.sofka.domain.secretarydomain.values.Place;

public class CalendarAdded extends DomainEvent {
    private CalendarID calendarID;
    private Description description;
    private DateOfEvent dateOfEvent;
    private Place place;

    public CalendarAdded(CalendarID calendarID, Description description, DateOfEvent dateOfEvent, Place place){
        super("sofka.domain.secretarydomain.calendaradded");
        this.calendarID = calendarID;
        this.description = description;
        this.dateOfEvent= dateOfEvent;
        this.place = place;
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
}
