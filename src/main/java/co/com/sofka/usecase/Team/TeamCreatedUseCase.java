package co.com.sofka.usecase.Team;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.business.support.TriggeredEvent;
import co.com.sofka.domain.teamdomain.Team;
import co.com.sofka.domain.teamdomain.events.TeamCreated;
import co.com.sofka.domain.teamdomain.values.TeamID;

public class TeamCreatedUseCase extends UseCase<TriggeredEvent<TeamCreated>, ResponseEvents>{
    @Override
    public void executeUseCase(TriggeredEvent<TeamCreated> teamCreatedTriggeredEvent){
        var event = teamCreatedTriggeredEvent.getDomainEvent();
        var team = Team.from(TeamID.of(event.aggregateRootId()), repository().getEventsBy(event.aggregateRootId()));
        team.TeamCreated(event.getName());
        emit().onResponse(new ResponseEvents((team.getUncommittedChanges())));

    }
}
