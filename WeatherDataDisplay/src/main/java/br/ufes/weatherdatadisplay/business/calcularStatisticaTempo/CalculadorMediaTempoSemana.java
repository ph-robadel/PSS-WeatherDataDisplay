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
public class CalculadorMediaTempoSemana extends CalculadorMediaTempo{

    @Override
    protected List<RegistroTempo> filtrarPeriodo(RegistrosTempoCollection registros) {
        var hoje = LocalDate.now();
        var primeiroDiaSemana = hoje.plusDays(- hoje.getDayOfWeek().getValue()); // Domingo
        var listStream = registros.getList().stream();
        
        // Menor ou igual a data atual && Menor ou igual ao útlimo domigo.
        var streamFilter = listStream.filter((tempo) -> tempo.getData().isBefore(hoje.plusDays(1)) && tempo.getData().isAfter(primeiroDiaSemana.plusDays(-1)) );
       
        return streamFilter.collect(Collectors.toList());
    }
    
}
