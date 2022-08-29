package co.com.sofka.usecase.Secretary;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.domain.secretarydomain.Secretary;
import co.com.sofka.domain.secretarydomain.commands.CreateUser;
import co.com.sofka.domain.teamdomain.Team;
import co.com.sofka.domain.teamdomain.commands.CreateTrainer;

public class CreateUserUseCase extends UseCase<RequestCommand<CreateUser>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<CreateUser>createUserRequestCommand){
        var command = createUserRequestCommand.getCommand();
        var secretary = Secretary.from(command.getSecretaryID(), repository().getEventsBy(command.getSecretaryID().value()));
        secretary.createUser(command.getUserID(), command.getName(),command.getAddress(), command.getPhone());

        emit().onResponse(new ResponseEvents(secretary.getUncommittedChanges()));
    }
}