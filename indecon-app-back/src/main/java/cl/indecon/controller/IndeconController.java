package cl.indecon.controller;

import cl.indecon.domain.Metal;
import cl.indecon.domain.valoresKey.Valores;
import cl.indecon.domain.valoresAnio.ValoresAnio;
import cl.indecon.enums.KeyIndecon;
import cl.indecon.services.IndeconService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Controller con servicios que consumen indices de indecon
 */
@RestController
public class IndeconController {

    @Autowired
    private IndeconService indeconService;

    /**
     * Disponibiliza indices con últimos valores detectados por indecon
     *
     * @return list
     */
    @CrossOrigin(origins = "*", methods = {RequestMethod.GET})
    @GetMapping(value = "/ultimos-valores")
    public ResponseEntity<List<Metal>> obtieneUltimosValores() {
        List<Metal> ultimosValores = indeconService.obtieneUltimosValores();
        return ResponseEntity.ok(ultimosValores);
    }

    /**
     *
     * @param keyIndecon
     * @return
     */
    @CrossOrigin(origins = "*", methods = {RequestMethod.GET})
    @GetMapping(value = "/valores")
    public ResponseEntity<Valores> obtieneValores(@RequestParam KeyIndecon keyIndecon) {
        Valores ultimosValores = indeconService.obtieneValores(keyIndecon);
        return ResponseEntity.ok(ultimosValores);
    }

    /**
     * Disponibiliza Valor medio por un indice especifico
     *
     * @param keyIndecon
     * @return
     */
    @CrossOrigin(origins = "*", methods = {RequestMethod.GET})
    @GetMapping(value = "/valores/anio")
    public ResponseEntity<ValoresAnio> obtieneValoresAnio(@RequestParam KeyIndecon keyIndecon) {
        ValoresAnio valoresAnio = indeconService.obtieneValoresAnio(keyIndecon);
        return ResponseEntity.ok(valoresAnio);
    }

}
