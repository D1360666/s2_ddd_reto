package co.com.sofka.usecase.Team;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.domain.teamdomain.Team;
import co.com.sofka.domain.teamdomain.commands.CreateTrainer;

public class CreateTrainerUseCase extends UseCase<RequestCommand<CreateTrainer>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<CreateTrainer>createTrainerRequestCommand){
        var command = createTrainerRequestCommand.getCommand();
        var team = Team.from(command.getTeamID(), repository().getEventsBy(command.getTeamID().value()));
        team.createTrainer(command.getTrainerID(), command.getName(),command.getAddress(), command.getPhone(),command.getCi());

        emit().onResponse(new ResponseEvents(team.getUncommittedChanges()));
    }
}