package br.ufes.weatherdatadisplay.observer;

import br.ufes.weatherdatadisplay.collection.TempoCollection;

/**
 *
 * @author pedroh
 */
public interface Observador {
    
    public void update(TempoCollection registrosTempo);
    
}
