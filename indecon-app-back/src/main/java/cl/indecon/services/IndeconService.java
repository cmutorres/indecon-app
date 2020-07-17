package cl.indecon.services;

import cl.indecon.domain.Metal;
import cl.indecon.domain.valoresKey.Valores;
import cl.indecon.domain.valoresAnio.ValoresAnio;
import cl.indecon.enums.KeyIndecon;

import java.util.List;

public interface IndeconService {

    List<Metal> obtieneUltimosValores() ;

    Valores obtieneValores(KeyIndecon keyIndecon) ;

    ValoresAnio obtieneValoresAnio(KeyIndecon keyIndecon) ;
}
