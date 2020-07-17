package cl.indecon.controller;

import cl.indecon.domain.Metal;
import cl.indecon.domain.valoresAnio.ValoresAnio;
import cl.indecon.domain.valoresKey.Valores;
import cl.indecon.enums.KeyIndecon;
import cl.indecon.services.IndeconService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
public class IndeconControllerTest {

    @InjectMocks
    IndeconController indeconController;

    @Mock
    IndeconService indeconService;

    @Before
    public void beforeClass() throws Exception {
        when(indeconService.obtieneUltimosValores())
                .thenReturn(new ArrayList<>());

        when(indeconService.obtieneValoresAnio(any(KeyIndecon.class)))
                .thenReturn(new ValoresAnio());

        when(indeconService.obtieneValores(any(KeyIndecon.class)))
                .thenReturn(new Valores());
    }

    @Test
    public void testKey() {
        ResponseEntity<List<Metal>> entity = indeconController.obtieneUltimosValores();
        assertEquals(200, entity.getStatusCode().value());
    }

    @Test
    public void testValores() {
        ResponseEntity<Valores> entity = indeconController.obtieneValores(KeyIndecon.COBRE);
        assertEquals(200, entity.getStatusCode().value());
    }

    @Test
    public void testValoresAnio() {
        ResponseEntity<ValoresAnio> entity = indeconController.obtieneValoresAnio(KeyIndecon.COBRE);
        assertEquals(200, entity.getStatusCode().value());
    }
}