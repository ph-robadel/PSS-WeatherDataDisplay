package br.ufes.weatherdatadisplay.presenter;

import br.ufes.weatherdatadisplay.business.calcularStatisticaTempo.CalculadorMediaTempoDia;
import br.ufes.weatherdatadisplay.business.calcularStatisticaTempo.CalculadorMediaTempoMes;
import br.ufes.weatherdatadisplay.business.calcularStatisticaTempo.CalculadorMediaTempoSemana;
import br.ufes.weatherdatadisplay.collection.RegistrosTempoCollection;
import br.ufes.weatherdatadisplay.model.TempoStatistico;
import br.ufes.weatherdatadisplay.observer.Observador;
import br.ufes.weatherdatadisplay.view.DadosMediosTempoView;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.JInternalFrame;
import br.ufes.weatherdatadisplay.business.calcularStatisticaTempo.CalculadorStatisticaTempo;

/**
 *
 * @author pedroh
 */
public class DadosMediosTempoPresenter implements IJInternalFramePresenter, Observador{
    private final DadosMediosTempoView dadosMediosTempoView;
    private RegistrosTempoCollection registrosTempo;
    private CalculadorStatisticaTempo calculadorStatistico;

    public DadosMediosTempoPresenter(DadosMediosTempoView dadosMediosTempoView) {
        this.dadosMediosTempoView = dadosMediosTempoView;
        this.registrosTempo = registrosTempo;
        atualizarCalculador();
        
        this.dadosMediosTempoView.getCbPeriodo().addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent arg0) {
                atualizarCalculador();
            }
        });
    }
    
    private void atualizarCalculador(){
        String opcaoSelecionada = (String) this.dadosMediosTempoView.getCbPeriodo().getSelectedItem();
        if(opcaoSelecionada.equalsIgnoreCase("DIÁRIO")){
            calculadorStatistico = new CalculadorMediaTempoDia();
        }else if(opcaoSelecionada.equalsIgnoreCase("SEMANAL")){
            calculadorStatistico = new CalculadorMediaTempoSemana();
        }else if(opcaoSelecionada.equalsIgnoreCase("MENSAL")){
            calculadorStatistico = new CalculadorMediaTempoMes();
        }
        
        calcularMedia();
    }
    
    public void atualizarCampos(TempoStatistico tempoStatistico){
        
        dadosMediosTempoView.getLbdTemperatura().setText(String.format("%.2f", tempoStatistico.getTemperatura()));
        dadosMediosTempoView.getLbdHumidade().setText(String.format("%.2f",tempoStatistico.getHumidade()));
        dadosMediosTempoView.getLbdPressao().setText(String.format("%.2f",tempoStatistico.getPressao()));
        dadosMediosTempoView.getLbdRegistros().setText(String.valueOf(tempoStatistico.getQuantidadeTempo()));
    }
    
    public void limparCampos(){
        
        dadosMediosTempoView.getLbdTemperatura().setText("");
        dadosMediosTempoView.getLbdHumidade().setText("");
        dadosMediosTempoView.getLbdPressao().setText("");
        dadosMediosTempoView.getLbdRegistros().setText("0");
    }
    
    @Override
    public JInternalFrame getView() {
        return this.dadosMediosTempoView;
    }
    
    private void calcularMedia(){
        try{
            TempoStatistico tempo = calculadorStatistico.calcular(this.registrosTempo);
            atualizarCampos(tempo);
        }catch(RuntimeException re){
            limparCampos();
        }
    }

    @Override
    public void update(RegistrosTempoCollection registrosTempo) {
        this.registrosTempo = registrosTempo;
        calcularMedia();        
    }
    
    
    
}
