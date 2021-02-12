package br.com.astradd.ctr;
import java.sql.*;
import br.com.astradd.dto.LoginDTO;
import br.com.astradd.dao.ConexaoDAO;
import br.com.astradd.dao.LoginDAO;
import br.com.astradd.view.Tela_PrincipalVIEW;

public class LoginCTR {
       LoginDAO loginDAO = new LoginDAO();

    public LoginCTR() {
    }
    
     public void logar(LoginDTO loginDTO) {
        try {
          if(loginDAO.logar(loginDTO)){
               Tela_PrincipalVIEW tela_PrincipalVIEW = new Tela_PrincipalVIEW();
               tela_PrincipalVIEW.setVisible(true);
          }
            
        } 
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
