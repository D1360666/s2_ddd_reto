package co.com.sofka.secretary;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.TriggeredEvent;
import co.com.sofka.domain.secretarydomain.Secretary;
import co.com.sofka.domain.secretarydomain.entity.User;
import co.com.sofka.domain.secretarydomain.events.SecretaryCreated;
import co.com.sofka.domain.secretarydomain.values.Description;
import co.com.sofka.domain.secretarydomain.values.Name;
import co.com.sofka.domain.secretarydomain.values.SecretaryID;
import co.com.sofka.usecase.Secretary.SecretaryCreatedUseCase;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class SecretaryCreatedUseCaseTest {
    @InjectMocks
    private SecretaryCreatedUseCase useCase;

    @Mock
    private DomainEventRepository repository;

    @Test
    void createSecretaryTest(){
        Name name = new Name("Secretaria 2014");
        SecretaryID secretaryID = SecretaryID.of("SecretaryID");
        Secretary secretary = new Secretary(secretaryID, name);
        var event = new SecretaryCreated(name);
        event.setAggregateRootId("SecretaryID");

        when(repository.getEventsBy("SecretaryID")).thenReturn(List.of(event));
        useCase.addRepository(repository);

        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(event.aggregateRootId())
                .syncExecutor(useCase, new TriggeredEvent<>(event))
                .orElseThrow()
                .getDomainEvents();
        var evento = (SecretaryCreated) events.get(0);

        assertEquals("Secretaria 2014", evento.getName().value());


    }

}
