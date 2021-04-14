package br.ufes.weatherdatadisplay.model;

import java.time.LocalDate;

/**
 *
 * @author pedroh
 */
public class TempoStatistico extends RegistroTempo{
    private Integer quantidadeTempo;

    public TempoStatistico() {
    }

    public TempoStatistico(LocalDate data, Double temperatura, Double humidade, Double pressao, Integer quantidadeTempo) {
        super(data, temperatura, humidade, pressao);
        this.quantidadeTempo = quantidadeTempo;
    }

    public Integer getQuantidadeTempo() {
        return quantidadeTempo;
    }

    public void setQuantidadeTempo(Integer quantidadeTempo) {
        this.quantidadeTempo = quantidadeTempo;
    }
    
    
    
    
}
