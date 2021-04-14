/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufes.weatherdatadisplay.presenter;

import br.ufes.weatherdatadisplay.collection.RegistrosTempoCollection;
import br.ufes.weatherdatadisplay.model.RegistroTempo;
import br.ufes.weatherdatadisplay.observer.Observador;
import br.ufes.weatherdatadisplay.view.RegistroView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.format.DateTimeFormatter;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author pedroh
 */
public class RegistroPresenter implements IJInternalFramePresenter, Observador{
    private final RegistroView registroView;
    private RegistrosTempoCollection registrosTempo;

    public RegistroPresenter(RegistroView registroView, RegistrosTempoCollection registrosTempo) {
        this.registroView = registroView;
        this.registrosTempo = registrosTempo;
        atualizarTabela();
        
        this.registroView.getBtnRemover().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                removerRegistroTabela();
            }
        });
    }
    
    public void atualizarTabela(){
        DefaultTableModel tableModel = (DefaultTableModel) registroView.getTbRegistros().getModel();
        
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        
        for (int i = registroView.getTbRegistros().getRowCount() - 1; i >= 0; --i){
            tableModel.removeRow(i);
        }
        
        Integer count = 0;
        for(RegistroTempo t : registrosTempo.getList()){
            tableModel.addRow(new Object[]{++count, t.getData().format(dtf), t.getTemperatura(), t.getHumidade(), t.getPressao()});
        }
        
    }
    
    private void removerRegistroTabela(){
        int tempoSelecionado = registroView.getTbRegistros().getSelectedRow();
        
        if(tempoSelecionado < 0){
            JOptionPane.showMessageDialog(null, "Nenhum tempo foi selecionado para a remoção", "Falha ao remover", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        DefaultTableModel tableModel = (DefaultTableModel) registroView.getTbRegistros().getModel();
        tableModel.removeRow(tempoSelecionado);
        registrosTempo.delete(tempoSelecionado);
        
    }

    @Override
    public JInternalFrame getView() {
        return this.registroView;
    }

    @Override
    public void update(RegistrosTempoCollection registrosTempo) {
        this.registrosTempo = registrosTempo;
        atualizarTabela();
    }
    
}
