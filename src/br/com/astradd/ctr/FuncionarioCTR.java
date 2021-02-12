package br.com.astradd.ctr;
import java.sql.*;
import br.com.astradd.dto.FuncionarioDTO;
import br.com.astradd.dto.BiomedicoDTO;
import br.com.astradd.dto.MedicoDTO;
import br.com.astradd.dto.LoginDTO;
import br.com.astradd.dao.FuncionarioDAO;
import br.com.astradd.dao.ConexaoDAO;
public class FuncionarioCTR {
   FuncionarioDAO funcionarioDAO = new FuncionarioDAO();

    public FuncionarioCTR() {
    }
    
    public String inserirFuncionario(MedicoDTO medicoDTO, BiomedicoDTO biomedicoDTO, FuncionarioDTO funcionarioDTO, LoginDTO loginDTO) {
        try {
           
            if (funcionarioDAO.inserirFuncionario(medicoDTO,biomedicoDTO, funcionarioDTO, loginDTO)) {
                return "Funcionario cadastrado com sucesso!";
            } else {
                return "Funcionario não cadastrado!";
            }
        } 
        catch (Exception e) {
            System.out.println(e.getMessage());
            return "Funcionario não cadastrado!";
        }
    }
    public String alterarFuncionario(FuncionarioDTO funcionarioDTO, MedicoDTO medicoDTO, BiomedicoDTO biomedicoDTO, LoginDTO loginDTO) {
        try {
            
            if (funcionarioDAO.alterarFuncionario(funcionarioDTO,medicoDTO, biomedicoDTO, loginDTO)) {
                return "Funcionario alterado!";
            } else {
                return "Funcionario não alterado!";
            }
        } 
        catch (Exception e) {
            System.out.println(e.getMessage());
            return "Funcionario não alterado!";
        }
    }
    
    public String excluirFuncionario(FuncionarioDTO funcionarioDTO) {
        try {
            
            if (funcionarioDAO.excluirFuncionario(funcionarioDTO)) {
                return "Funcionario excluido!";
            } else {
                return "Funcionario não excluido!";
            }
        } 
        catch (Exception e) {
            System.out.println(e.getMessage());
            return "Funcionario não excluido!";
        }
    }
    public ResultSet consultarFuncionario(FuncionarioDTO funcionarioDTO, MedicoDTO medicoDTO,BiomedicoDTO biomedicoDTO,  LoginDTO loginDTO) {
        
        ResultSet rs = null;

       
        rs = funcionarioDAO.consultarFuncionario(funcionarioDTO,medicoDTO,biomedicoDTO,loginDTO);

        return rs;
    }
    
    public ResultSet consultarFuncionarioTab(FuncionarioDTO funcionarioDTO, MedicoDTO medicoDTO,BiomedicoDTO biomedicoDTO,  LoginDTO loginDTO) {
        
        ResultSet rs = null;

       
        rs = funcionarioDAO.consultarFuncionarioTab(funcionarioDTO,medicoDTO,biomedicoDTO,loginDTO);

        return rs;
    }
    
    public ResultSet consultarFuncionarioCampoMedico(FuncionarioDTO funcionarioDTO, MedicoDTO medicoDTO,  LoginDTO loginDTO) {
        
        ResultSet rs = null;

       
        rs = funcionarioDAO.consultarFuncionarioCampoMedico(funcionarioDTO,medicoDTO,loginDTO);

        return rs;
    }
    public ResultSet consultarFuncionarioMedicoTab(FuncionarioDTO funcionarioDTO, MedicoDTO medicoDTO,  LoginDTO loginDTO) {
        
        ResultSet rs = null;

       
        rs = funcionarioDAO.consultarFuncionarioMedicoTab(funcionarioDTO,medicoDTO,loginDTO);

        return rs;
    }
}

