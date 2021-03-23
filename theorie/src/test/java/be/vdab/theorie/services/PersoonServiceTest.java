package be.vdab.theorie.services;
import be.vdab.theorie.repositories.PersoonRepository;
import be.vdab.theorie.repositories.PersoonRepositoryStub;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import be.vdab.theorie.repositories.CSVPersoonRepository;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.io.IOException;
import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;
@ExtendWith(MockitoExtension.class)
class PersoonServiceTest {
    private PersoonService service;
    @Mock
    private PersoonRepository repository;

    @BeforeEach
    void beforeEach() {
        service = new PersoonService(repository);
    }
    @Test
    void deWeddeStandaardAfwijkingIs2() throws IOException {
        when(repository.findAllWeddes()).thenReturn(new BigDecimal[] {
                BigDecimal.valueOf(2), BigDecimal.valueOf(4), BigDecimal.valueOf(4),
                BigDecimal.valueOf(4), BigDecimal.valueOf(5), BigDecimal.valueOf(5),
                BigDecimal.valueOf(7), BigDecimal.valueOf(9), });
        assertThat(service.standaardAfwijkingWeddes()).isEqualByComparingTo("2");
        verify(repository).findAllWeddes();
    }
}