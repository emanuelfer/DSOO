package dao;

import controller.*;
import conexão.ConnectionFactory;
import conexão.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import model.ClienteBEAN;

public class ClienteDAO {
     
    private Connection conexao;
    
    public ClienteDAO(){
        
    }
    
    public boolean insere(ClienteBEAN cliente){
        String sql = "insert into cliente (nome, nascimento, nomeMae, cpf) values(?, ?, ?, ?)";          
        try{
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
            
        }catch(SQLException e){
            return false;
        }
        return true;
    }
    
    
    public static boolean verificaNascimento(String nascimento){ 
        return true;
    }
 
}
