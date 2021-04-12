package br.ufes.weatherdatadisplay.presenter;

import br.ufes.weatherdatadisplay.collection.TempoCollection;
import br.ufes.weatherdatadisplay.view.CadastroTempoView;
import br.ufes.weatherdatadisplay.view.ConfiguracaoDoSistemaView;
import br.ufes.weatherdatadisplay.view.DadosMediosTempoView;
import br.ufes.weatherdatadisplay.view.PrincipalView;
import br.ufes.weatherdatadisplay.view.RegistroView;
import br.ufes.weatherdatadisplay.view.UltimaAtualizacaoTempoView;

/**
 *
 * @author pedroh
 */
public class PrincipalPresenter {
    private final TempoCollection registrosTempo;
    private final PrincipalView principalView;
    private final CadastroTempoPresenter cadastroTempoPresenter;
    private final UltimaAtualizacaoTempoPresenter ultimaAtualizacaoTempoPresenter;
    private final DadosMediosTempoPresenter dadosMediosTempoPresenter;
    private final RegistroPresenter registroPresenter;

    public PrincipalPresenter(TempoCollection registrosTempo) {
        this.registrosTempo = registrosTempo;
        principalView = new PrincipalView();
        principalView.getLbdRegistros().setText(String.valueOf(registrosTempo.size()));
        
        
        var cadastroTempoView = new CadastroTempoView();
        principalView.getPnlFundo().add(cadastroTempoView);
        cadastroTempoView.setLocation(15, 15);
        this.cadastroTempoPresenter = new CadastroTempoPresenter(cadastroTempoView, this.registrosTempo);
        
        
        var ultimaAtualizacaoTempoView = new UltimaAtualizacaoTempoView();
        principalView.getPnlFundo().add(ultimaAtualizacaoTempoView);
        ultimaAtualizacaoTempoView.setLocation(15, 250);
        this.ultimaAtualizacaoTempoPresenter = new UltimaAtualizacaoTempoPresenter(ultimaAtualizacaoTempoView);
        
        var dadosMediosTempoView = new DadosMediosTempoView();
        principalView.getPnlFundo().add(dadosMediosTempoView);
        dadosMediosTempoView.setLocation(280, 15);
        this.dadosMediosTempoPresenter = new DadosMediosTempoPresenter(dadosMediosTempoView);
        
        
        var registroView = new RegistroView();
        principalView.getPnlFundo().add(registroView);
        registroView.setLocation(280, 205);
        registroPresenter = new RegistroPresenter(registroView, registrosTempo);
        
        var configuracaoDoSistemaView = new ConfiguracaoDoSistemaView();
        principalView.getPnlFundo().add(configuracaoDoSistemaView);
        configuracaoDoSistemaView.setLocation(523, 15);
        
    }
    
    
    
}
