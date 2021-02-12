package br.com.astradd.dao;

import br.com.astradd.dto.MedicoDTO;
import br.com.astradd.dto.BiomedicoDTO;
import br.com.astradd.dto.FuncionarioDTO;
import br.com.astradd.dto.LoginDTO;
import java.sql.*;

public class FuncionarioDAO {

    public FuncionarioDAO() {
    }

    ResultSet rs = null;
    private Statement stmt = null;
    private Statement stmt1 = null;
    LoginDAO loginDAO = new LoginDAO();

    public boolean inserirFuncionario(MedicoDTO medicoDTO, BiomedicoDTO biomedicoDTO, FuncionarioDTO funcionarioDTO, LoginDTO loginDTO) {

        String comando = "";
        try {
            ConexaoDAO.ConectDB();
            stmt = ConexaoDAO.con.createStatement();
            stmt1 = ConexaoDAO.con.createStatement();
            ResultSet rs = null;
            comando = "Insert into funcionario (nome_f,tel_f,crm,endereco,cep,rg,cpf,data_nasc,status) "
                    + " values ("
                    + "'" + funcionarioDTO.getNome_f() + "', "
                    + "'" + funcionarioDTO.getTel_f() + "', "
                    + "'" + funcionarioDTO.getCrm() + "', "
                    + "'" + funcionarioDTO.getEndereco() + "', "
                    + "'" + funcionarioDTO.getCep() + "', "
                    + "'" + funcionarioDTO.getRg() + "', "
                    + "'" + funcionarioDTO.getCpf() + "', "
                    + "'" + funcionarioDTO.getData_nasc() + "', "
                    + "1) ";
            
            stmt.execute(comando, Statement.RETURN_GENERATED_KEYS);
            rs = stmt.getGeneratedKeys();
            rs.next();

            //loginDAO.inserirLogin(loginDTO,rs);
            String comando1 = "insert into login(nome_login,senha,tp_usuario,cod_fun) values ( "
                    + "'" + loginDTO.getNome_login() + "', "
                    + "'" + loginDTO.getSenha() + "', "
                    + "'" + loginDTO.getTp_usuario() + "', "
                    + rs.getInt("cod_fun") + ")";
            stmt1.execute(comando1);
          
            if (loginDTO.getTp_usuario().equalsIgnoreCase("med")) {
                String comando2 = "insert into medico(especializacao_med,cod_fun) values ( "
                        + "'" + medicoDTO.getEspecializacao_med() + "', "
                        + rs.getInt("cod_fun") + ")";
                stmt1.execute(comando2);
                
            } else {
                String comando3 = "insert into biomedico(cargo_bio,cod_fun) values ( "
                        + "'" + biomedicoDTO.getCargo_bio() + "', "
                        + rs.getInt("cod_fun") + ")";
                stmt1.execute(comando3);
                
            }
            ConexaoDAO.con.commit();
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        } finally {

            ConexaoDAO.CloseDB();
        }
    }

