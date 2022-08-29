package co.com.sofka.domain.secretarydomain.entity;

import co.com.sofka.domain.generic.Entity;
import co.com.sofka.domain.secretarydomain.values.CommunicationID;
import co.com.sofka.domain.secretarydomain.values.DateOfCommunication;
import co.com.sofka.domain.secretarydomain.values.Description;
import co.com.sofka.domain.secretarydomain.values.SocialMedia;




import java.util.Objects;

public class Communication extends Entity<CommunicationID> {
    public static CommunicationID communicationID;
    public static Description description;
    public static DateOfCommunication dateOfCommunication;
    public static Calendar calendar;
    public static SocialMedia socialMedia;


    public Communication(CommunicationID entityId,  Description description, DateOfCommunication dateOfCommunication, Calendar calendar, SocialMedia socialMedia) {
        super(entityId);
       // this.communicationID = communicationID;
        this.description = description;
        this.dateOfCommunication = dateOfCommunication;
        this.calendar = calendar;
        this.socialMedia = socialMedia;

    }

    public void updateDescription(Description description){this.description= Objects.requireNonNull(description);}
    public void updateDateOfCommunication(DateOfCommunication dateOfCommunication){this.dateOfCommunication= Objects.requireNonNull(dateOfCommunication);}
    public void updateCalendar(Calendar calendar){this.calendar= Objects.requireNonNull(calendar);}
    public void updateSocialMedia(SocialMedia socialMedia){this.socialMedia= Objects.requireNonNull(socialMedia);}


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


}
