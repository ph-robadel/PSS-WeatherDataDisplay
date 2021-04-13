package br.ufes.weatherdatadisplay.collection;

import br.ufes.weatherdatadisplay.model.Tempo;
import br.ufes.weatherdatadisplay.observer.Observado;
import br.ufes.weatherdatadisplay.observer.Observador;
import java.util.ArrayList;

/**
 *
 * @author pedroh
 */
public class TempoCollection extends Observado{
    ArrayList<Tempo> tempos;

    public TempoCollection() {
        tempos = new ArrayList<>();
    }
    
    public TempoCollection(ArrayList<Tempo> tempos) {
        tempos = tempos;
    }
    
    public void add(Tempo tempo){
        tempos.add(tempo);
        notificar();
    }
    
    public void delete(int index){
        tempos.remove(index);
        notificar();
    }
    
    public Tempo getUltimo(){
        return tempos.get(tempos.size()-1);
    }
    
    public int size(){
        return this.tempos.size();
    }

    @Override
    public void notificar() {
        for(Observador observador : super.observadores){
            observador.update(this);
        }
    }
    
}
