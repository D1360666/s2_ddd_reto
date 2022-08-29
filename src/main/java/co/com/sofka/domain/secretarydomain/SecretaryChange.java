package co.com.sofka.domain.secretarydomain;

import co.com.sofka.domain.generic.EventChange;
import co.com.sofka.domain.secretarydomain.entity.Calendar;
import co.com.sofka.domain.secretarydomain.entity.Communication;
import co.com.sofka.domain.secretarydomain.entity.User;
import co.com.sofka.domain.secretarydomain.events.*;

public class SecretaryChange extends EventChange {

    public SecretaryChange(Secretary secretary){
        apply((SecretaryCreated event)->{
           secretary.name = event.getName();
        });

        apply((CalendarCreated event)->{
            Calendar.calendarID = event.getCalendarID();
            Calendar.description = event.getDescription();
            Calendar.dateOfEvent = event.getDateOfEvent();
            Calendar.place = event.getPlace();
        });

        apply((CalendarUpdated event)->{
            Calendar calendar = new Calendar(event.getCalendarID(), event.getDescription(), event.getDateOfEvent(), event.getPlace());
            secretary.createCalendar(calendar.identity(), calendar.description(), calendar.dateOfEvent(), calendar.place());
        });

        apply((UserCreated event) -> {
            User.userID = event.getUserID();
            User.name = event.getName();
            User.address = event.getAddress();
            User.phone = event.getPhone();
        });

        apply((CommunicationCreated event)->{
            Communication.communicationID=event.getCommunicationID();
            Communication.description = event.getDescription();
            Communication.dateOfCommunication = event.getDateOfCommunication();
            Communication.socialMedia = event.getSocialMedia();

        });
/*
        apply((CommunicationUpdated event)->{
            Communication communication = new Communication(event.getCommunicationID(), event.getDescription(), event.getDateOfCommunication(), event.getCalendar(), event.getSocialMedia(), event.getReceiver());
            secretary.addCommunication(communication.identity(), communication.description(),communication.dateOfCommunication(), communication.calendar(), communication.socialMedia(), communication.receiver());
        });



        apply((UserUpdated event)->{
            User user = new User(event.getUserID(), event.getName(), event.getAddress(), event.getPhone());
            secretary.addUser(user.identity(), user.name(), user.address(), user.phone());
        });
*/
    }
}
