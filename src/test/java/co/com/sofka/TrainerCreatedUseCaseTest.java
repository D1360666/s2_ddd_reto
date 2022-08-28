package co.com.sofka;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;

import co.com.sofka.domain.teamdomain.commands.CreateTrainer;
import co.com.sofka.domain.teamdomain.events.PlayerCreated;
import co.com.sofka.domain.teamdomain.events.TrainerCreated;
import co.com.sofka.domain.teamdomain.values.*;

import co.com.sofka.usecase.Team.CreateTrainerUseCase;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static co.com.sofka.domain.teamdomain.entity.Player.playerID;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class TrainerCreatedUseCaseTest {
    @InjectMocks
    private CreateTrainerUseCase useCase;

    @Mock
    private DomainEventRepository repository;

    @Test
    void executeUseCase(){
        TrainerID trainerID= TrainerID.of("Trainer1");
        Name name = new Name("NombreTrainer");
        Address address = new Address("Hugo Caballero 1969");
        Phone phone = new Phone("+598 91961445");
        Ci ci = new Ci(61861658L);

        TeamID teamID= TeamID.of("Categoria 2014");
        var command = new CreateTrainer(trainerID, name, address, phone, ci, teamID);

        when(repository.getEventsBy("Categoria 2014")).thenReturn(history());

        useCase.addRepository(repository);

        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(command.getTeamID().value())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        var event = (TrainerCreated) events.get(0);
        assertEquals("NombreTrainer", event.getName().value());
        Mockito.verify(repository).getEventsBy("Categoria 2014");
    }
    private List<DomainEvent> history() {
        TeamID teamID = TeamID.of("Cateagoria 2014");
        Name name = new Name("NombreTrainer");
        Ci ci = new Ci(61861658L);
        Address address = new Address("Hugo Caballero 1969");
        Phone phone = new Phone("+598 91961445");
        var event = new TrainerCreated(name, address, phone, ci);
        event.setAggregateRootId(teamID.value());
        return List.of(event);
    }
}
