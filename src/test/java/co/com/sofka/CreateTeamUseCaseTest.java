package co.com.sofka;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.teamdomain.commands.CreateTeam;
import co.com.sofka.domain.teamdomain.entity.Trainer;
import co.com.sofka.domain.teamdomain.events.TeamCreated;
import co.com.sofka.domain.teamdomain.values.*;
import co.com.sofka.usecase.CreateTeamUseCase;
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
public class CreateTeamUseCaseTest {

    @InjectMocks
    private CreateTeamUseCase useCase;

    @Mock
    private DomainEventRepository repository;

    @Test
    void CreateTeamSuccessfully(){
        //---------------------------------Arrange
            TeamID teamID = new TeamID("team1");
            Name name = new Name("Name 2");
            Trainer trainer = new Trainer(new TrainerID("trainer1"), new Name("name 2"), new Address("address1"),new Phone("phone1"),new Ci(12365478L));
            
            var command = new CreateTeam(teamID, name, trainer);
            
            when(repository.getEventsBy("team1")).thenReturn(history());
        //---------------------------------Act
        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(command.getTeamID().value())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();
        //---------------------------------Assert

        /***
         * Revisar valores que estoy comparando en el casos de las entidades
         */
        var event = (TeamCreated)events.get(0);
        assertEquals("Name 2", event.getName().value());
        assertEquals(trainer.name().value(), event.getTrainer().name().value());

        Mockito.verify(repository).getEventsBy("team1");



    }

    private List<DomainEvent> history() {
        TeamID teamID = TeamID.of("team1");
        Name name = new Name("Name 2");
        Trainer trainer = new Trainer(new TrainerID("trainer1"), new Name("name 2"), new Address("address1"),new Phone("phone1"),new Ci(12365478L));

        var event = new TeamCreated(name, trainer);
        event.setAggregateRootId(teamID.value());
        return List.of(event);
    }
}
