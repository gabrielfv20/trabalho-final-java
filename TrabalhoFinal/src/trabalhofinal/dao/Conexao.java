package trabalhofinal.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
        
public class Conexao {
    
    static String url = "jdbc:derby://localhost:1527/cadastro";
    static String usuario = "usuario_cadastro";
    static String senha = "senha";
    static Connection con;

    public static Connection getConexao() throws SQLException {
        try {
            //O driver deve ser inbserido na pasta lib
            Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
            //DriverManager.registerDriver(new org.apache.derby.jdbc.EmbeddedDriver());
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

