package co.com.sofka.domain.secretarydomain;

import co.com.sofka.domain.generic.EventChange;
import co.com.sofka.domain.secretarydomain.entity.Calendar;
import co.com.sofka.domain.secretarydomain.entity.Communication;
import co.com.sofka.domain.secretarydomain.entity.User;
import co.com.sofka.domain.secretarydomain.events.*;

import java.util.HashSet;

public class SecretaryChange extends EventChange {

    public SecretaryChange(Secretary secretary){
        apply((SecretaryCreated event)->{
            secretary.description = event.getDescription();
            secretary.user = event.getUser();
            secretary.listCalendar = new HashSet<>();
            secretary.listCommunications= new HashSet<>();
        });

        apply((CalendarAdded event)->{
           Calendar calendar = new Calendar(event.getCalendarID(), event.getDescription(), event.getDateOfEvent(), event.getPlace());
           secretary.addCalendar(calendar.identity(), calendar.description(), calendar.dateOfEvent(), calendar.place());
        });

        apply((CalendarUpdated event)->{
            Calendar calendar = new Calendar(event.getCalendarID(), event.getDescription(), event.getDateOfEvent(), event.getPlace());
            secretary.addCalendar(calendar.identity(), calendar.description(), calendar.dateOfEvent(), calendar.place());
        });

        apply((CommunicationAdded event)->{
            Communication communication = new Communication(event.getCommunicationID(), event.getDescription(), event.getDateOfCommunication(), event.getCalendar(), event.getSocialMedia(), event.getReceiver());
            secretary.addCommunication(communication.identity(), communication.description(),communication.dateOfCommunication(), communication.calendar(), communication.socialMedia(), communication.receiver());
        });

        apply((CommunicationUpdated event)->{
            Communication communication = new Communication(event.getCommunicationID(), event.getDescription(), event.getDateOfCommunication(), event.getCalendar(), event.getSocialMedia(), event.getReceiver());
            secretary.addCommunication(communication.identity(), communication.description(),communication.dateOfCommunication(), communication.calendar(), communication.socialMedia(), communication.receiver());
        });

        apply((UserAdded event)->{
            User user = new User(event.getUserID(), event.getName(), event.getAddress(), event.getPhone());
            secretary.addUser(user.identity(), user.name(), user.address(), user.phone());
        });

        apply((UserUpdated event)->{
            User user = new User(event.getUserID(), event.getName(), event.getAddress(), event.getPhone());
            secretary.addUser(user.identity(), user.name(), user.address(), user.phone());
        });

    }
}
