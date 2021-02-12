package br.com.astradd.dao;

import java.sql.*;
import br.com.astradd.dto.LoginDTO;

public class LoginDAO {

    private ResultSet rs = null;
    private Statement stmt = null;

  public boolean logar(LoginDTO loginDTO) {
        try {
           ConexaoDAO.ConectDB();
            stmt = ConexaoDAO.con.createStatement();
            String comando = "Select * from login where nome_login = '"+loginDTO.getNome_login()+"' and senha= '"+loginDTO.getSenha()+"'";
            rs = null;
            rs = stmt.executeQuery(comando);
            rs.next();
            loginDTO.p_login = rs.getInt("cod_fun");
            loginDTO.control_user = rs.getString("tp_usuario");
            loginDTO.setCod_fun( rs.getInt("cod_fun"));
            
            return true;
                
                           
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
        finally{
            ConexaoDAO.CloseDB();
        }
    }
//public ResultSet verificarLogin(LoginDTO loginDTO) {
//        try {
//            rs= null;
//            ConexaoDAO.ConectDB();
//            stmt = ConexaoDAO.con.createStatement();
//
//            String comando = "select * from login where nome_login= '" + loginDTO.getNome_login() + "' and "
//                    + "senha =  '"+loginDTO.getSenha()+"'";
//            rs = stmt.executeQuery(comando);
//            ConexaoDAO.con.commit();
//            stmt.close();
//            rs.next();
//            return rs;
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//            return rs;
//        } finally {
//
//            ConexaoDAO.CloseDB();
//        }
//    }
//    
}
    



