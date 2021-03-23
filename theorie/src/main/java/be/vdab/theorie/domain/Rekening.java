package be.vdab.theorie.domain;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class Rekening {
        private final List<BigDecimal> stortingen = new ArrayList<>();
        public void stort(BigDecimal bedrag) {
            if (bedrag.compareTo(BigDecimal.ZERO) <= 0) {
                throw new IllegalArgumentException("Bedrag moet positief zijn"); } stortingen.add(bedrag); }
        public BigDecimal getSaldo() {
            return stortingen.stream().reduce(BigDecimal.ZERO, (vorigSaldo, storting) -> vorigSaldo.add(storting)); }
        public List<BigDecimal> getStortingen() {
            return stortingen; }
        public List<BigDecimal> getStortingenGesorteerd() {
            return stortingen.stream().sorted().collect(Collectors.toList()); } }

