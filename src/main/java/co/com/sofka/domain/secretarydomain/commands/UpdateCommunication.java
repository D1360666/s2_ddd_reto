package co.com.sofka.domain.secretarydomain.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.domain.secretarydomain.entity.Calendar;
import co.com.sofka.domain.secretarydomain.values.CommunicationID;
import co.com.sofka.domain.secretarydomain.values.DateOfCommunication;
import co.com.sofka.domain.secretarydomain.values.Description;
import co.com.sofka.domain.secretarydomain.values.SocialMedia;
import org.springframework.aop.scope.DefaultScopedObject;

import javax.sound.midi.Receiver;

public class UpdateCommunication extends Command {
    private final CommunicationID communicationID;
    private final Description description;
    private final DateOfCommunication dateOfCommunication;
    private final Calendar calendar;
    private final SocialMedia socialMedia;
    private final Receiver receiver;

    public UpdateCommunication(CommunicationID communicationID, Description description, DateOfCommunication dateOfCommunication, Calendar calendar, SocialMedia socialMedia, Receiver receiver) {
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
