package cl.indecon.domain.valoresKey;

import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
public class RsValoresKey {
    private String key;
    private String name;
    private String unit;
    Map values;
}
