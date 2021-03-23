package be.vdab.theorie.repositories;

import java.io.IOException;
import java.math.BigDecimal;

public interface PersoonRepository {
    BigDecimal[] findAllWeddes() throws IOException;
}
