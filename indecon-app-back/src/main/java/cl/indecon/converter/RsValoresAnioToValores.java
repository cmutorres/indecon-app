package cl.indecon.converter;

import cl.indecon.domain.valoresAnio.ValoresAnio;
import cl.indecon.domain.valoresKey.RsValoresKey;
import org.apache.el.lang.ELArithmetic;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Component
public class RsValoresAnioToValores implements
        Converter<RsValoresKey, ValoresAnio> {
    private static final String[] MESES = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"};
    Map<String, Map> map = new HashMap();

    Map<String, Map> mapTotal = new HashMap();

    @Override
    public ValoresAnio convert(RsValoresKey rs) {
        ValoresAnio val = new ValoresAnio();
        val.setKey(rs.getKey());
        val.setName(rs.getName());
        val.setUnit(rs.getUnit());

        map.put("2019", initMonth());
        map.put("2020", initMonth());
        mapTotal.put("2019", initMonth());
        mapTotal.put("2020", initMonth());

        rs.getValues().
                forEach((k, v) -> calcularPrecio(Long.parseLong(String.valueOf(k)), (Double) v));

        mapTotal.entrySet().stream()
                .forEach(e -> validar(e.getKey(), e.getValue()));

        val.setMap(map);
        return val;
    }

    private void validar(String key, Map<String, Map> value) {
        Arrays.stream(MESES).forEach(m -> dividir(key, value.get(m), m)
        );
    }

    private void dividir(String key, Object valor, String mes) {
        Double d = (Double) valor;
        Map o = map.get(String.valueOf(key));
        Double precio = (Double) o.get(mes);
        if (Objects.isNull(precio)) {
            precio = 0.0;
        }
        Double div = 0.0;
        if (precio == 0 || d == 0) {
            div = precio;
        } else {
            div = (Double) ELArithmetic.BigDecimalDelegate.divide(precio, valor);
        }
        o.put(mes, div);
    }


    private Map<String, Double> initMonth() {
        Map<String, Double> meses = new HashMap<>();
        for (String mes : MESES) {
            meses.put(mes, 0.0);
        }
        return meses;
    }

    private void calcularPrecio(long date, Double precio) {
        Date fecha = new Date(date * 1000);
        LocalDate localDate = fecha.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        try {
            Map o = map.get(String.valueOf(localDate.getYear()));

            Map oTotal = mapTotal.get(String.valueOf(localDate.getYear()));

            Double sumPrecio = (Double) o.get(MESES[localDate.getMonth().getValue() - 1]);

            Double total = (Double) oTotal.get(MESES[localDate.getMonth().getValue() - 1]);

            if (Objects.isNull(sumPrecio)) {
                sumPrecio = 0.0;
            }

            if (Objects.isNull(total)) {
                total = 0.0;
            }
            sumPrecio = sumPrecio + precio;
            total = total + 1.0;

            o.put(MESES[localDate.getMonth().getValue() - 1], sumPrecio);
            oTotal.put(MESES[localDate.getMonth().getValue() - 1], total);
        } catch (Exception exception) {

        }
    }
}
