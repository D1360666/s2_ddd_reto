package co.com.sofka.domain.secretarydomain.entity;

import co.com.sofka.domain.generic.Entity;
import co.com.sofka.domain.secretarydomain.values.CommunicationID;
import co.com.sofka.domain.secretarydomain.values.DateOfCommunication;
import co.com.sofka.domain.secretarydomain.values.Description;
import co.com.sofka.domain.secretarydomain.values.SocialMedia;
import co.com.sofka.domain.teamdomain.entity.Player;

import javax.sound.midi.Receiver;
import java.util.Date;
import java.util.Objects;

public class Communication extends Entity<CommunicationID> {
    private CommunicationID communicationID;
    private Description description;
    private DateOfCommunication dateOfCommunication;
    private Calendar calendar;
    private SocialMedia socialMedia;
    private Receiver receiver;

    public Communication(CommunicationID entityId, CommunicationID communicationID, Description description, DateOfCommunication dateOfCommunication, Calendar calendar, SocialMedia socialMedia, Receiver receiver) {
        super(entityId);
        this.communicationID = communicationID;
        this.description = description;
        this.dateOfCommunication = dateOfCommunication;
        this.calendar = calendar;
        this.socialMedia = socialMedia;
        this.receiver = receiver;
    }

    public void updateDescription(Description description){this.description= Objects.requireNonNull(description);}
    public void updateDateOfCommunication(DateOfCommunication dateOfCommunication){this.dateOfCommunication= Objects.requireNonNull(dateOfCommunication);}
    public void updateCalendar(Calendar calendar){this.calendar= Objects.requireNonNull(calendar);}
    public void updateSocialMedia(SocialMedia socialMedia){this.socialMedia= Objects.requireNonNull(socialMedia);}
    public void updateReceiver(Receiver receiver){this.receiver= Objects.requireNonNull(receiver);}

    public Description description() {
        return description;
    }

    public DateOfCommunication dateOfCommunication() {
        return dateOfCommunication;
    }

    public Calendar calendar() {
        return calendar;
    }

    public SocialMedia socialMedia() {
        return socialMedia;
    }

    public Receiver getReceiver() {
        return receiver;
    }
}
