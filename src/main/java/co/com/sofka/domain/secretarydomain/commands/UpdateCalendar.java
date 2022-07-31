package co.com.sofka.domain.secretarydomain.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.domain.secretarydomain.values.CalendarID;
import co.com.sofka.domain.secretarydomain.values.DateOfEvent;
import co.com.sofka.domain.secretarydomain.values.Description;
import co.com.sofka.domain.secretarydomain.values.Place;

public class UpdateCalendar extends Command {
    private CalendarID calendarID;
    private Description description;
    private DateOfEvent dateOfEvent;
    private Place place;

    public UpdateCalendar(CalendarID calendarID, Description description, DateOfEvent dateOfEvent, Place place) {
        this.calendarID = calendarID;
        this.description = description;
        this.dateOfEvent = dateOfEvent;
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
