package cl.indecon.domain.valoresKey;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Valores {
    private String key;
    private String name;
    private String unit;
    List<FechaValor> fechaValorList;
}
