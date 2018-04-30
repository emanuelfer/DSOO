package conexão;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    private Connection conexao;
    
    public ConnectionFactory() throws SQLException{
        this.conexao = DriverManager.getConnection("jdbc:mysql://localhost/cliente", "root", "");
    }
    
    public Connection getConexao(){
        return this.conexao;
    }
}
