package co.com.sofka.treasury;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.TriggeredEvent;
import co.com.sofka.domain.treasurydomain.entity.Treasurer;
import co.com.sofka.domain.treasurydomain.events.TreasuryCreated;
import co.com.sofka.domain.treasurydomain.values.Name;
import co.com.sofka.domain.treasurydomain.values.TreasuryID;
import co.com.sofka.usecase.Treasury.TreasuryCreatedUseCase;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledForJreRange;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class TreasuryCreatedUseCaseTest {
    @InjectMocks
    private TreasuryCreatedUseCase useCase;

    @Mock
    private DomainEventRepository repository;

    @Test
    void createTreasuryTest(){
        Name name = new Name("Tesoreria2014");
        TreasuryID treasuryID = TreasuryID.of("TesoreriaID");

        var event = new TreasuryCreated(name);
        event.setAggregateRootId("TesoreriaID");

        when(repository.getEventsBy("TesoreriaID")).thenReturn(List.of(event));
        useCase.addRepository(repository);

        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(event.aggregateRootId())
                .syncExecutor(useCase, new TriggeredEvent<>(event))
                .orElseThrow()
                .getDomainEvents();

        var evento = (TreasuryCreated) events.get(0);
        assertEquals("Tesoreria2014", evento.getName().value());
    }
}
