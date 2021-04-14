package br.ufes.weatherdatadisplay.presenter;

import br.ufes.weatherdatadisplay.collection.RegistrosTempoCollection;
import br.ufes.weatherdatadisplay.observer.Observador;
import br.ufes.weatherdatadisplay.view.PrincipalView;
import java.util.ArrayList;

/**
 *
 * @author pedroh
 */
public class PrincipalPresenter implements Observador{
    private final RegistrosTempoCollection registrosTempo;
    private final PrincipalView principalView;

    public PrincipalPresenter(RegistrosTempoCollection registrosTempo, ArrayList<IJInternalFramePresenter> presenters) {
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

    @Override
    public void update(RegistrosTempoCollection registrosTempo) {
        atualizarRegistro(registrosTempo.size());
    }
    
}
