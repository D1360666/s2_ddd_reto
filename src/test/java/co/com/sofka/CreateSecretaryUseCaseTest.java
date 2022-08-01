package co.com.sofka;


import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.secretarydomain.commands.CreateSecretary;
import co.com.sofka.domain.secretarydomain.entity.User;
import co.com.sofka.domain.secretarydomain.events.SecretaryCreated;
import co.com.sofka.domain.secretarydomain.values.*;
import co.com.sofka.usecase.CreateSecretaryUseCase;
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
class CreateSecretaryUseCaseTest {

    @InjectMocks
    private CreateSecretaryUseCase useCase;

    @Mock
    private DomainEventRepository repository;

    @Test
    void CreateSecretarySuccessfully(){
    //---------------------------------Arrange
        SecretaryID secretaryID = SecretaryID.of("secretaryID");
        Description description = new Description("Secretary Desc");
        User user = new User(new UserID("user1"), new Name("Name"), new Address("Address1"), new Phone("Phone1"));

        var command = new CreateSecretary(secretaryID, description, user);

        when(repository.getEventsBy("secretaryID")).thenReturn(history());
        useCase.addRepository(repository);

    //---------------------------------Act
        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(command.getSecretaryID().value())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

    //---------------------------------Assert
        var event = (SecretaryCreated)events.get(0);

        /***
         * Revisar valores que estoy comparando en el casos de las entidades
         */
        assertEquals("Secretary Desc", event.getDescription().value());
        assertEquals(user.name(), event.getUser().name().value());

        Mockito.verify(repository).getEventsBy("secretaryID");
    }

    private List<DomainEvent> history() {
        SecretaryID secretaryID = SecretaryID.of("secretaryID");
        Description description = new Description("Secretary Desc");
        User user = new User(new UserID("user1"), new Name("Name"), new Address("Address1"), new Phone("Phone1"));

        var event = new SecretaryCreated(description, user);
        event.setAggregateRootId(secretaryID.value());
        return List.of(event);
    }

}
