package br.ufes.weatherdatadisplay.principal;

import br.ufes.weatherdatadisplay.collection.RegistrosTempoCollection;
import br.ufes.weatherdatadisplay.model.RegistroTempo;
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
        
        RegistrosTempoCollection registrosTempo = new RegistrosTempoCollection();
        
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
        
        // Adicionando os Observadores
        registrosTempo.add(ultimaAtualizacaoTempoPresenter);
        registrosTempo.add(dadosMediosTempoPresenter);
        registrosTempo.add(registroPresenter);
        registrosTempo.add(configuracaoDoSistemaPresenter);
        registrosTempo.add(new PrincipalPresenter(registrosTempo, presenters));
        
        registrosTempo.add(new RegistroTempo(LocalDate.now(), 15D, 70D, 95D));
        registrosTempo.add(new RegistroTempo(LocalDate.now(), 20D, 65D, 980D));
        registrosTempo.add(new RegistroTempo(LocalDate.now().plusDays(-1), 25D, 60D, 100D));
        
    }
}
