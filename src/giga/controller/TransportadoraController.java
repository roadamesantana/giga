package giga.controller;

import giga.model.Transportadora;
import giga.model.dao.TransportadoraDAO;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Ronald
 */
public class TransportadoraController {
    private static TransportadoraController instancia;
    
    private static DefaultTableModel model;
    
    private static TransportadoraDAO transpDAO;
    
    private Transportadora transportadoraEditada;
    
    private TransportadoraController(){
        model = new DefaultTableModel(new Object[]{"ID","Nome"},0);
        transpDAO = new TransportadoraDAO();
    }
    
    public static TransportadoraController getInstancia(){
        if ( null == instancia ){
            instancia = new TransportadoraController();
        }
        
        return instancia;
    }
    
    public static void recarregarModelo(){
        model.setRowCount(0);
        
        ArrayList<Object> transp = transpDAO.listar();
        
        for (Object obj : transp) {
            Transportadora t = (Transportadora)obj;
            model.addRow(new Object[]{ t.getID(), t.getNome() });
        }
        
        model.fireTableDataChanged();
    }
    
    public DefaultTableModel getTableModel(){
        return model;
    }

    public Transportadora getTransportadoraEditada() {
        return transportadoraEditada;
    }

    public void setTransportadoraEditada(Transportadora transportadoraEditada) {
        this.transportadoraEditada = transportadoraEditada;
    }
    
    public void addTransportadora(Transportadora transportadora){
        if ( null == transportadora ) {
            return;
        }
        
        transpDAO.salvar(transportadora);
        
        recarregarModelo();
    }
    
    public void editarTransportadora(Transportadora transportadora){
        if ( null == transportadora ) {
            return;
        }
        
        transpDAO.editar(transportadora);
        
        recarregarModelo();
    }
    
    public static Transportadora getTransportadoraByID(int id){
        return (Transportadora)transpDAO.getByID(id);
    }
    
    public static void apagar(int id){
        transpDAO.apagar(id);
        recarregarModelo();
    }
}
