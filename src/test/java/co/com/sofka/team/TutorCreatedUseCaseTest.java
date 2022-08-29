package co.com.sofka.team;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.teamdomain.commands.CreateTutor;
import co.com.sofka.domain.teamdomain.events.TutorCreated;
import co.com.sofka.domain.teamdomain.values.*;
import co.com.sofka.usecase.Team.CreateTutorUseCase;
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
public class TutorCreatedUseCaseTest {
    @InjectMocks
    private CreateTutorUseCase useCase;

    @Mock
    private DomainEventRepository repository;

    @Test
    void executeUseCase(){
        TutorID tutorID= TutorID.of("Tutor1");
        Name name = new Name("NombreTutor");
        Ci ci = new Ci(61861658L);

        TeamID teamID= TeamID.of("Categoria 2014");
        var command = new CreateTutor(tutorID, name, ci, teamID);

        when(repository.getEventsBy("Categoria 2014")).thenReturn(history());

        useCase.addRepository(repository);

        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(command.getTeamID().value())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        var event = (TutorCreated) events.get(0);
        assertEquals("NombreTutor", event.getName().value());
        Mockito.verify(repository).getEventsBy("Categoria 2014");
    }
    private List<DomainEvent> history() {
        TeamID teamID = TeamID.of("Cateagoria 2014");
        Name name = new Name("NombreTutor");
        Ci ci = new Ci(61861658L);
        var event = new TutorCreated(name, ci);
        event.setAggregateRootId(teamID.value());
        return List.of(event);
    }
}
