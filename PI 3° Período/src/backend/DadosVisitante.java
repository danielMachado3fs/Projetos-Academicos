
package backend;

import backend.ConexaoBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class DadosVisitante {
    
    public static ResultSet obtemUsuario(String email) {
        ResultSet resultado=null;
        Connection conexao = ConexaoBD.conectarBD();
        try {
            String sql =  "SELECT * FROM tb_visitante WHERE = ?;";
            PreparedStatement comando = conexao.prepareStatement( sql );
            comando.setString(1, email);
            comando.executeQuery();
        }
        catch (SQLException ex) {
            System.out.println("Erro ao consultar na tabela de contatos.");
        } 
        return resultado;        
    }
    
    public static int desativarUsuario(String email) {
        int codErro = 0;
        Connection conexao = ConexaoBD.conectarBD();
        
        try {
            String sql = "UPDATE tb_visitante SET at_status = 'inativo' WHERE at_email=? ;" ; 
            PreparedStatement comando = conexao.prepareStatement( sql );
            comando.setString(1, email);
            comando.executeUpdate();
        }
        catch (SQLException ex) {
            System.out.println("Erro ao excluir contato: "+ex.toString());
            codErro = 1;
        } 
        return codErro;        
    }
    
    public static int ativarUsuario(String email) {
        int codErro = 0;
        Connection conexao = ConexaoBD.conectarBD();
        
        try {
            String sql = "UPDATE tb_visitante SET at_status = 'ativo' WHERE at_email=? ;" ; 
            PreparedStatement comando = conexao.prepareStatement( sql );
            comando.setString(1, email);
            comando.executeUpdate();
        }
        catch (SQLException ex) {
            System.out.println("Erro ao excluir contato: "+ex.toString());
            codErro = 1;
        } 
        return codErro;        
    }
    
    public static ResultSet obtemTodosCadastros() {
        ResultSet resultado = null;
        Connection conexao = ConexaoBD.conectarBD();
        try {
            Statement comando = conexao.createStatement();
            resultado = comando.executeQuery( "SELECT * FROM tb_visitante ORDER BY at_nome;" );
        }
        catch (SQLException ex) {
            System.out.println("Erro ao consultar na tabela de contatos.");
        } 
        return resultado;        
    }
}
