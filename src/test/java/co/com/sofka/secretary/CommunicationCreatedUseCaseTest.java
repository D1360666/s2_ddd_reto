package co.com.sofka.secretary;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.secretarydomain.commands.CreateCommunication;
import co.com.sofka.domain.secretarydomain.entity.Calendar;
import co.com.sofka.domain.secretarydomain.events.CalendarCreated;
import co.com.sofka.domain.secretarydomain.events.CommunicationCreated;
import co.com.sofka.domain.secretarydomain.values.*;
import co.com.sofka.usecase.Secretary.CommunicationCreatedUseCase;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static co.com.sofka.domain.secretarydomain.entity.Communication.socialMedia;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CommunicationCreatedUseCaseTest {

    @InjectMocks
    private CommunicationCreatedUseCase useCase;

    @Mock
    private DomainEventRepository repository;

    @Test
    void executeUseCase(){
        CommunicationID communicationID = CommunicationID.of("comID");
        Description description = new Description("Nueva publicacion");
        DateOfCommunication dateOfCommunication = new DateOfCommunication(29, 8, 2022);
        SocialMedia socialMedia= new SocialMedia("Facebook");

        SecretaryID secretaryID = SecretaryID.of("Secretaria 2014");
        var command = new CreateCommunication(communicationID, description, dateOfCommunication, socialMedia, secretaryID);

        when(repository.getEventsBy("Secretaria 2014")).thenReturn(history());

        useCase.addRepository(repository);

        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(command.getSecretaryID().value())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();
        var event = (CommunicationCreated) events.get(0);
        assertEquals("Nueva publicacion", event.getDescription().value());
        Mockito.verify(repository).getEventsBy("Secretaria 2014");


    }
    private List<DomainEvent> history(){
        SecretaryID secretaryID = SecretaryID.of("Secretaria 2014");
        CommunicationID communicationID= CommunicationID.of("comID");
        Description description = new Description("Nueva publicacion");
        DateOfCommunication dateOfCommunication = new DateOfCommunication(29, 8, 2022);
        SocialMedia socialMedia= new SocialMedia("Facebook");
        var event = new CommunicationCreated(description, dateOfCommunication, socialMedia);
        event.setAggregateRootId(secretaryID.value());
        return List.of(event);
    }
}
