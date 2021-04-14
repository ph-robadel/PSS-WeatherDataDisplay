package br.ufes.weatherdatadisplay.observer;

import br.ufes.weatherdatadisplay.collection.RegistrosTempoCollection;

/**
 *
 * @author pedroh
 */
public interface Observador {
    
    public void update(RegistrosTempoCollection registrosTempo);
    
}
