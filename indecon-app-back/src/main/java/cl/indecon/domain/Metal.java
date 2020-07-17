package cl.indecon.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties
public class Metal {
    private String key;
    private String name;
    private String unit;
    private long date;
    private Double value;
}
