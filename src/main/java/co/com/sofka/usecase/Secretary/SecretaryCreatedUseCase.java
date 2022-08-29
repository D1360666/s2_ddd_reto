package co.com.sofka.usecase.Secretary;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.business.support.TriggeredEvent;
import co.com.sofka.domain.secretarydomain.Secretary;
import co.com.sofka.domain.secretarydomain.events.SecretaryCreated;
import co.com.sofka.domain.secretarydomain.values.SecretaryID;

public class SecretaryCreatedUseCase extends UseCase<TriggeredEvent<SecretaryCreated>,ResponseEvents>{

    @Override
    public void executeUseCase(TriggeredEvent<SecretaryCreated> secretaryCreatedTriggeredEvent){
        var event = secretaryCreatedTriggeredEvent.getDomainEvent();
        var secretary = Secretary.from(SecretaryID.of(event.aggregateRootId()), repository().getEventsBy((event.aggregateRootId())));
        secretary.SecretaryCreated(event.getName());
        emit().onResponse(new ResponseEvents((secretary.getUncommittedChanges())));
    }





}
