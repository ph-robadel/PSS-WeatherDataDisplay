/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufes.weatherdatadisplay.business.calcularStatisticaTempo;

import br.ufes.weatherdatadisplay.collection.RegistrosTempoCollection;
import br.ufes.weatherdatadisplay.model.RegistroTempo;
import br.ufes.weatherdatadisplay.model.TempoStatistico;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author pedroh
 */
public abstract class CalculadorMediaTempo implements CalculadorStatisticaTempo{
    
    protected abstract List<RegistroTempo> filtrarPeriodo(RegistrosTempoCollection registros);

    @Override
    public TempoStatistico calcular(RegistrosTempoCollection registros) {
        List<RegistroTempo> registrosDoDia = filtrarPeriodo(registros);
        
        int qtdRegistros = registrosDoDia.size();
        
        if(qtdRegistros == 0){
            throw new RuntimeException("Não há nenhum registro a ser calculado");
        }
        
        Double temperatura = 0D;
        Double humidade = 0D;
        Double pressao = 0D;
        
        for(RegistroTempo t: registrosDoDia){
            temperatura += t.getTemperatura();
            humidade += t.getHumidade();
            pressao += t.getPressao();
        }
        
        var tempo = new TempoStatistico();
        tempo.setTemperatura(temperatura/qtdRegistros);
        tempo.setHumidade(humidade/qtdRegistros);
        tempo.setPressao(pressao/qtdRegistros);
        tempo.setQuantidadeTempo(qtdRegistros);
        
        return tempo;
    }
    
}
