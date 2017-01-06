package giga.controller;

import giga.model.Transportadora;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Ronald
 */
public class TransportadoraController {
    private static TransportadoraController instancia;
    
    private DefaultTableModel model;
    
    private TransportadoraController(){
        model = new DefaultTableModel(new Object[]{"Nome"},0);
    }
    
    public static TransportadoraController getInstancia(){
        if ( null == instancia ){
            instancia = new TransportadoraController();
        }
        
        return instancia;
    }
    
    public DefaultTableModel getTableModel(){
        return model;
    }
    
    public void addTransportadora(Transportadora transportadora){
        if ( null == transportadora ) {
            return;
        }
        
        model.addRow(new Object[]{ transportadora.getNome() });
    }
}
