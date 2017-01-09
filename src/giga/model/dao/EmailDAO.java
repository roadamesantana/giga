package giga.model.dao;

import giga.model.Email;
import giga.model.Fornecedor;
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
public class EmailDAO implements CrudInterface{
    @Override
    public Object criar(ResultSet rs) {
        Email email = new Email();

        try {
            email.setID( rs.getInt( "id" ) );
            email.setEmail( rs.getString( "email" ) );
            email.setReferencia( rs.getString( "referencia" ) );
            email.setFornecedorID( rs.getInt( "Fornecedor_id" ) );
        } catch ( SQLException e ) {
            System.err.println( "Não foi possível criar Email >> \n" + e );
            return null;
        }

        return email;
    }
    
    @Override
    public void salvar(Object obj) {
        try {
            Email email = (Email)obj;
            
            String sql = "INSERT INTO email (email,referencia,Fornecedor_id) VALUES (?,?,?);".intern();

            Connection connection = ConexaoDAO.GET_CONNCETION();
            PreparedStatement statement = connection.prepareStatement( sql, Statement.RETURN_GENERATED_KEYS );

            statement.setString( 1, email.getEmail());
            statement.setString( 2, email.getReferencia() );
            statement.setInt( 3, email.getFornecedorID() );

            statement.executeUpdate();
        } catch ( SQLException e ) {
            System.err.println( "Não foi possível inserir email no banco >> \n" + e );
        } catch ( ClassCastException ex ) {
            System.err.println( "Erro no cast >> \n" + ex );
        } finally {
            try { ConexaoDAO.GET_CONNCETION().close(); } catch (SQLException ex) {}
        }
    }

    @Override
    public void editar(Object obj) {
        try {
            Email email = (Email)obj;
            
            String sql = "UPDATE email SET email = ?, referencia = ?, Fornecedor_id = ? WHERE id = ?;".intern();

            Connection connection = ConexaoDAO.GET_CONNCETION();
            PreparedStatement statement = connection.prepareStatement( sql, Statement.RETURN_GENERATED_KEYS );

            statement.setString( 1, email.getEmail());
            statement.setString( 2, email.getReferencia() );
            statement.setInt( 3, email.getFornecedorID() );
            statement.setInt( 4, email.getID() );

            statement.executeUpdate();
        } catch ( SQLException e ) {
            System.err.println( "Não foi possível editar email no banco >> \n" + e );
        } catch ( ClassCastException ex ) {
            System.err.println( "Erro no cast >> \n" + ex );
        } finally {
            try { ConexaoDAO.GET_CONNCETION().close(); } catch (SQLException ex) {}
        }
    }

    @Override
    public void apagar(int id) {
        try {
            String sql = "DELETE FROM email WHERE id = ?;".intern();

            Connection connection = ConexaoDAO.GET_CONNCETION();
            PreparedStatement statement = connection.prepareStatement( sql, Statement.RETURN_GENERATED_KEYS );

            statement.setInt( 1, id );

            statement.executeUpdate();
        } catch ( SQLException e ) {
            System.err.println( "Não foi possível apagar email no banco >> \n" + e );
        } finally {
            try { ConexaoDAO.GET_CONNCETION().close(); } catch (SQLException ex) {}
        }
    }

    public ArrayList<Object> listar() {
        ArrayList<Object> objs = new ArrayList();
        
        try {
            Connection connection = ConexaoDAO.GET_CONNCETION();
            Statement statement = connection.createStatement();

            String sql = "SELECT * FROM email ORDER BY id asc";

            ResultSet resultSet = statement.executeQuery( sql );

            while ( resultSet.next() ) {
                Email transp = (Email)criar( resultSet );

                if ( null == transp ) {
                    continue;
                }
                
                objs.add(transp);
            }
        } catch ( SQLException e ) {
            System.err.println( "Não foi possível obter os emails a partir do banco >> \n" + e );
            return null;
        } finally {
            try { ConexaoDAO.GET_CONNCETION().close(); } catch (SQLException ex) {}
        }

        return objs;
    }

    public Object getByID(int id) {
        try {
            Connection connection = ConexaoDAO.GET_CONNCETION();
            Statement statement = connection.createStatement();

            String sql = "SELECT * FROM email WHERE id = " + id;

            ResultSet resultSet = statement.executeQuery( sql );

            if ( !resultSet.last() ){
                return null;
            }
            
            Email transp = (Email)criar( resultSet );

            if ( null == transp ) {
                return null;
            }

            return transp;
        } catch ( SQLException e ) {
            System.err.println( "Não foi possível obter o email a partir do banco >> \n" + e );
        } finally {
            try { ConexaoDAO.GET_CONNCETION().close(); } catch (SQLException ex) {}
        }
        
        return null;
    }

    public ArrayList<Email> getByFornecedor(int idFornecedor){
        ArrayList<Email> emails = new ArrayList();
        
        try {
            Connection connection = ConexaoDAO.GET_CONNCETION();
            Statement statement = connection.createStatement();

            String sql = "SELECT * FROM email WHERE Fornecedor_id = " + idFornecedor;

            ResultSet resultSet = statement.executeQuery( sql );

            while ( resultSet.next() ) {
                Email email = (Email)criar( resultSet );

                if ( null == email ) {
                    continue;
                }
                
                emails.add(email);
            }
            
            return emails;
        } catch ( SQLException e ) {
            System.err.println( "Não foi possível obter os emails a partir do banco >> \n" + e );
            return null;
        }
    }
    
    public void apagarByFornecedor(int idFornecedor){
        try {
            String sql = "DELETE FROM email WHERE Fornecedor_id = ?;".intern();

            Connection connection = ConexaoDAO.GET_CONNCETION();
            PreparedStatement statement = connection.prepareStatement( sql, Statement.RETURN_GENERATED_KEYS );

            statement.setInt( 1, idFornecedor );

            statement.executeUpdate();
        } catch ( SQLException e ) {
            System.err.println( "Não foi possível apagar email no banco >> \n" + e );
        } finally {
            try { ConexaoDAO.GET_CONNCETION().close(); } catch (SQLException ex) {}
        }
    }
}
