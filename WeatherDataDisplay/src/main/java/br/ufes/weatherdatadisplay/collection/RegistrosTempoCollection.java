package br.ufes.weatherdatadisplay.collection;

import br.ufes.weatherdatadisplay.model.RegistroTempo;
import br.ufes.weatherdatadisplay.observer.Observado;
import br.ufes.weatherdatadisplay.observer.Observador;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author pedroh
 */
public class RegistrosTempoCollection extends Observado{
    ArrayList<RegistroTempo> registrosTempos;

    public RegistrosTempoCollection() {
        registrosTempos = new ArrayList<>();
    }
    
    public RegistrosTempoCollection(ArrayList<RegistroTempo> tempos) {
        tempos = tempos;
    }
    
    public void add(RegistroTempo registroTempo){
        registrosTempos.add(registroTempo);
        notificar();
    }
    
    public void delete(int index){
        registrosTempos.remove(index);
        notificar();
    }
    
    public RegistroTempo getUltimo() throws RuntimeException{
        if(size() == 0){
            throw new RuntimeException("A lista está vazia");
        }
        
        return registrosTempos.get(registrosTempos.size()-1);
    }
    
    public int size(){
        return this.registrosTempos.size();
    }
    
    public List<RegistroTempo> getList(){
        return Collections.unmodifiableList(registrosTempos);
    }

    @Override
    public void notificar() {
        for(Observador observador : super.observadores){
            observador.update(this);
        }
    }
    
}
