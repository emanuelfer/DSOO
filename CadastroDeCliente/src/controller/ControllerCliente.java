package controller;

import dao.ClienteDAO;
import conexão.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import model.ClienteBEAN;

public class ControllerCliente {
     
    private Connection conexao;
    
    public ControllerCliente(){
        
    }
    
    public String insere(ClienteBEAN cliente){
        if(cliente.getNome().equals("") || cliente.getCpf().equals("") || cliente.getNomeMae().equals("") || cliente.getNascimento().equals("")){
            return "Preencha todos os campos!";
        }else{
            ClienteDAO cd = new ClienteDAO();
            if(cd.insere(cliente)){
                return "Inserção realizada com sucesso!";
            }
            else{
                return "Erro ao realizar inserção";
            }
        }
    }
    
    
    public static boolean verificaNascimento(String nascimento){ 
        return true;
    }
 
}
