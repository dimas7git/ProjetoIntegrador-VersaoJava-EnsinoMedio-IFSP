package br.com.astradd.dao;

import java.sql.*;
import br.com.astradd.dto.PacienteDTO;

public class PacienteDAO {

    public PacienteDAO() {
    }
    private ResultSet rs = null;
    private Statement stmt = null;

    public boolean inserirPaciente(PacienteDTO pacienteDTO) {
        try {
            ConexaoDAO.ConectDB();
            stmt = ConexaoDAO.con.createStatement();
          
            String comando = "Insert into paciente (nome_p) values ("
                 + "'" + pacienteDTO.getNome_p() +  "')";
                        stmt.execute(comando);
            ConexaoDAO.con.commit();
            stmt.close();
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        } finally {

            ConexaoDAO.CloseDB();
        }
    }
    
    public boolean alterarPaciente(PacienteDTO pacienteDTO) {
        
        try {
            ConexaoDAO.ConectDB();
            stmt = ConexaoDAO.con.createStatement();
            
            String comando = "Update paciente set "
                    + "nome_p = '" + pacienteDTO.getNome_p() + "' "
                    + "where cod_pac= " + pacienteDTO.getCod_pac();

            stmt.execute(comando);
            ConexaoDAO.con.commit();
          
            stmt.close();
           
            return true;
        } 
        catch (Exception e) {
            //System.out.println(e.getMessage());
            return false;
        } 
        finally {

            ConexaoDAO.CloseDB();
        }
    }

    public ResultSet consultarPacienteCampos(PacienteDTO pacienteDTO) {
        try {
            ConexaoDAO.ConectDB();
          Statement  stmt = ConexaoDAO.con.createStatement();
            String comando = "";
            comando = "SELECT * FROM paciente where cod_pac= "+ pacienteDTO.getCod_pac();            
            rs = stmt.executeQuery(comando);
           // rs.next();
            return rs;
        } 
        catch (Exception e) {
            System.out.println(e.getMessage());
            return rs;
        }
    }
  
    public ResultSet consultarPaciente(PacienteDTO pacienteDTO) {
        try {
            ConexaoDAO.ConectDB();
          Statement  stmt = ConexaoDAO.con.createStatement();
            String comando = "";
            comando = "SELECT * FROM paciente ;";            
            rs = stmt.executeQuery(comando);
           //rs.next();
            return rs;
        } 
        catch (Exception e) {
            System.out.println(e.getMessage());
            return rs;
        }
    }
 
   
}
