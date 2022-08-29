package co.com.sofka.domain.secretarydomain.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.domain.secretarydomain.Secretary;
import co.com.sofka.domain.secretarydomain.entity.Calendar;
import co.com.sofka.domain.secretarydomain.values.*;


public class CreateCommunication extends Command {
    private final CommunicationID communicationID;
    private final Description description;
    private final DateOfCommunication dateOfCommunication;

    private final SocialMedia socialMedia;
    private final SecretaryID secretaryID;

    public CreateCommunication(CommunicationID communicationID, Description description, DateOfCommunication dateOfCommunication, SocialMedia socialMedia, SecretaryID secretaryID) {
        this.communicationID = communicationID;
        this.description = description;
        this.dateOfCommunication = dateOfCommunication;
        this.socialMedia = socialMedia;
        this.secretaryID = secretaryID;
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

    public SecretaryID getSecretaryID() {
        return secretaryID;
    }
}
