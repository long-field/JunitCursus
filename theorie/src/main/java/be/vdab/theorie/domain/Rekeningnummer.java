package be.vdab.theorie.domain;

import java.util.regex.Pattern;

public class Rekeningnummer {
    private static final Pattern REG_EXPR = Pattern.compile("^BE\\d{14}$");
    private final String nummer;

    public Rekeningnummer(String nummer) {
        if (!REG_EXPR.matcher(nummer).matches()) {
            throw new IllegalArgumentException("Verkeerd formaat");
        }
        var controleGetal = Integer.valueOf(nummer.substring(2, 4));
        if (controleGetal < 2 || controleGetal > 98) {
            throw new IllegalArgumentException();
        }
        var teControlerenNummer = nummer.substring(4) + "1114" + controleGetal;
        if (Long.valueOf(teControlerenNummer) % 97 != 1) {
            throw new IllegalArgumentException();
        }
        this.nummer = nummer;
    }

    @Override
    public String toString() {
        return nummer;
    }
}
