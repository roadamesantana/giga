package giga.controller;

import giga.model.Fornecedor;
import giga.model.dao.FornecedorDAO;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 * @author Ronald
 */
public class FornecedorController {
    private static FornecedorController instancia;
    
    private static DefaultTableModel model;
    
    private static FornecedorDAO fornecedorDAO;
    
    private FornecedorController(){
        model = new DefaultTableModel(new Object[]{"ID", "Nome", "Descrição", "Endereço", "Número", "Bairro", "Cidade"},0);
        
        fornecedorDAO = new FornecedorDAO();
    }
    
    public static FornecedorController getInstancia(){
        if ( null == instancia ){
            instancia = new FornecedorController();
        }
        
        return instancia;
    }
    
    public static void recarregarModelo(){
        model.setRowCount(0);
        
        ArrayList<Object> fornecedor = fornecedorDAO.listar();
        
        for (Object obj : fornecedor) {
            Fornecedor f = (Fornecedor)obj;
            model.addRow(new Object[]{ 
                f.getID(), 
                f.getNome(), 
                f.getDescricao(),
                f.getEndereco(),
                f.getNumero(),
                f.getBairro(),
                f.getCidade() 
            });
        }
        
        model.fireTableDataChanged();
    }
    
    public DefaultTableModel getTableModel(){
        return model;
    }
    
    public void addFornecedor(Fornecedor fornecedor){
        if ( null == fornecedor ) {
            return;
        }
        
        fornecedorDAO.salvar(fornecedor);
        
        recarregarModelo();
    }
    
    public void editarFornecedor(Fornecedor fornecedor){
        if ( null == fornecedor ) {
            return;
        }
        
        fornecedorDAO.editar(fornecedor);
        
        recarregarModelo();
    }
    
    public static void apagar(int id){
        fornecedorDAO.apagar(id);
        recarregarModelo();
    }
    
    public static Fornecedor getByID(int id){
        return (Fornecedor)fornecedorDAO.getByID(id);
    }
}
