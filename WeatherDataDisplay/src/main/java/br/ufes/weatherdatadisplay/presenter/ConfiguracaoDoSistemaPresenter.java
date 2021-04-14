package br.ufes.weatherdatadisplay.presenter;

import br.ufes.weatherdatadisplay.business.exportarArquivo.ExportadorRegistrosTempo;
import br.ufes.weatherdatadisplay.business.exportarArquivo.ExportadorRegistrosTempoJSON;
import br.ufes.weatherdatadisplay.business.exportarArquivo.ExportadorRegistrosTempoXML;
import br.ufes.weatherdatadisplay.collection.RegistrosTempoCollection;
import br.ufes.weatherdatadisplay.observer.Observador;
import br.ufes.weatherdatadisplay.view.ConfiguracaoDoSistemaView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author pedroh
 */
public class ConfiguracaoDoSistemaPresenter implements IJInternalFramePresenter, Observador{
    private final ConfiguracaoDoSistemaView configuracaoDoSistemaView;
    private RegistrosTempoCollection registrosTempo;
    private ExportadorRegistrosTempo exportador;

    public ConfiguracaoDoSistemaPresenter(ConfiguracaoDoSistemaView configuracaoDoSistemaView, RegistrosTempoCollection registrosTempo) {
        this.configuracaoDoSistemaView = configuracaoDoSistemaView;
        this.registrosTempo = registrosTempo;
        atualizarExportador();
        
        this.configuracaoDoSistemaView.getCbLog().addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent arg0) {
                atualizarExportador();
            }
        });
        
        this.configuracaoDoSistemaView.getBtnSalvar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                exportarArquivo();
            }
        });
    }
    
    private void atualizarExportador(){
        String opcaoSelecionada = (String) this.configuracaoDoSistemaView.getCbLog().getSelectedItem();
        if(opcaoSelecionada.equalsIgnoreCase("JSON")){
            exportador = new ExportadorRegistrosTempoJSON();
        }else if(opcaoSelecionada.equalsIgnoreCase("XML")){
            exportador = new ExportadorRegistrosTempoXML();
        }
    }
    
    private void exportarArquivo(){
        exportador.exportar(registrosTempo);
        JOptionPane.showMessageDialog(null, "Registros do tempo salvo com sucesso!", "Exportado", JOptionPane.INFORMATION_MESSAGE);
    }

    @Override
    public JInternalFrame getView() {
        return configuracaoDoSistemaView;
    }

    @Override
    public void update(RegistrosTempoCollection registrosTempo) {
        this.registrosTempo = registrosTempo;
    }
    
}
