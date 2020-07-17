package cl.indecon.converter;

import cl.indecon.domain.valoresKey.FechaValor;
import cl.indecon.domain.valoresKey.RsValoresKey;
import cl.indecon.domain.valoresKey.Valores;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class RsValoresKeyToValores implements
        Converter<RsValoresKey, Valores> {

    @Override
    public Valores convert(RsValoresKey rs) {
        Valores val = new Valores();
        val.setKey(rs.getKey());
        val.setName(rs.getName());
        val.setUnit(rs.getUnit());

        List<FechaValor> fechaValorsList = new ArrayList<>();

        rs.getValues().
                forEach((k, v) -> fechaValorsList.add(new FechaValor( Long.parseLong(String.valueOf(k)), (Double) v)));
        val.setFechaValorList(fechaValorsList);

        return val;
    }
}
