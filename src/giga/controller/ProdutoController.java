package giga.controller;

import giga.model.Fornecedor;
import giga.model.Produto;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Ronald
 */
public class ProdutoController {
    private static ProdutoController instancia;
    
    private DefaultComboBoxModel modelComboFornecedores;
    private DefaultTableModel model; 
    
    private ProdutoController(){
        model = new DefaultTableModel(new Object[]{"Nome","Descrição"},0);
    }
    
    public static ProdutoController getInstancia(){
        if ( null == instancia ) {
            instancia = new ProdutoController();
        }
        
        return instancia;
    }
    
    public void addProduto(Produto produto){
        if ( null == produto ){
            return;
        }
        
        model.addRow(new Object[]{
                                    produto.getNome(), 
                                    produto.getDescricao()
        });
    }
    
    public DefaultComboBoxModel getComboForncedoresModel(){
        final Vector vector = FornecedorController.getInstancia().getTableModel().getDataVector();
        modelComboFornecedores = new DefaultComboBoxModel();
        
        for(int index = 0; index < vector.size(); index ++){
            final Vector v = (Vector)vector.get(index);
            Fornecedor fornecedor = new Fornecedor();
            fornecedor.setNome((String)v.get(0));
            fornecedor.setDescricao((String)v.get(1));
            fornecedor.setEndereco((String)v.get(2));
            fornecedor.setNumero((Integer)v.get(3));
            fornecedor.setBairro((String)v.get(4));
            fornecedor.setCidade((String)v.get(5));
            
            modelComboFornecedores.addElement(fornecedor);
        }
        
        return modelComboFornecedores;
    }

    public DefaultTableModel getModel() {
        return model;
    }
}
