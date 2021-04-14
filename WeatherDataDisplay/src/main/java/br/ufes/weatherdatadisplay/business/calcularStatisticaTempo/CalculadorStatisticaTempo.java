package br.ufes.weatherdatadisplay.business.calcularStatisticaTempo;

import br.ufes.weatherdatadisplay.collection.RegistrosTempoCollection;
import br.ufes.weatherdatadisplay.model.TempoStatistico;
import javax.print.attribute.standard.Media;

/**
 *
 * @author pedroh
 */
public interface CalculadorStatisticaTempo {
    public TempoStatistico calcular(RegistrosTempoCollection registros);
}
