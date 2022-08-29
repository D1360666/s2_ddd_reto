package co.com.sofka.usecase.Secretary;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

import co.com.sofka.domain.secretarydomain.Secretary;
import co.com.sofka.domain.secretarydomain.commands.CreateCommunication;
import org.springframework.boot.autoconfigure.cassandra.CassandraProperties;

public class CommunicationCreatedUseCase extends UseCase<RequestCommand<CreateCommunication>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<CreateCommunication>createCommunicationRequestCommand){
        var command = createCommunicationRequestCommand.getCommand();
        var secretary = Secretary.from(command.getSecretaryID(), repository().getEventsBy(command.getSecretaryID().value()));
        secretary.createCommunication(command.getCommunicationID(), command.getDescription(), command.getDateOfCommunication(), command.getSocialMedia());
        emit().onResponse(new ResponseEvents(secretary.getUncommittedChanges()));
    }
}
