package br.ufes.weatherdatadisplay.presenter;

import br.ufes.weatherdatadisplay.collection.TempoCollection;
import br.ufes.weatherdatadisplay.model.Tempo;
import br.ufes.weatherdatadisplay.view.DadosMediosTempoView;
import java.time.format.DateTimeFormatter;
import javax.swing.JInternalFrame;

/**
 *
 * @author pedroh
 */
public class DadosMediosTempoPresenter implements IJInternalFramePresenter{
    private final DadosMediosTempoView dadosMediosTempoView;
    private TempoCollection registrosTempo;

    public DadosMediosTempoPresenter(DadosMediosTempoView dadosMediosTempoView) {
        this.dadosMediosTempoView = dadosMediosTempoView;
        this.registrosTempo = registrosTempo;
    }
    
    public void atualizarCampos(Tempo tempo, int numeroRegistros){
        dadosMediosTempoView.getLbdTemperatura().setText(String.valueOf(tempo.getTemperatura()));
        dadosMediosTempoView.getLbdHumidade().setText(String.valueOf(tempo.getHumidade()));
        dadosMediosTempoView.getLbdPressao().setText(String.valueOf(tempo.getPressao()));
        dadosMediosTempoView.getLbdRegistros().setText(String.valueOf(numeroRegistros));
    }

    @Override
    public JInternalFrame getView() {
        return this.dadosMediosTempoView;
    }
    
}
