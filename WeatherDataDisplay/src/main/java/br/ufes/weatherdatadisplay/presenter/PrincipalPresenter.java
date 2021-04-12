package br.ufes.weatherdatadisplay.presenter;

import br.ufes.weatherdatadisplay.collection.TempoCollection;
import br.ufes.weatherdatadisplay.view.CadastroTempoView;
import br.ufes.weatherdatadisplay.view.ConfiguracaoDoSistemaView;
import br.ufes.weatherdatadisplay.view.DadosMediosTempoView;
import br.ufes.weatherdatadisplay.view.PrincipalView;
import br.ufes.weatherdatadisplay.view.RegistroView;
import br.ufes.weatherdatadisplay.view.UltimaAtualizacaoTempoView;
import java.util.ArrayList;

/**
 *
 * @author pedroh
 */
public class PrincipalPresenter {
    private final TempoCollection registrosTempo;
    private final PrincipalView principalView;

    public PrincipalPresenter(TempoCollection registrosTempo, ArrayList<IJInternalFramePresenter> presenters) {
        this.registrosTempo = registrosTempo;
        
        principalView = new PrincipalView();
        adicionarPresenters(presenters);
        atualizarRegistro(registrosTempo.size());
    }
    
    private void adicionarPresenters(ArrayList<IJInternalFramePresenter> presenters){
        for(IJInternalFramePresenter presenter : presenters){
            this.principalView.getPnlFundo().add(presenter.getView());
        }
    }
    
    public void atualizarRegistro(int quantidadeRegistro){
        principalView.getLbdRegistros().setText(String.valueOf(quantidadeRegistro));
    }
    
}
