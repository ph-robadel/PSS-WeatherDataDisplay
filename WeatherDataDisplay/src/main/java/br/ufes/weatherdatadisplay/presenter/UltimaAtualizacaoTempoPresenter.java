package br.ufes.weatherdatadisplay.presenter;

import br.ufes.weatherdatadisplay.collection.RegistrosTempoCollection;
import br.ufes.weatherdatadisplay.model.RegistroTempo;
import br.ufes.weatherdatadisplay.observer.Observador;
import br.ufes.weatherdatadisplay.view.UltimaAtualizacaoTempoView;
import java.time.format.DateTimeFormatter;
import javax.swing.JInternalFrame;

/**
 *
 * @author pedroh
 */
public class UltimaAtualizacaoTempoPresenter implements IJInternalFramePresenter, Observador{
    private final UltimaAtualizacaoTempoView ultimaAtualizacaoTempoView;

    public UltimaAtualizacaoTempoPresenter(UltimaAtualizacaoTempoView ultimaAtualizacaoTempoView) {
        this.ultimaAtualizacaoTempoView = ultimaAtualizacaoTempoView;
    }
    
    public void atualizarCampos(RegistroTempo tempo){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        ultimaAtualizacaoTempoView.getLbdData().setText(tempo.getData().format(dtf));
        ultimaAtualizacaoTempoView.getLbdTemperatura().setText(String.format("%.2f", tempo.getTemperatura()));
        ultimaAtualizacaoTempoView.getLbdHumidade().setText(String.format("%.2f", tempo.getHumidade()));
        ultimaAtualizacaoTempoView.getLbdPressao().setText(String.format("%.2f", tempo.getPressao()));
    }
    
    public void limparCampos(){
        ultimaAtualizacaoTempoView.getLbdData().setText("");
        ultimaAtualizacaoTempoView.getLbdTemperatura().setText("");
        ultimaAtualizacaoTempoView.getLbdHumidade().setText("");
        ultimaAtualizacaoTempoView.getLbdPressao().setText("");
    }

    @Override
    public JInternalFrame getView() {
        return this.ultimaAtualizacaoTempoView;
    }

    @Override
    public void update(RegistrosTempoCollection registrosTempo) {
        try{
            var ultimoRegistro = registrosTempo.getUltimo();
            atualizarCampos(ultimoRegistro);
        }catch(RuntimeException re){
            limparCampos();
        }
    }
}
