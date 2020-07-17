package cl.indecon.converter;


import cl.indecon.domain.valoresAnio.ValoresAnio;
import cl.indecon.fixture.LastFixture;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class RsValoresAnioToValoresTest {

    @InjectMocks
    RsValoresAnioToValores rsValoresAnioToValores;

    @Test
    public void name() {
        ValoresAnio convert = rsValoresAnioToValores.convert(LastFixture.getRsMetalesForKey());

        Assert.assertNotEquals("", convert.getKey());
        Assert.assertEquals("cobre", convert.getKey());
    }
}