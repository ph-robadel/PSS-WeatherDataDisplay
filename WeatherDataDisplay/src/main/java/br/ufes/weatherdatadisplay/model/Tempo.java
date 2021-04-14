package br.ufes.weatherdatadisplay.model;

import java.time.LocalDate;

/**
 *
 * @author pedroh
 */
public class Tempo {
    private Double temperatura;
    private Double humidade;
    private Double pressao;

    public Tempo() {
    }
    
    public Tempo(Double temperatura, Double humidade, Double pressao) {
        this.temperatura = temperatura;
        this.humidade = humidade;
        this.pressao = pressao;
    }

    public Double getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(Double temperatura) {
        this.temperatura = temperatura;
    }

    public Double getHumidade() {
        return humidade;
    }

    public void setHumidade(Double humidade) {
        this.humidade = humidade;
    }

    public Double getPressao() {
        return pressao;
    }

    public void setPressao(Double pressao) {
        this.pressao = pressao;
    }
    
}
