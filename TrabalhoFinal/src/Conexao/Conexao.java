
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.derby.client.am.SqlException;


public class Conexao {
    static String url = "jdbc:derby://localhost:1527/dbaula";
    static String usuario = "root";
    static String senha = "root";
    static Connection con;
    
    public static Connection getConexao() throws SQLException {
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
            if (con == null) {
                con = (Connection) DriverManager.getConnection(url, usuario, senha);
            }
            return con;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            throw new SQLException(e.getMessage());
        } catch (InstantiationException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
