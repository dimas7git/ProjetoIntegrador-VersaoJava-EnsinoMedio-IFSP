package br.com.astradd.ctr;
import java.sql.*;
import br.com.astradd.dto.PacienteDTO;
import br.com.astradd.dao.ConexaoDAO;
import br.com.astradd.dao.PacienteDAO;
public class PacienteCTR {
     
    PacienteDAO pacienteDAO = new PacienteDAO();

    public PacienteCTR() {
    }
    
    public String inserirPaciente(PacienteDTO pacienteDTO) {
        try {
            
            if (pacienteDAO.inserirPaciente(pacienteDTO)) {
                return "Paciente cadastrado com sucesso!";
            } else {
                return "Paciente não cadastrado!";
            }
        } 
        catch (Exception e) {
            System.out.println(e.getMessage());
                return "Paciente não cadastrado!";
        }
    }   
    
    public String alterarPaciente (PacienteDTO pacienteDTO) {
        try {
            
            if (pacienteDAO.alterarPaciente(pacienteDTO)) {
                return "Paciente alterado com sucesso!";
            } else {
                return "Paciente não alterado!";
            }
        } 
        catch (Exception e) {
            //System.out.println(e.getMessage());
                return "Paciente não alterado!";
        }
    }   
    
   public ResultSet consultarPaciente(PacienteDTO pacienteDTO) {
      ResultSet rs = null;

        rs = pacienteDAO.consultarPaciente(pacienteDTO);

        return rs;
    }
   
   public ResultSet consultarPacienteCampos(PacienteDTO pacienteDTO) {
      ResultSet rs = null;

        rs = pacienteDAO.consultarPacienteCampos(pacienteDTO);

        return rs;
    }
    
}
