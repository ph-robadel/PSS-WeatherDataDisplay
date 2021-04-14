package br.ufes.weatherdatadisplay.model;

import java.time.LocalDate;

/**
 *
 * @author pedroh
 */
public class RegistroTempo extends Tempo{
    private LocalDate data;

    public RegistroTempo() {
    }
    
    public RegistroTempo(LocalDate data, Double temperatura, Double humidade, Double pressao) {
        super(temperatura, humidade, pressao);
        this.data = data;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }
    
}
