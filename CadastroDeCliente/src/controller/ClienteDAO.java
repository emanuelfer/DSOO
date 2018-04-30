package controller;

import conexão.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import model.ClienteBEAN;

public class ClienteDAO {
     
    private Connection conexao;
    
    public ClienteDAO(){
        
    }
    
    public void insere(ClienteBEAN cliente) throws SQLException{
        String sql = "insert into cliente (nome, nascimento, nomeMae, cpf)" + "values(?, ?, ?, ?)";
            ConnectionFactory fabrica = new ConnectionFactory();
            this.conexao = fabrica.getConexao();
            PreparedStatement stmt = this.conexao.prepareStatement(sql);
            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getNascimento());
            stmt.setString(3, cliente.getNomeMae());
            stmt.setString(4, cliente.getCpf());
            stmt.execute();
            this.conexao.close();
            stmt.close(); 
    }
    
    
    public static boolean verificaNascimento(String nascimento){ 
        return true;
    }
 
}
