package br.ufes.weatherdatadisplay.model;

import java.time.LocalDate;

/**
 *
 * @author pedroh
 */
public class Tempo {
    private LocalDate data;
    private Double temperatura;
    private Double humidade;
    private Double pressao;

    public Tempo() {
    }
    
    public Tempo(LocalDate data, Double temperatura, Double humidade, Double pressao) {
        this.data = data;
        this.temperatura = temperatura;
        this.humidade = humidade;
        this.pressao = pressao;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
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
