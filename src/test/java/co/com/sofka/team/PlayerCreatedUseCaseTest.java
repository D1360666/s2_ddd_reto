package co.com.sofka.team;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.TriggeredEvent;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.secretarydomain.values.CalendarID;
import co.com.sofka.domain.teamdomain.commands.CreatePlayer;
import co.com.sofka.domain.teamdomain.entity.Player;
import co.com.sofka.domain.teamdomain.events.PlayerCreated;
import co.com.sofka.domain.teamdomain.events.PlayerCreatedMessage;
import co.com.sofka.domain.teamdomain.values.Name;
import co.com.sofka.domain.teamdomain.values.PlayerID;
import co.com.sofka.domain.teamdomain.values.Ci;
import co.com.sofka.domain.teamdomain.values.TeamID;
import co.com.sofka.usecase.Team.CreatePlayerUseCase;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class PlayerCreatedUseCaseTest {
    @InjectMocks
    private CreatePlayerUseCase useCase;

    @Mock
    private DomainEventRepository repository;

    @Test
    void executeUseCase(){
        PlayerID playerID= PlayerID.of("Player1");
        Name name = new Name("NombrePlayer");
        Ci ci = new Ci(61861658L);

        TeamID teamID= TeamID.of("Categoria 2014");
        var command = new CreatePlayer(playerID, name, ci, teamID);

        when(repository.getEventsBy("Categoria 2014")).thenReturn(history());

        useCase.addRepository(repository);

        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(command.getTeamID().value())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        var event = (PlayerCreated) events.get(0);
        assertEquals("NombrePlayer", event.getName().value());
        Mockito.verify(repository).getEventsBy("Categoria 2014");
    }
    private List<DomainEvent> history() {
        TeamID teamID = TeamID.of("Categoria 2014");
        Name name = new Name("NombrePlayer");
        Ci ci = new Ci(61861658L);
        var event = new PlayerCreated(name, ci);
        event.setAggregateRootId(teamID.value());
        return List.of(event);
    }
}
