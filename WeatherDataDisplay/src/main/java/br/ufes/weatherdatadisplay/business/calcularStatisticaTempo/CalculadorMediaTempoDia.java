/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufes.weatherdatadisplay.business.calcularStatisticaTempo;

import br.ufes.weatherdatadisplay.collection.RegistrosTempoCollection;
import br.ufes.weatherdatadisplay.model.RegistroTempo;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author pedroh
 */
public class CalculadorMediaTempoDia extends CalculadorMediaTempo{

    @Override
    protected List<RegistroTempo> filtrarPeriodo(RegistrosTempoCollection registros) {
        return registros.getList().stream().filter((tempo) -> tempo.getData().isEqual(LocalDate.now())).collect(Collectors.toList());
    }
    
}
