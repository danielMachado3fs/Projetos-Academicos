/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backend;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginBackend {
    
    public static ResultSet login(String email){
        ResultSet resultado = null;
    	Connection conexao = ConexaoBD.conectarBD();
        
        try{
        String sql = "SELECT * FROM tb_visitante WHERE at_email = ?;" ;
        PreparedStatement comando = conexao.prepareStatement( sql );
        comando.setString(1, email);

        resultado = comando.executeQuery();
        }
        
        catch (SQLException ex) {
            System.out.println("Erro ao consultar tabela!"+ex.toString());
    	}
    	return resultado;
    }
}
