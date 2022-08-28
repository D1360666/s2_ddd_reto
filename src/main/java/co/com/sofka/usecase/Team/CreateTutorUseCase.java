package co.com.sofka.usecase.Team;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.domain.teamdomain.Team;

import co.com.sofka.domain.teamdomain.commands.CreateTutor;


public class CreateTutorUseCase extends UseCase<RequestCommand<CreateTutor>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<CreateTutor>createTutorRequestCommand){
        var command = createTutorRequestCommand.getCommand();
        var team = Team.from(command.getTeamID(), repository().getEventsBy(command.getTeamID().value()));
        team.createTutor(command.getTutorID(), command.getName(), command.getCi());

        emit().onResponse(new ResponseEvents(team.getUncommittedChanges()));
    }
}
