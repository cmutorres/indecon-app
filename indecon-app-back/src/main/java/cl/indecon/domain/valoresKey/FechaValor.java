package cl.indecon.domain.valoresKey;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FechaValor {
    private long date;
    private Double value;

    public FechaValor(long date, Double value) {
        this.date = date;
        this.value = value;
    }
}
