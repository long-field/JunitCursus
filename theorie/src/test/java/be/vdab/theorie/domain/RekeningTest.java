package be.vdab.theorie.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class RekeningTest {
    private Rekening rekening;
    @BeforeEach
    void beforeEach() {
    var rekening = new Rekening();
    }
    @Test
    void hetSaldoVanEenNieuweRekeningIs0Euro() {
        assertThat(rekening.getSaldo()).isZero();
    }
    @Test
    void nadatJe10€StortIsHetSaldo10€() {
        rekening.stort(BigDecimal.TEN);
        assertThat(rekening.getSaldo()).isEqualByComparingTo("10");
    }
    @Test
    void nadatJe10€En1€StortIsHetSaldo11€() {
        rekening.stort(BigDecimal.TEN);
        rekening.stort(BigDecimal.ONE);
        assertThat(rekening.getSaldo()).isEqualByComparingTo("11");
    }
    private static final BigDecimal TWEE = BigDecimal.valueOf(2);
    @Test
    void eenNieuweRekeningHeeftGeenStortingen() {
        assertThat(rekening.getStortingen()).isEmpty();
    }
    @Test
    void nadatJe10€StortIsErEenStortingVan10€() {
        rekening.stort(BigDecimal.TEN);
        assertThat(rekening.getStortingen()).containsOnly(BigDecimal.TEN);
    }
    @Test
    void nadatJe10€En1€StortZijnDeStortingen10€En1€() {
        rekening.stort(BigDecimal.TEN);
        rekening.stort(BigDecimal.ONE);
        assertThat(rekening.getStortingen())
                .containsExactly(BigDecimal.TEN, BigDecimal.ONE);
    }
    @Test
    void nadatJe10€En1€En2€StortZijnDeStortingenGesorteerd1€En2€En10€() {
        rekening.stort(BigDecimal.TEN);
        rekening.stort(BigDecimal.ONE);
        rekening.stort(TWEE);
        assertThat(rekening.getStortingenGesorteerd()).isSorted().containsExactly(BigDecimal.ONE, TWEE, BigDecimal.TEN);  }
}