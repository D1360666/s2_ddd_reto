package co.com.sofka.domain.secretarydomain.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.secretarydomain.entity.Calendar;
import co.com.sofka.domain.secretarydomain.values.CommunicationID;
import co.com.sofka.domain.secretarydomain.values.DateOfCommunication;
import co.com.sofka.domain.secretarydomain.values.Description;
import co.com.sofka.domain.secretarydomain.values.SocialMedia;


public class CommunicationCreated extends DomainEvent {
    private CommunicationID communicationID;
    private Description description;
    private DateOfCommunication dateOfCommunication;
    private SocialMedia socialMedia;


    public CommunicationCreated(Description description, DateOfCommunication dateOfCommunication, SocialMedia socialMedia){
        super("sofka.domain.secretarydomain.communicationadded");

        this.description = description;
        this.dateOfCommunication = dateOfCommunication;
        this.socialMedia = socialMedia;


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

    public SocialMedia getSocialMedia() {
        return socialMedia;
    }


}
