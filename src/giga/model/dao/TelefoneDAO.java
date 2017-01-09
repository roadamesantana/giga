package giga.model.dao;

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
public class TelefoneDAO implements CrudInterface{
    @Override
    public Object criar(ResultSet rs) {
        Telefone tel = new Telefone();

        try {
            tel.setID( rs.getInt( "id" ) );
            tel.setDdd(rs.getString( "ddd" ) );
            tel.setNumero(rs.getString( "numero" ) );
            tel.setReferencia( rs.getString( "referencia" ) );
            tel.setFornecedorID( rs.getInt( "Fornecedor_id" ) );
        } catch ( SQLException e ) {
            System.err.println( "Não foi possível criar Telefone >> \n" + e );
            return null;
        }

        return tel;
    }
    
    @Override
    public void salvar(Object obj) {
        try {
            Telefone tel = (Telefone)obj;
            
            String sql = "INSERT INTO telefone (ddd,numero,referencia,Fornecedor_id) VALUES (?,?,?,?);".intern();

            Connection connection = ConexaoDAO.GET_CONNCETION();
            PreparedStatement statement = connection.prepareStatement( sql, Statement.RETURN_GENERATED_KEYS );

            statement.setString( 1, tel.getDdd());
            statement.setString( 2, tel.getNumero());
            statement.setString( 3, tel.getReferencia() );
            statement.setInt( 4, tel.getFornecedorID() );

            statement.executeUpdate();
        } catch ( SQLException e ) {
            System.err.println( "Não foi possível inserir telefone no banco >> \n" + e );
        } catch ( ClassCastException ex ) {
            System.err.println( "Erro no cast >> \n" + ex );
        } finally {
            try { ConexaoDAO.GET_CONNCETION().close(); } catch (SQLException ex) {}
        }
    }

    @Override
    public void editar(Object obj) {
        try {
            Telefone tel = (Telefone)obj;
            
            String sql = "UPDATE telefone SET ddd = ?, numero = ?, referencia = ?, Fornecedor_id = ? WHERE id = ?;".intern();

            Connection connection = ConexaoDAO.GET_CONNCETION();
            PreparedStatement statement = connection.prepareStatement( sql, Statement.RETURN_GENERATED_KEYS );

            statement.setString( 1, tel.getDdd());
            statement.setString( 2, tel.getNumero());
            statement.setString( 3, tel.getReferencia() );
            statement.setInt( 4, tel.getFornecedorID() );
            statement.setInt( 5, tel.getID() );

            statement.executeUpdate();
        } catch ( SQLException e ) {
            System.err.println( "Não foi possível editar telefone no banco >> \n" + e );
        } catch ( ClassCastException ex ) {
            System.err.println( "Erro no cast >> \n" + ex );
        } finally {
            try { ConexaoDAO.GET_CONNCETION().close(); } catch (SQLException ex) {}
        }
    }

    @Override
    public void apagar(int id) {
        try {
            String sql = "DELETE FROM telefone WHERE id = ?;".intern();

            Connection connection = ConexaoDAO.GET_CONNCETION();
            PreparedStatement statement = connection.prepareStatement( sql, Statement.RETURN_GENERATED_KEYS );

            statement.setInt( 1, id );

            statement.executeUpdate();
        } catch ( SQLException e ) {
            System.err.println( "Não foi possível apagar telefone no banco >> \n" + e );
        } finally {
            try { ConexaoDAO.GET_CONNCETION().close(); } catch (SQLException ex) {}
        }
    }

    public ArrayList<Object> listar() {
        ArrayList<Object> objs = new ArrayList();
        
        try {
            Connection connection = ConexaoDAO.GET_CONNCETION();
            Statement statement = connection.createStatement();

            String sql = "SELECT * FROM telefone ORDER BY id asc";

            ResultSet resultSet = statement.executeQuery( sql );

            while ( resultSet.next() ) {
                Telefone tel = (Telefone)criar( resultSet );

                if ( null == tel ) {
                    continue;
                }
                
                objs.add(tel);
            }
        } catch ( SQLException e ) {
            System.err.println( "Não foi possível obter os telefone a partir do banco >> \n" + e );
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

            String sql = "SELECT * FROM telefone WHERE id = " + id;

            ResultSet resultSet = statement.executeQuery( sql );

            if ( !resultSet.last() ){
                return null;
            }
            
            Telefone tel = (Telefone)criar( resultSet );

            if ( null == tel ) {
                return null;
            }

            return tel;
        } catch ( SQLException e ) {
            System.err.println( "Não foi possível obter o telefone a partir do banco >> \n" + e );
        } finally {
            try { ConexaoDAO.GET_CONNCETION().close(); } catch (SQLException ex) {}
        }
        
        return null;
    }

    public ArrayList<Telefone> getByFornecedor(int idFornecedor){
        ArrayList<Telefone> tels = new ArrayList();
        
        try {
            Connection connection = ConexaoDAO.GET_CONNCETION();
            Statement statement = connection.createStatement();

            String sql = "SELECT * FROM telefone WHERE Fornecedor_id = " + idFornecedor;

            ResultSet resultSet = statement.executeQuery( sql );

            while ( resultSet.next() ) {
                Telefone tel = (Telefone)criar( resultSet );

                if ( null == tel ) {
                    continue;
                }
                
                tels.add(tel);
            }
            
            return tels;
        } catch ( SQLException e ) {
            System.err.println( "Não foi possível obter os telefones a partir do banco >> \n" + e );
            return null;
        }
    }
    
    public void apagarByFornecedor(int idFornecedor){
        try {
            String sql = "DELETE FROM telefone WHERE Fornecedor_id = ?;".intern();

            Connection connection = ConexaoDAO.GET_CONNCETION();
            PreparedStatement statement = connection.prepareStatement( sql, Statement.RETURN_GENERATED_KEYS );

            statement.setInt( 1, idFornecedor );

            statement.executeUpdate();
        } catch ( SQLException e ) {
            System.err.println( "Não foi possível apagar telefone no banco >> \n" + e );
        } finally {
            try { ConexaoDAO.GET_CONNCETION().close(); } catch (SQLException ex) {}
        }
    }
}
