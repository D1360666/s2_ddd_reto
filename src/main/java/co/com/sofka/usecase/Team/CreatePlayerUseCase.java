package co.com.sofka.usecase.Team;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.domain.teamdomain.Team;
import co.com.sofka.domain.teamdomain.commands.CreatePlayer;


public class CreatePlayerUseCase extends UseCase<RequestCommand<CreatePlayer>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<CreatePlayer>createPlayerRequestCommand){
        var command = createPlayerRequestCommand.getCommand();
        var team = Team.from(command.getTeamID(), repository().getEventsBy(command.getTeamID().value()));
        team.createPlayer(command.getPlayerID(), command.getName(), command.getCi());

        emit().onResponse(new ResponseEvents(team.getUncommittedChanges()));
    }
}
