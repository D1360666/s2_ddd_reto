package co.com.sofka.domain.secretarydomain.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.secretarydomain.entity.Calendar;
import co.com.sofka.domain.secretarydomain.values.CommunicationID;
import co.com.sofka.domain.secretarydomain.values.DateOfCommunication;
import co.com.sofka.domain.secretarydomain.values.Description;
import co.com.sofka.domain.secretarydomain.values.SocialMedia;

import javax.sound.midi.Receiver;

public class CommunicationAdded extends DomainEvent {
    private CommunicationID communicationID;
    private Description description;
    private DateOfCommunication dateOfCommunication;
    private Calendar calendar;
    private SocialMedia socialMedia;
    private Receiver receiver;

    public CommunicationAdded(CommunicationID communicationID, Description description, DateOfCommunication dateOfCommunication, Calendar calendar, SocialMedia socialMedia, Receiver receiver){
        super("sofka.domain.secretarydomain.communicationadded");
        this.communicationID = communicationID;
        this.description = description;
        this.dateOfCommunication = dateOfCommunication;
        this.calendar = calendar;
        this.socialMedia = socialMedia;
        this.receiver = receiver;

    }

    public CommunicationID getCommunicationID() {
        return communicationID;
    }

    public Description getDescription() {
        return description;
    }

    public DateOfCommunication getDateOfCommunication() {
        return dateOfCommunication;
    }

    public Calendar getCalendar() {
        return calendar;
    }

    public SocialMedia getSocialMedia() {
        return socialMedia;
    }

    public Receiver getReceiver() {
        return receiver;
    }
}
