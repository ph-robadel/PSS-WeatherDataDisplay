package br.ufes.weatherdatadisplay.presenter;

import br.ufes.weatherdatadisplay.collection.RegistrosTempoCollection;
import br.ufes.weatherdatadisplay.model.RegistroTempo;
import br.ufes.weatherdatadisplay.view.CadastroTempoView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author pedroh
 */
public class CadastroTempoPresenter implements IJInternalFramePresenter{
    private final CadastroTempoView cadastroTempoView;
    private RegistrosTempoCollection registros;

    public CadastroTempoPresenter(CadastroTempoView cadastroTempoView, RegistrosTempoCollection registros) {
        this.cadastroTempoView = cadastroTempoView;
        this.registros = registros;
        
        this.cadastroTempoView.getBtnIncluir().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                try{
                    validarCampos();
                    incluir();
                    limparCampos();
                    JOptionPane.showMessageDialog(null, "Dados do tempo salvo com sucesso!", "Cadastro Concluído", JOptionPane.INFORMATION_MESSAGE);
                }catch(RuntimeException re){
                    JOptionPane.showMessageDialog(null, re.getMessage(), "Campo Inválido", JOptionPane.WARNING_MESSAGE);
                }
                
            }
        });
    }
    
    public void validarCampos() throws RuntimeException{
        if(this.cadastroTempoView.getFtfData().getText().equals("  /  /    ")){
            throw new RuntimeException("A data não foi informada!");
        }
        
        if(this.cadastroTempoView.getFtfTemperatura().getText().isEmpty()){
            throw new RuntimeException("A temperatura não foi informada!");
        }
        
        if(this.cadastroTempoView.getFtfHumidade().getText().isEmpty()){
            throw new RuntimeException("A humidade não foi informada!");
        }
        
        if(this.cadastroTempoView.getFtfPressao().getText().isEmpty()){
            throw new RuntimeException("A pressão não foi informada!");
        }
    }
    
    
    public void incluir(){
        RegistroTempo registro = new RegistroTempo();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        
        registro.setData(LocalDate.parse(this.cadastroTempoView.getFtfData().getText(), dtf));
        registro.setTemperatura(Double.parseDouble(this.cadastroTempoView.getFtfTemperatura().getText().replace(",", ".")));
        registro.setHumidade(Double.parseDouble(this.cadastroTempoView.getFtfHumidade().getText().replace(",", ".")));
        registro.setPressao(Double.parseDouble(this.cadastroTempoView.getFtfPressao().getText().replace(",", ".")));
        
        registros.add(registro);
    }
    
    
    private void limparCampos(){
        this.cadastroTempoView.getFtfData().setText("");
        this.cadastroTempoView.getFtfTemperatura().setText("");
        this.cadastroTempoView.getFtfHumidade().setText("");
        this.cadastroTempoView.getFtfPressao().setText("");
    }

    @Override
    public JInternalFrame getView() {
        return this.cadastroTempoView;
    }
    
}
