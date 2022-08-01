package co.com.sofka.usecase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.domain.treasurydomain.Treasury;
import co.com.sofka.domain.treasurydomain.commands.CreateTreasury;

public class CreateTreasuryUseCase extends UseCase<RequestCommand<CreateTreasury>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<CreateTreasury>createTreasuryRequestCommand){
        var command = createTreasuryRequestCommand.getCommand();
        var treasury = new Treasury(command.getTreasuryID(), command.getTreasurer().name(), command.getTreasurer());

        emit().onResponse(new ResponseEvents(treasury.getUncommittedChanges()));
    }
}
