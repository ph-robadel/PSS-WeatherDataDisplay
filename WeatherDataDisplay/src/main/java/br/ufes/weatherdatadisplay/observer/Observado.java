package br.ufes.weatherdatadisplay.observer;

import java.util.ArrayList;

/**
 *
 * @author pedroh
 */
public abstract class Observado {
    protected ArrayList<Observador> observadores;

    public Observado() {
        this.observadores = new ArrayList<>();
    }
    
    public void add(Observador observador){
        observadores.add(observador);
    }
    
    public abstract void notificar();
    
}
