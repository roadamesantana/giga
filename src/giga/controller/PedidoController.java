package giga.controller;

import giga.model.Pedido;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Ronald
 */
public class PedidoController {
    private static PedidoController instancia;
    
    private DefaultTableModel model;
    
    
    private PedidoController(){
        model = new DefaultTableModel(new Object[]{"Nota Fiscal", "Data", "Frete", "Desconto", "Total"},0);
    }
    
    public static PedidoController getInstancia(){
        if( null == instancia ){
            instancia = new PedidoController();
        }
        
        return instancia;
    }
    
    public DefaultTableModel getTableModel(){
        return model;
    }
    
    public void addPedido(Pedido pedido){
        if ( null == pedido ) {
            return;
        }
        
        model.addRow(new Object[]{
                                    pedido.getNotaFiscal(), 
                                    pedido.getDataHora(),
                                    pedido.getValorFrete(),
                                    pedido.getDesconto(),
                                    pedido.getValorTotal()
        });
    }
}
