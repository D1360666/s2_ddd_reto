package co.com.sofka.usecase;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.domain.teamdomain.Team;
import co.com.sofka.domain.teamdomain.commands.CreateTeam;

public class CreateTeamUseCase extends UseCase<RequestCommand<CreateTeam>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<CreateTeam>createTeamRequestCommand){
        var command = createTeamRequestCommand.getCommand();
        var team = new Team(command.getTeamID(), command.getName(), command.getTrainer());

        emit().onResponse(new ResponseEvents(team.getUncommittedChanges()));

    }

}
