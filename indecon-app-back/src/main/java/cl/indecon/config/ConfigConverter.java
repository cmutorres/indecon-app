package cl.indecon.config;


import cl.indecon.converter.RsValoresAnioToValores;
import cl.indecon.converter.RsValoresKeyToValores;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.support.DefaultConversionService;

@Configuration
public class ConfigConverter {

    @Autowired
    private RsValoresKeyToValores rsValoresKeyToValores;

    @Autowired
    private RsValoresAnioToValores rsValoresAnioToValores;

    @Bean(name = "conversionService")
    public ConversionService conversionService() {
        DefaultConversionService service = new DefaultConversionService();
        service.addConverter(rsValoresKeyToValores);
        service.addConverter(rsValoresAnioToValores);
        return service;
    }

}
