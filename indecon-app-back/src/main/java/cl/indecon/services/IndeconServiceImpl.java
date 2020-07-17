package cl.indecon.services;

import cl.indecon.Constants;
import cl.indecon.domain.Metal;
import cl.indecon.domain.UltimosValores;
import cl.indecon.domain.valoresAnio.ValoresAnio;
import cl.indecon.domain.valoresKey.RsValoresKey;
import cl.indecon.domain.valoresKey.Valores;
import cl.indecon.enums.KeyIndecon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class IndeconServiceImpl implements IndeconService {

    @Autowired
    private Environment environment;

    @Autowired
    private ConversionService conversionService;

    @Autowired
    @Qualifier(Constants.REST_TEMPLATE_WITHOUT_CERT)
    RestTemplate restTemplate;

    @Override
    public List<Metal> obtieneUltimosValores() {

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity request = new HttpEntity(headers);

        String urlLast = environment.getProperty("api.indecon.link")
                .concat(environment.getProperty("api.indecon.url.ultimos.valores"));
        ResponseEntity<UltimosValores> exchange = restTemplate.exchange(urlLast, HttpMethod.GET, request, UltimosValores.class);
        UltimosValores val = exchange.getBody();

        List<Metal> valoresList = List.of(val.getCobre(), val.getDolar(), val.getEuro(), val.getIpc(), val.getIvp(), val.getOro(), val.getPlata(), val.getUf(), val.getUtm(), val.getYen());
        return valoresList;
    }

    @Override
    public Valores obtieneValores(KeyIndecon keyIndecon) {
        RsValoresKey valoresPorKey = getValoresRestTemplate(keyIndecon);
        return conversionService.convert(valoresPorKey, Valores.class);
    }

    @Override
    public ValoresAnio obtieneValoresAnio(KeyIndecon keyIndecon) {
        RsValoresKey valoresPorKey = getValoresRestTemplate(keyIndecon);
        return conversionService.convert(valoresPorKey, ValoresAnio.class);


    }

    private RsValoresKey getValoresRestTemplate(KeyIndecon keyIndecon) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity request = new HttpEntity(headers);

        String urlLast = environment.getProperty("api.indecon.link")
                .concat(environment.getProperty("api.indecon.url.valores"))
                .concat("/")
                .concat(String.valueOf(keyIndecon).toLowerCase());

        ResponseEntity<RsValoresKey> exchange = restTemplate.exchange(urlLast, HttpMethod.GET, request, RsValoresKey.class);
        return exchange.getBody();
    }
}
