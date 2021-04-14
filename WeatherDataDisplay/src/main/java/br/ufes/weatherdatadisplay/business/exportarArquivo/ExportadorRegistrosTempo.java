/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufes.weatherdatadisplay.business.exportarArquivo;

import br.ufes.weatherdatadisplay.collection.RegistrosTempoCollection;

/**
 *
 * @author pedroh
 */
public interface ExportadorRegistrosTempo {
    public void exportar(RegistrosTempoCollection registros);
}
