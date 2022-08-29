package co.com.sofka.usecase.Secretary;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.domain.secretarydomain.Secretary;
import co.com.sofka.domain.secretarydomain.commands.CreateCalendar;

public class CalendarCreatedUseCase extends UseCase<RequestCommand<CreateCalendar>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<CreateCalendar>createCalendarRequestCommand){
        var command = createCalendarRequestCommand.getCommand();
        var secretary = Secretary.from(command.getSecretaryID(), repository().getEventsBy(command.getSecretaryID().value()));
        secretary.createCalendar(command.getCalendarID(), command.getDescription(), command.getDateOfEvent(), command.getPlace());

        emit().onResponse(new ResponseEvents(secretary.getUncommittedChanges()));
    }
}
