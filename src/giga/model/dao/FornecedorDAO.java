package giga.model.dao;

import giga.model.Email;
import giga.model.Fornecedor;
import giga.model.Telefone;
import giga.model.dao.conf.ConexaoDAO;
import giga.model.dao.conf.CrudInterface;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Ronald
 */
public class FornecedorDAO implements CrudInterface{
    private EmailDAO emailDAO;
    private TelefoneDAO telefoneDAO;

    public EmailDAO getEmailDAO() {
        if(null == emailDAO){
            emailDAO = new EmailDAO();
        }
        
        return emailDAO;
    }

    public TelefoneDAO getTelefoneDAO() {
        if( null ==  telefoneDAO ){
            telefoneDAO = new TelefoneDAO();
        }
        
        return telefoneDAO;
    }
    
    @Override
    public Object criar(ResultSet rs) {
        Fornecedor forn = new Fornecedor();

        try {
            final int id = rs.getInt( "id" );
            forn.setID(id);
            forn.setNome( rs.getString( "nome" ) );
            forn.setDescricao( rs.getString( "descricao" ) );
            forn.setCidade( rs.getString( "cidade" ) );
            forn.setEndereco( rs.getString( "endereco" ) );
            forn.setBairro( rs.getString( "Bairro" ) );
            forn.setNumero( rs.getInt( "numero" ) );
            
            forn.setEmails(getEmailDAO().getByFornecedor(id));
            forn.setTelefones(getTelefoneDAO().getByFornecedor(id));
        } catch ( SQLException e ) {
            System.err.println( "Não foi possível criar a Fornecedor >> \n" + e );
            return null;
        }

        return forn;
    }

    @Override
    public void salvar(Object obj) {
        try {
            Fornecedor forn = (Fornecedor)obj;
            
            String sql = "INSERT INTO fornecedor (nome,descricao,cidade,endereco,bairro,numero) VALUES (?,?,?,?,?,?);".intern();

            Connection connection = ConexaoDAO.GET_CONNCETION();
            PreparedStatement statement = connection.prepareStatement( sql, Statement.RETURN_GENERATED_KEYS );

            statement.setString( 1, forn.getNome() );
            statement.setString( 2, forn.getDescricao() );
            statement.setString( 3, forn.getCidade() );
            statement.setString( 4, forn.getEndereco() );
            statement.setString( 5, forn.getBairro() );
            statement.setInt( 6, forn.getNumero() );
            
            statement.executeUpdate();
            ResultSet rs = statement.getGeneratedKeys();
            int idFornecedor = -1;
            
            if ( rs.next() ) {
                idFornecedor = rs.getInt( 1 );
            }
            
            if ( idFornecedor <= 0 ){
                return;
            }
            
            for (Email email : forn.getEmails()) {
                email.setFornecedorID(idFornecedor);
                getEmailDAO().salvar(email);
            }
            
            for (Telefone telefone : forn.getTelefones()) {
                telefone.setFornecedorID(idFornecedor);
                getTelefoneDAO().salvar(telefone);
            }

        } catch ( SQLException e ) {
            System.err.println( "Não foi possível inserir fornecedor no banco >> \n" + e );
        } catch ( ClassCastException ex ) {
            System.err.println( "Erro no cast >> \n" + ex );
        } finally {
            try { ConexaoDAO.GET_CONNCETION().close(); } catch (SQLException ex) {}
        }
    }

    @Override
    public void editar(Object obj) {
        try {
            Fornecedor forn = (Fornecedor)obj;
            
            String sql = "UPDATE fornecedor SET nome=?,descricao=?,cidade=?,endereco=?,bairro=?,numero=? WHERE id=?".intern();
            
            Connection connection = ConexaoDAO.GET_CONNCETION();
            PreparedStatement statement = connection.prepareStatement( sql );

            statement.setString( 1, forn.getNome() );
            statement.setString( 2, forn.getDescricao() );
            statement.setString( 3, forn.getCidade() );
            statement.setString( 4, forn.getEndereco() );
            statement.setString( 5, forn.getBairro() );
            statement.setInt( 6, forn.getNumero() );
            
            final int idFornecedor = forn.getID();
            getEmailDAO().apagarByFornecedor(idFornecedor);
            getTelefoneDAO().apagarByFornecedor(idFornecedor);
            
            for (Email email : forn.getEmails()) {
                email.setFornecedorID(idFornecedor);
                getEmailDAO().salvar(email);
            }
            
            for (Telefone telefone : forn.getTelefones()) {
                telefone.setFornecedorID(idFornecedor);
                getTelefoneDAO().salvar(telefone);
            }

            statement.executeUpdate();
        } catch ( SQLException e ) {
            System.err.println( "Não foi possível editar fornecedor no banco >> \n" + e );
        } catch ( ClassCastException ex ) {
            System.err.println( "Erro no cast >> \n" + ex );
        } finally {
            try { ConexaoDAO.GET_CONNCETION().close(); } catch (SQLException ex) {}
        }
    }

    @Override
    public void apagar(int id) {
        getEmailDAO().apagarByFornecedor(id);
        getTelefoneDAO().apagarByFornecedor(id);
        
        try {
            String sql = "DELETE FROM fornecedor WHERE id = ?;".intern();

            Connection connection = ConexaoDAO.GET_CONNCETION();
            PreparedStatement statement = connection.prepareStatement( sql, Statement.RETURN_GENERATED_KEYS );

            statement.setInt( 1, id );

            statement.executeUpdate();
        } catch ( SQLException e ) {
            System.err.println( "Não foi possível apagar fornecedor no banco >> \n" + e );
        } finally {
            try { ConexaoDAO.GET_CONNCETION().close(); } catch (SQLException ex) {}
        }
    }

    @Override
    public ArrayList<Object> listar() {
        ArrayList<Object> objs = new ArrayList();
        
        try {
            Connection connection = ConexaoDAO.GET_CONNCETION();
            Statement statement = connection.createStatement();

            String sql = "SELECT * FROM fornecedor ORDER BY id asc";

            ResultSet resultSet = statement.executeQuery( sql );

            while ( resultSet.next() ) {
                Fornecedor forn = (Fornecedor)criar( resultSet );

                if ( null == forn ) {
                    continue;
                }
                
                objs.add(forn);
            }
        } catch ( SQLException e ) {
            System.err.println( "Não foi possível obter os fornecedores a partir do banco >> \n" + e );
            return null;
        } finally {
            try { ConexaoDAO.GET_CONNCETION().close(); } catch (SQLException ex) {}
        }

        return objs;
    }

    @Override
    public Object getByID(int id) {
        try {
            Connection connection = ConexaoDAO.GET_CONNCETION();
            Statement statement = connection.createStatement();

            String sql = "SELECT * FROM fornecedor WHERE id = " + id;

            ResultSet resultSet = statement.executeQuery( sql );

            if ( !resultSet.last() ){
                return null;
            }
            
            Fornecedor forn = (Fornecedor)criar( resultSet );

            if ( null == forn ) {
                return null;
            }

            return forn;
        } catch ( SQLException e ) {
            System.err.println( "Não foi possível obter o fornecedor a partir do banco >> \n" + e );
        } finally {
            try { ConexaoDAO.GET_CONNCETION().close(); } catch (SQLException ex) {}
        }
        
        return null;
    }
    
}
