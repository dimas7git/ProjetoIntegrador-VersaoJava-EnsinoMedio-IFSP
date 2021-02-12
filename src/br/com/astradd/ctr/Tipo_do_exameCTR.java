package br.com.astradd.ctr;
import br.com.astradd.dto.Tipo_do_exameDTO;
import br.com.astradd.dao.ConexaoDAO;
import br.com.astradd.dao.Tipo_do_exameDAO;
import java.sql.*;
public class Tipo_do_exameCTR {
 
Tipo_do_exameDAO tipo_do_exameDAO = new Tipo_do_exameDAO();

    public Tipo_do_exameCTR() {
    }
    
    public String inserirTipo_do_exame(Tipo_do_exameDTO tipo_do_exameDTO) {
        try {
            
            if (tipo_do_exameDAO.inserirTipo_do_exame(tipo_do_exameDTO)) {
                return "Exame cadastrado com sucesso!";
            } else {
                return "Exame não cadastrado!";
            }
        } 
        catch (Exception e) {
            System.out.println(e.getMessage());
                return "Exame não cadastrado!";
        }
    }    
    
    public String alterarTipo_do_exame(Tipo_do_exameDTO tipo_do_exameDTO) {
        try {
           
            if (tipo_do_exameDAO.alterarTipo_do_exame(tipo_do_exameDTO)) {
                return "Exame alterado com sucesso!";
            } else {
                return "Exame não alterado!";
            }
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
                return "Exame não alterado!";
        }
    } 
    
    public ResultSet consultarTipo_do_exame(Tipo_do_exameDTO tipo_do_exameDTO) {
        
        ResultSet rs = null;

       
        rs = tipo_do_exameDAO.consultarTipo_do_exame(tipo_do_exameDTO);

        return rs;
    }
    
    public ResultSet consultarTipo_do_exameCampos(Tipo_do_exameDTO tipo_do_exameDTO) {
        
        ResultSet rs = null;

       
        rs = tipo_do_exameDAO.consultarTipo_do_exameCampos(tipo_do_exameDTO);

        return rs;
    }
    
    public String excluirTipo_do_exame(Tipo_do_exameDTO tipo_do_exameDTO) {
        try {
            
            if (tipo_do_exameDAO.excluirTipo_do_exame(tipo_do_exameDTO)) {
                return "Exame excluido com sucesso!";
            } else {
                return "Exame não excluido!";
            }
        } 
        catch (Exception e) {
            System.out.println(e.getMessage());
                return "Exame não excluido!";
        }
    } 
}
