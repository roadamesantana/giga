package giga.model.dao.conf;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author rasantana
 */
public class ConexaoDAO {
    private static final String FOR_NAME = "com.mysql.jdbc.Driver".intern();
    
    private static final String NOME_SERVIDOR = "localhost".intern();;;
    
    private static final String PORTA = "3306".intern();
    private static final String NOME_BANCO = "giga".intern();
    private static final String URL = "jdbc:mysql://".intern() + NOME_SERVIDOR + ":".intern() + PORTA + "/".intern() + NOME_BANCO;
    private static final String USERNAME = "root".intern();
    private static final String PASSWORD = "root".intern();
    
    private static Connection conn = null;
    
    private ConexaoDAO() {    
        try {
            Class.forName( FOR_NAME );
            conn = DriverManager.getConnection( URL, USERNAME, PASSWORD );
            
            if (null == conn){
                System.err.println( "Não conectado ao banco" );
            }
            
            conn.setAutoCommit( true );
        } catch ( ClassNotFoundException e ) {
            System.err.println( "O driver expecificado nao foi encontrado >> \n" + e );
        } catch ( SQLException e ) {
            System.err.println( "Nao foi possivel conectar ao Banco de Dados >> \n" + e );
        }
    }
    
    public static Connection GET_CONNCETION() throws SQLException {
        if ( null == conn || conn.isClosed() ) {
            new ConexaoDAO();
        }
        
        return conn;
    }
}