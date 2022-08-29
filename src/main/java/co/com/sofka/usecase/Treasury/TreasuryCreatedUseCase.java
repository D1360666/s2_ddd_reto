package co.com.sofka.usecase.Treasury;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.business.support.TriggeredEvent;
import co.com.sofka.domain.secretarydomain.events.SecretaryCreated;
import co.com.sofka.domain.treasurydomain.Treasury;
import co.com.sofka.domain.treasurydomain.commands.CreateTreasury;
import co.com.sofka.domain.treasurydomain.events.TreasuryCreated;
import co.com.sofka.domain.treasurydomain.values.TreasuryID;

public class TreasuryCreatedUseCase extends UseCase<TriggeredEvent<TreasuryCreated>, ResponseEvents> {
    @Override
    public void executeUseCase(TriggeredEvent<TreasuryCreated>treasuryCreatedTriggeredEvent){
        var event = treasuryCreatedTriggeredEvent.getDomainEvent();
        var treasury = Treasury.from(TreasuryID.of(event.aggregateRootId()), repository().getEventsBy((event.aggregateRootId())));
        treasury.TreasuryCreated(event.getName());
        emit().onResponse(new ResponseEvents(treasury.getUncommittedChanges()));
    }
}
