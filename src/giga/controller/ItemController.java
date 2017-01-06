package giga.controller;

import giga.model.Item;
import giga.model.Produto;
import giga.view.reg.RegistrarItemView;
import java.awt.Frame;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;

/**
 *
 * @author Ronald
 */
public class ItemController {
    private static ItemController instancia; 
    
    private DefaultComboBoxModel modelComboProdutos;
    private static DefaultListModel modelItens;
    
    public static ItemController getInstancia(){
        if ( null == instancia ) {
            instancia = new ItemController();
        }
        
        return instancia;
    }
    
    public DefaultComboBoxModel getComboProdutosModel(){
        final Vector vector = ProdutoController.getInstancia().getModel().getDataVector();
        modelComboProdutos = new DefaultComboBoxModel();
        
        for(int index = 0; index < vector.size(); index ++){
            final Vector v = (Vector)vector.get(index);
            Produto produto = new Produto();
            produto.setNome((String)v.get(0));
            produto.setDescricao((String)v.get(1));
            
            modelComboProdutos.addElement(produto);
        }
        
        return modelComboProdutos;
    }
    
    public static DefaultListModel getEmailsListModel() {
        modelItens = new DefaultListModel();
        
        return modelItens;
    }
    
    public static Item getItem(){
        RegistrarItemView view = new RegistrarItemView(new Frame(), true);
        view.setVisible(true);
        Item item = view.getItem();
        
        if ( item.getQuantidade() <=0 ) {
            return null;
        }
        
        return item;
    }
}
