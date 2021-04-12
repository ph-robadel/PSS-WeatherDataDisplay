package br.ufes.weatherdatadisplay.collection;

import br.ufes.weatherdatadisplay.model.Tempo;
import java.util.ArrayList;

/**
 *
 * @author pedroh
 */
public class TempoCollection {
    ArrayList<Tempo> tempos;

    public TempoCollection() {
        tempos = new ArrayList<>();
    }
    
    public TempoCollection(ArrayList<Tempo> tempos) {
        this.tempos = tempos;
    }
    
    public void add(Tempo tempo){
        this.tempos.add(tempo);
    }
    
    public int size(){
        return this.tempos.size();
    }
    
}
