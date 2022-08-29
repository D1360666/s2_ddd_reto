package co.com.sofka.secretary;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.secretarydomain.commands.CreateCalendar;
import co.com.sofka.domain.secretarydomain.events.CalendarCreated;
import co.com.sofka.domain.secretarydomain.values.*;
import co.com.sofka.usecase.Secretary.CalendarCreatedUseCase;
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
public class CalendarCreatedUseCaseTest {
    @InjectMocks
    private CalendarCreatedUseCase useCase;

    @Mock
    private DomainEventRepository repository;

    @Test
    void executeUseCase(){
        CalendarID calendarID= CalendarID.of("Entrenamiento");
        Description description = new Description("Practicas semanales");
        DateOfEvent dateOfEvent = new DateOfEvent(1, 8, 2022);
        Place place = new Place("Cancha principal");

        SecretaryID secretaryID = SecretaryID.of("Secretaria 2014");
        var command = new CreateCalendar(calendarID, description, dateOfEvent, place, secretaryID);

        when(repository.getEventsBy("Secretaria 2014")).thenReturn(history());

        useCase.addRepository(repository);

        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(command.getSecretaryID().value())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        var event = (CalendarCreated) events.get(0);
        assertEquals("Practicas semanales", event.getDescription().value());
        Mockito.verify(repository).getEventsBy("Secretaria 2014");
    }
    private List<DomainEvent> history(){
        SecretaryID secretaryID = SecretaryID.of("Secretaria 2014");
        CalendarID calendarID= CalendarID.of("Entrenamiento");
        Description description = new Description("Practicas semanales");
        DateOfEvent dateOfEvent = new DateOfEvent(1, 8, 2022);
        Place place = new Place("Cancha principal");
        var event = new CalendarCreated(description, dateOfEvent, place);
        event.setAggregateRootId(secretaryID.value());
        return List.of(event);
    }
}
