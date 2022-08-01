package co.com.sofka.usecase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.domain.secretarydomain.Secretary;
import co.com.sofka.domain.secretarydomain.commands.CreateSecretary;

public class CreateSecretaryUseCase extends UseCase<RequestCommand<CreateSecretary>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<CreateSecretary>createTeamRequestCommand){
        var command = createTeamRequestCommand.getCommand();
        var secretary = new Secretary(command.getSecretaryID(),command.getDescription(),command.getUser());

        emit().onResponse(new ResponseEvents(secretary.getUncommittedChanges()));
    }




}
