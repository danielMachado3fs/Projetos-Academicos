/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backend;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author DANIEL MACHADO
 */
public class EditarCadastro {
    
    public static int alterarUsuario(String nome, String email, String senha, String localizacao) {
        int codErro = 0;
        Connection conexao = ConexaoBD.conectarBD();
        
        try {
            String sql = "UPDATE tb_visitante SET at_nome=?, at_email=?, at_senha=?, at_localizacao=? WHERE at_email=? ;" ; 
            PreparedStatement comando = conexao.prepareStatement( sql );
            comando.setString(1, nome);
            comando.setString(2, email);
            comando.setString(3, senha);
            comando.setString(4, localizacao);
            comando.setString(5, email);
            comando.executeUpdate();
        }
        catch (SQLException ex) {
            System.out.println("Erro ao atualizar contato: "+ex.toString());
            codErro = 1;
        } 
        return codErro;
    }
    
}
