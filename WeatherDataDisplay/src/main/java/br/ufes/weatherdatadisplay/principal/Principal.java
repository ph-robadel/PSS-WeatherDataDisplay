package br.ufes.weatherdatadisplay.principal;

import br.ufes.weatherdatadisplay.collection.TempoCollection;
import br.ufes.weatherdatadisplay.model.Tempo;
import br.ufes.weatherdatadisplay.presenter.CadastroTempoPresenter;
import br.ufes.weatherdatadisplay.presenter.ConfiguracaoDoSistemaPresenter;
import br.ufes.weatherdatadisplay.presenter.DadosMediosTempoPresenter;
import br.ufes.weatherdatadisplay.presenter.IJInternalFramePresenter;
import br.ufes.weatherdatadisplay.presenter.PrincipalPresenter;
import br.ufes.weatherdatadisplay.presenter.RegistroPresenter;
import br.ufes.weatherdatadisplay.presenter.UltimaAtualizacaoTempoPresenter;
import br.ufes.weatherdatadisplay.view.CadastroTempoView;
import br.ufes.weatherdatadisplay.view.ConfiguracaoDoSistemaView;
import br.ufes.weatherdatadisplay.view.DadosMediosTempoView;
import br.ufes.weatherdatadisplay.view.RegistroView;
import br.ufes.weatherdatadisplay.view.UltimaAtualizacaoTempoView;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author Pedro Henrique Robadel
 */
public class Principal {
    public static void main(String[] args) {
        
        TempoCollection registrosTempo = new TempoCollection();
        
        var ultimaAtualizacaoTempoPresenter = new UltimaAtualizacaoTempoPresenter(new UltimaAtualizacaoTempoView());
        var dadosMediosTempoPresenter = new DadosMediosTempoPresenter(new DadosMediosTempoView());
        var registroPresenter = new RegistroPresenter(new RegistroView(), registrosTempo);
        var configuracaoDoSistemaPresenter = new ConfiguracaoDoSistemaPresenter(new ConfiguracaoDoSistemaView(), registrosTempo);
        
        ArrayList<IJInternalFramePresenter> presenters = new ArrayList<>();
        presenters.add(new CadastroTempoPresenter(new CadastroTempoView(), registrosTempo));
        presenters.add(ultimaAtualizacaoTempoPresenter);
        presenters.add(dadosMediosTempoPresenter);
        presenters.add(registroPresenter);
        presenters.add(configuracaoDoSistemaPresenter);
        
        registrosTempo.add(ultimaAtualizacaoTempoPresenter);
        registrosTempo.add(new PrincipalPresenter(registrosTempo, presenters));
        
        registrosTempo.add(new Tempo(LocalDate.now(), 15D, 78D, 95D));
        registrosTempo.add(new Tempo(LocalDate.now(), 45D, 67D, 980D));
        
    }
}