    public boolean alterarFuncionario(FuncionarioDTO funcionarioDTO, MedicoDTO medicoDTO, BiomedicoDTO biomedicoDTO, LoginDTO loginDTO) {
        String comando = "";
        try {
            ConexaoDAO.ConectDB();
            stmt = ConexaoDAO.con.createStatement();

            comando = "Update funcionario set "
                    + "nome_f = '" + funcionarioDTO.getNome_f() + "', "
                    + "tel_f = '" + funcionarioDTO.getTel_f() + "', "
                    + "crm = '" + funcionarioDTO.getCrm() + "', "
                    + "endereco = '" + funcionarioDTO.getEndereco() + "', "
                    + "cep = '" + funcionarioDTO.getCep() + "', "
                    + "rg = '" + funcionarioDTO.getRg() + "', "
                    + "cpf = '" + funcionarioDTO.getCpf() + "', "
                    + "data_nasc = '" + funcionarioDTO.getData_nasc() + "' "
                    + "where cod_fun= " + funcionarioDTO.getCod_fun();

            stmt.execute(comando);
            
            String comando1 = "update login set nome_login = '" + loginDTO.getNome_login() + "',"
                    + "senha = '" + loginDTO.getSenha() + "',"
                    + "tp_usuario = '"+ loginDTO.getTp_usuario()+"' "
                    + "where cod_fun="+ funcionarioDTO.getCod_fun() + "";
            stmt.execute(comando1);

            if (loginDTO.getTp_usuario().equalsIgnoreCase("med")) {
                String comando2 = "update medico set especializacao_med = '" + medicoDTO.getEspecializacao_med() +
                        "' where cod_fun ="
                        + funcionarioDTO.getCod_fun() + "";
                
                stmt.execute(comando2);
            } else {
                String comando3 = "update biomedico set cargo_bio ='" + biomedicoDTO.getCargo_bio() +
                        "' where cod_fun="
                        + funcionarioDTO.getCod_fun() ;
                
                stmt.execute(comando3);
            }
            
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

    public boolean excluirFuncionario(FuncionarioDTO funcionarioDTO) {
        try {
            String comando = "", comando2 = "";

            ConexaoDAO.ConectDB();

            stmt = ConexaoDAO.con.createStatement();

            comando = "update funcionario set status = 0 where cod_fun = " + funcionarioDTO.getCod_fun();
            comando2 = "Delete from login where cod_fun = " + funcionarioDTO.getCod_fun();
            System.out.println(comando+comando2);
            stmt.execute(comando);
            stmt.execute(comando2);
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

    public String verificarTipo(FuncionarioDTO funcionarioDTO) {
        try {//pra especializacao ou cargo do cadastro fun

            ConexaoDAO.ConectDB();

            stmt = ConexaoDAO.con.createStatement();
            Statement stmt2 = ConexaoDAO.con.createStatement();
            ResultSet rs = null;
            String comando = "";
            String resp = "";

            comando = " select * from login where cod_fun=" + funcionarioDTO.getCod_fun();
            rs = stmt.executeQuery(comando);
            rs.next();
            if (rs.getString("tp_usuario").equalsIgnoreCase("med")) {
                resp = " inner join medico m on m.cod_fun=f.cod_fun";

            } else {
                resp = " inner join biomedico b on b.cod_fun=f.cod_fun";
            }

            return resp;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return "";
        }
    }

    public ResultSet consultarFuncionario(FuncionarioDTO funcionarioDTO, MedicoDTO medicoDTO, BiomedicoDTO biomedicoDTO, LoginDTO loginDTO) {
        try {

            ConexaoDAO.ConectDB();

            stmt = ConexaoDAO.con.createStatement();

            String comando = "";

            comando = "SELECT * FROM funcionario f "
                    + " inner join login l on f.cod_fun=l.cod_fun  " + verificarTipo(funcionarioDTO)
                    + " where f.cod_fun=" + funcionarioDTO.getCod_fun();

            rs = stmt.executeQuery(comando);

            return rs;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return rs;
        }
    }

    public ResultSet consultarFuncionarioTab(FuncionarioDTO funcionarioDTO, MedicoDTO medicoDTO, BiomedicoDTO biomedicoDTO, LoginDTO loginDTO) {
        try {

            ConexaoDAO.ConectDB();
            stmt = ConexaoDAO.con.createStatement();

            String comando = " SELECT * FROM funcionario f inner join login l on f.cod_fun=l.cod_fun ";
            rs = stmt.executeQuery(comando);
           

            //System.out.println(rs.getInt("cod_fun"));

            return rs;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return rs;
        }
    }

    public ResultSet consultarFuncionarioCampoMedico(FuncionarioDTO funcionarioDTO, MedicoDTO medicoDTO, LoginDTO loginDTO) {
        try {
            ResultSet rs;

            ConexaoDAO.ConectDB();

            stmt = ConexaoDAO.con.createStatement();

            String comando = "";

            comando = "SELECT * FROM funcionario f inner join login l on f.cod_fun=l.cod_fun "
                    + " WHERE f.cod_fun= " + funcionarioDTO.getCod_fun();

            rs = stmt.executeQuery(comando);

            return rs;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return rs;
        }
    }

    public ResultSet consultarFuncionarioMedicoTab(FuncionarioDTO funcionarioDTO, MedicoDTO medicoDTO, LoginDTO loginDTO) {
        try {
            ResultSet rs = null;

            ConexaoDAO.ConectDB();

            stmt = ConexaoDAO.con.createStatement();

            String comando = "";

            comando = "SELECT * FROM funcionario f inner join login l on f.cod_fun=l.cod_fun "
                    + " WHERE l.tp_usuario='med' ORDER BY f.cod_fun;";

            rs = stmt.executeQuery(comando);

            return rs;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return rs;
        }
    }

}
/**
 * public String inserirBiomedico(BiomedicoDTO biomedicoDTO) { String comando =
 * ""; try { comando = "Insert into Cliente (cargo_bio, cod_fun) values ( " +
 * "'" + biomedicoDTO.getCargo_bio() + "')" + biomedicoDTO.getCod_fun() + ")"; }
 * catch (Exception e) { System.out.println(e.getMessage()); } return comando; }
 *
 * public String inserirMedico(MedicoDTO medicoDTO) { String comando = ""; try {
 *
 * comando = "Insert into Medico (especializacao_med, cod_fun) values ( " + "'"
 * + medicoDTO.getEspecializacao_med() + "', " + "'" +
 * medicoDTO.getEspecializacao_med() + "', " + medicoDTO.getCod_fun() + ")";
 *
 * }
 * catch (Exception e) { System.out.println(e.getMessage()); } return comando; }
 * }
 *
 */
