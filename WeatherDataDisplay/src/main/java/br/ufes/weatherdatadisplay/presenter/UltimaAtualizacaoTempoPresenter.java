package br.ufes.weatherdatadisplay.presenter;

import br.ufes.weatherdatadisplay.model.Tempo;
import br.ufes.weatherdatadisplay.view.UltimaAtualizacaoTempoView;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author pedroh
 */
public class UltimaAtualizacaoTempoPresenter {
    private final UltimaAtualizacaoTempoView ultimaAtualizacaoTempoView;

    public UltimaAtualizacaoTempoPresenter(UltimaAtualizacaoTempoView ultimaAtualizacaoTempoView) {
        this.ultimaAtualizacaoTempoView = ultimaAtualizacaoTempoView;
    }
    
    public void atualizarCampos(Tempo tempo){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        ultimaAtualizacaoTempoView.getLbdData().setText(tempo.getData().format(dtf));
        ultimaAtualizacaoTempoView.getLbdTemperatura().setText(String.valueOf(tempo.getTemperatura()));
        ultimaAtualizacaoTempoView.getLbdHumidade().setText(String.valueOf(tempo.getHumidade()));
        ultimaAtualizacaoTempoView.getLbdPressao().setText(String.valueOf(tempo.getPressao()));
    }
}
