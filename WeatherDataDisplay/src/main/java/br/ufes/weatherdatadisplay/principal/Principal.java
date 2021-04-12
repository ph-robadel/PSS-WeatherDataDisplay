package br.ufes.weatherdatadisplay.principal;

import br.ufes.weatherdatadisplay.collection.TempoCollection;
import br.ufes.weatherdatadisplay.presenter.PrincipalPresenter;

/**
 *
 * @author Pedro Henrique Robadel
 */
public class Principal {
    public static void main(String[] args) {
        
        TempoCollection tempos = new TempoCollection();
        PrincipalPresenter principalPresenter = new PrincipalPresenter(tempos);
    }
}
