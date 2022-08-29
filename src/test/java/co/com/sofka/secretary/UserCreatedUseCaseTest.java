package co.com.sofka.secretary;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.secretarydomain.commands.CreateUser;
import co.com.sofka.domain.secretarydomain.events.UserCreated;
import co.com.sofka.domain.secretarydomain.values.*;
import co.com.sofka.usecase.Secretary.CreateUserUseCase;
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
public class UserCreatedUseCaseTest {
    @InjectMocks
    private CreateUserUseCase useCase;

    @Mock
    private DomainEventRepository repository;

    @Test
    void executeUseCase(){
        UserID userID= UserID.of("idUser");
        Name name = new Name("UserName");
        Address address = new Address("Hugo Caballero 1969");
        Phone phone = new Phone("+598 91961445");


        SecretaryID secretaryID= SecretaryID.of("Secretaria 2014");
        var command = new CreateUser(userID, name, address, phone, secretaryID);

        when(repository.getEventsBy("Secretaria 2014")).thenReturn(history());

        useCase.addRepository(repository);

        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(command.getSecretaryID().value())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        var event = (UserCreated) events.get(0);
        assertEquals("UserName", event.getName().value());
        Mockito.verify(repository).getEventsBy("Secretaria 2014");
    }
    private List<DomainEvent> history() {
        SecretaryID secretaryID = SecretaryID.of("Secretaria 2014");
        Name name = new Name("UserName");
        Address address = new Address("Hugo Caballero 1969");
        Phone phone = new Phone("+598 91961445");
        var event = new UserCreated(name, address, phone);
        event.setAggregateRootId(secretaryID.value());
        return List.of(event);
    }
}
