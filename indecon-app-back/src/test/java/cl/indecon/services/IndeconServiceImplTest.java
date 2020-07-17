package cl.indecon.services;

import cl.indecon.domain.Metal;
import cl.indecon.domain.UltimosValores;
import cl.indecon.fixture.LastFixture;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
public class IndeconServiceImplTest {

    @InjectMocks
    IndeconServiceImpl indeconService;
    @Mock
    RestTemplate restTemplate;
    @Mock
    Environment environment;
    @Mock
    private ConversionService conversionService;

    @Before
    public void setup() {
        when(environment.getProperty("api.indecon.link")).
                thenReturn(String.valueOf("http://localhost:8080"));
        when(environment.getProperty("api.indecon.url.ultimos.valores")).
                thenReturn(String.valueOf("/last"));
    }

    @Test
    public void testLast() {
        UltimosValores rsMetales = LastFixture.getRsMetales();
        ResponseEntity<UltimosValores> toBeReturned = new ResponseEntity<>(rsMetales, HttpStatus.OK);
        UltimosValores body = toBeReturned.getBody();
        doReturn(toBeReturned)
                .when(restTemplate).exchange(
                any(String.class),
                any(HttpMethod.class),
                any(HttpEntity.class),
                any(Class.class)
        );

        List<Metal> metals = indeconService.obtieneUltimosValores();

        assertNotNull(metals);

    }

}