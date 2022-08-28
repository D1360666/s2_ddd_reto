package co.com.sofka.domain.teamdomain.events;

import co.com.sofka.domain.generic.DomainEvent;

public class PlayerCreatedMessage extends DomainEvent {
    private String message;

    public PlayerCreatedMessage(String message){
        super("sofka.domain.teamdomain.playercreatedmessage");
        this.message=message;
    }
    public String getMessage() {
        return message;
    }
}
