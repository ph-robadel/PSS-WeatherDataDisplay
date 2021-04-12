/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufes.weatherdatadisplay.presenter;

import br.ufes.weatherdatadisplay.collection.TempoCollection;
import br.ufes.weatherdatadisplay.view.RegistroView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JInternalFrame;

/**
 *
 * @author pedroh
 */
public class RegistroPresenter implements IJInternalFramePresenter{
    private final RegistroView registroView;
    private final TempoCollection registrosTempo;

    public RegistroPresenter(RegistroView registroView, TempoCollection registrosTempo) {
        this.registroView = registroView;
        this.registrosTempo = registrosTempo;
        this.atualizarTabela();
        
        this.registroView.getBtnRemover().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                removerRegistroTabela();
            }
        });
    }
    
    public void atualizarTabela(){
        
    }
    
    private void removerRegistroTabela(){
        
    }

    @Override
    public JInternalFrame getView() {
        return this.registroView;
    }
    
}
