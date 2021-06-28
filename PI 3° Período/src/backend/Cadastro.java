
package backend;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class Cadastro {
    
    public static String getSHA256(String input){

	String toReturn = null;
	try {
	    MessageDigest digest = MessageDigest.getInstance("SHA-256");
	    digest.reset();
	    digest.update(input.getBytes("utf8"));
	    toReturn = String.format("%064x", new BigInteger(1, digest.digest()));
	} catch (Exception e) {
	    e.printStackTrace();
	}
	
	return toReturn;
    }

    public static int cadastrar(String nome, String senha, String localizacao, String email){
            int codErro = 0;
    	Connection conexao = ConexaoBD.conectarBD();
 
    	
        try {   
            String sql = "INSERT INTO tb_visitante (at_nome, at_email, at_senha, at_localizacao, at_status) VALUES (?, ?, ?, ?, 'ativo');" ;
            PreparedStatement comando = conexao.prepareStatement( sql );
            comando.setString(1, nome);
            comando.setString(2, email);
            comando.setString(3, senha);
            comando.setString(4, localizacao);
            comando.executeUpdate();
    	}
        
    	catch (SQLException ex) {
            System.out.println("Erro ao cadastrar usuario: "+ex.toString());
            codErro = 1;
    	}
    	return codErro;
    }
    
    
       
    }
