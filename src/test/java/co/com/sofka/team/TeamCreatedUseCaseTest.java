package co.com.sofka.team;
import co.com.sofka.domain.teamdomain.events.TeamCreated;
import co.com.sofka.domain.teamdomain.Team;
import co.com.sofka.domain.teamdomain.values.TeamID;
import co.com.sofka.domain.teamdomain.values.Name;
import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.TriggeredEvent;
import co.com.sofka.usecase.Team.TeamCreatedUseCase;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;





@ExtendWith(MockitoExtension.class)
public class TeamCreatedUseCaseTest {

    @InjectMocks
    private TeamCreatedUseCase useCase;

    @Mock
    private DomainEventRepository repository;

    @Test
    void createTeamTest(){
        Name name = new Name("Categoria 2014");
        TeamID teamID = TeamID.of("TeamID");
        Team team = new Team(teamID, name);
        var event = new TeamCreated(name);
        event.setAggregateRootId("TeamID");

        when(repository.getEventsBy("TeamID")).thenReturn(List.of(event));
        useCase.addRepository(repository);

        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(event.aggregateRootId())
                .syncExecutor(useCase, new TriggeredEvent<>(event))
               .orElseThrow()
                .getDomainEvents();

        var evento = (TeamCreated) events.get(0);

        assertEquals("Categoria 2014", evento.getName().value());
    }

}
