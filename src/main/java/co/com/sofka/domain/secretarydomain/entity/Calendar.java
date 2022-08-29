package co.com.sofka.domain.secretarydomain.entity;

import co.com.sofka.domain.generic.Entity;
import co.com.sofka.domain.secretarydomain.values.*;

import java.util.Date;
import java.util.Objects;

public class Calendar extends Entity<CalendarID> {
    public static CalendarID calendarID;

    public static Description description;
    public static DateOfEvent dateOfEvent;
    public static Place place;

    public Calendar(CalendarID entityId, Description description, DateOfEvent dateOfEvent, Place place) {
        super(entityId);
        this.description = description;
        this.dateOfEvent = dateOfEvent;
        this.place = place;
        this.calendarID = entityId;
    }

    public Description description() {
        return description;
    }

    public DateOfEvent dateOfEvent() {
        return dateOfEvent;
    }

    public Place place() {
        return place;
    }
    public CalendarID calendarID(){return calendarID;}
}
