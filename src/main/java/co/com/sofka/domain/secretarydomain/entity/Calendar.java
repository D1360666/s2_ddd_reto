package co.com.sofka.domain.secretarydomain.entity;

import co.com.sofka.domain.generic.Entity;
import co.com.sofka.domain.secretarydomain.values.CalendarID;
import co.com.sofka.domain.secretarydomain.values.DateOfEvent;
import co.com.sofka.domain.secretarydomain.values.Description;
import co.com.sofka.domain.secretarydomain.values.Place;
import co.com.sofka.domain.teamdomain.entity.Player;

import java.util.Date;
import java.util.Objects;

public class Calendar extends Entity<CalendarID> {
    private CalendarID calendarID;
    private Description description;
    private DateOfEvent dateOfEvent;
    private Place place;

    public Calendar(CalendarID entityId, Description description, DateOfEvent dateOfEvent, Place place) {
        super(entityId);
        this.description = description;
        this.dateOfEvent = dateOfEvent;
        this.place = place;
    }

    public void updateDescription(Description description){this.description= Objects.requireNonNull(description);}
    public void updateDateOfEvent(DateOfEvent dateOfEvent){this.dateOfEvent= Objects.requireNonNull(dateOfEvent);}
    public void updatePlace(Place place){this.place= Objects.requireNonNull(place);}

    public Description description() {
        return description;
    }

    public DateOfEvent dateOfEvent() {
        return dateOfEvent;
    }

    public Place place() {
        return place;
    }
}
