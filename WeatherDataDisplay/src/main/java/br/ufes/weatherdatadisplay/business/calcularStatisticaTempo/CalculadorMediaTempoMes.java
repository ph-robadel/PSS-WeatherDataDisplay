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
public class CalculadorMediaTempoMes extends CalculadorMediaTempo{

    @Override
    protected List<RegistroTempo> filtrarPeriodo(RegistrosTempoCollection registros) {
        var hoje = LocalDate.now();
        var primeiroDiaMes = hoje.plusDays( 1 - hoje.getDayOfMonth() );
        var listStream = registros.getList().stream();
        
        // Menor ou igual a data atual && Menor ou igual ao dia 01/mesAtual
        var streamFilter = listStream.filter((tempo) -> tempo.getData().isBefore(hoje.plusDays(1)) && tempo.getData().isAfter(primeiroDiaMes.plusDays(-1)) );
       
        return streamFilter.collect(Collectors.toList());
    }
    
}
