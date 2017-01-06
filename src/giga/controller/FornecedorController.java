package giga.controller;

import giga.model.Fornecedor;
import javax.swing.table.DefaultTableModel;

/**
 * @author Ronald
 */
public class FornecedorController {
    private static FornecedorController instancia;
    
    private DefaultTableModel model;
    
    private FornecedorController(){
        model = new DefaultTableModel(new Object[]{"Nome", "Descrição", "Endereço", "Número", "Bairro", "Cidade"},0);
    }
    
    public static FornecedorController getInstancia(){
        if ( null == instancia ){
            instancia = new FornecedorController();
        }
        
        return instancia;
    }
    
    public DefaultTableModel getTableModel(){
        return model;
    }
    
    public void addFornecedor(Fornecedor fornecedor){
        if ( null == fornecedor ) {
            return;
        }
        
        model.addRow(new Object[]{
                                    fornecedor.getNome(), 
                                    fornecedor.getDescricao(),
                                    fornecedor.getEndereco(),
                                    fornecedor.getNumero(),
                                    fornecedor.getBairro(),
                                    fornecedor.getCidade()
        });
    }
}
