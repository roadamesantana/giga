package giga.model.dao;

import giga.model.Transportadora;
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
public class TransportadoraDAO implements CrudInterface{
    @Override
    public Object criar(ResultSet rs) {
        Transportadora transp = new Transportadora();

        try {
            transp.setID( rs.getInt( "id" ) );
            transp.setNome( rs.getString( "nome" ) );
        } catch ( SQLException e ) {
            System.err.println( "Não foi possível criar a Transportadora >> \n" + e );
            return null;
        }

        return transp;
    }

    @Override
    public void salvar(Object obj) {
        try {
            Transportadora transportadora = (Transportadora)obj;
            
            String sql = "INSERT INTO transportadora (nome) VALUES (?);".intern();

            Connection connection = ConexaoDAO.GET_CONNCETION();
            PreparedStatement statement = connection.prepareStatement( sql, Statement.RETURN_GENERATED_KEYS );

            statement.setString( 1, transportadora.getNome() );

            statement.executeUpdate();
        } catch ( SQLException e ) {
            System.err.println( "Não foi possível inserir transportadora no banco >> \n" + e );
        } catch ( ClassCastException ex ) {
            System.err.println( "Erro no cast >> \n" + ex );
        } finally {
            try { ConexaoDAO.GET_CONNCETION().close(); } catch (SQLException ex) {}
        }
    }

    @Override
    public void editar(Object obj) {
        try {
            Transportadora transportadora = (Transportadora)obj;
            
            String sql = "UPDATE transportadora SET nome = ? WHERE id = ?".intern();
            
            Connection connection = ConexaoDAO.GET_CONNCETION();
            PreparedStatement statement = connection.prepareStatement( sql );

            statement.setString( 1, transportadora.getNome() );
            statement.setInt(2, transportadora.getID() );

            statement.executeUpdate();
        } catch ( SQLException e ) {
            System.err.println( "Não foi possível editar Transportadora no banco >> \n" + e );
        } catch ( ClassCastException ex ) {
            System.err.println( "Erro no cast >> \n" + ex );
        } finally {
            try { ConexaoDAO.GET_CONNCETION().close(); } catch (SQLException ex) {}
        }
    }

    @Override
    public void apagar(int id) {
        try {
            String sql = "DELETE FROM transportadora WHERE id = ?;".intern();

            Connection connection = ConexaoDAO.GET_CONNCETION();
            PreparedStatement statement = connection.prepareStatement( sql, Statement.RETURN_GENERATED_KEYS );

            statement.setInt( 1, id );

            statement.executeUpdate();
        } catch ( SQLException e ) {
            System.err.println( "Não foi possível apagar transportadora no banco >> \n" + e );
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

            String sql = "SELECT * FROM transportadora ORDER BY id asc";

            ResultSet resultSet = statement.executeQuery( sql );

            while ( resultSet.next() ) {
                Transportadora transp = (Transportadora)criar( resultSet );

                if ( null == transp ) {
                    continue;
                }
                
                objs.add(transp);
            }
        } catch ( SQLException e ) {
            System.err.println( "Não foi possível obter as transportadoras a partir do banco >> \n" + e );
            return null;
        } finally {
            try { ConexaoDAO.GET_CONNCETION().close(); } catch (SQLException ex) {}
        }

        return objs;
    }

    @Override
    public Object getByID(int ID) {
        try {
            Connection connection = ConexaoDAO.GET_CONNCETION();
            Statement statement = connection.createStatement();

            String sql = "SELECT * FROM transportadora WHERE id = " + ID;

            ResultSet resultSet = statement.executeQuery( sql );

            if ( !resultSet.last() ){
                return null;
            }
            
            Transportadora transp = (Transportadora)criar( resultSet );

            if ( null == transp ) {
                return null;
            }

            return transp;
        } catch ( SQLException e ) {
            System.err.println( "Não foi possível obter a transportadora a partir do banco >> \n" + e );
        } finally {
            try { ConexaoDAO.GET_CONNCETION().close(); } catch (SQLException ex) {}
        }
        
        return null;
    }

}
