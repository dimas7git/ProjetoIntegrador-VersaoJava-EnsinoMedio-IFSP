package br.com.astradd.dao;

import br.com.astradd.dto.BiomedicoDTO;
import br.com.astradd.dto.FuncionarioDTO;
import br.com.astradd.dto.LoginDTO;
import br.com.astradd.dto.MedicoDTO;
import br.com.astradd.dto.Tipo_do_exameDTO;
import java.sql.*;

public class Tipo_do_exameDAO {

    public Tipo_do_exameDAO() {
    }
    private ResultSet rs = null;
    private Statement stmt = null;

    public boolean inserirTipo_do_exame(Tipo_do_exameDTO tipo_do_exameDTO) {
        try {
            ConexaoDAO.ConectDB();
            stmt = ConexaoDAO.con.createStatement();
            String comando = "INSERT INTO tipo_exame (nome_ex,qtd_amostra,material_analise,status) values ( "
                    + "'" + tipo_do_exameDTO.getNome_ex() + "', "
                    + "'" + tipo_do_exameDTO.getQtd_amostra() + "', "
                    + "'" + tipo_do_exameDTO.getMaterial_analise() + "',"
                    + "1)";
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

    public boolean alterarTipo_do_exame(Tipo_do_exameDTO tipo_do_exameDTO) {
        String comando = "";
        try {
            ConexaoDAO.ConectDB();
            stmt = ConexaoDAO.con.createStatement();

            comando = "Update tipo_exame set "
                    + "nome_ex = '" + tipo_do_exameDTO.getNome_ex() + "', "
                    + "qtd_amostra = '" + tipo_do_exameDTO.getQtd_amostra() + "', "
                    + "material_analise = '" + tipo_do_exameDTO.getMaterial_analise() + "' "
                    + "where cod_tp_ex= " + tipo_do_exameDTO.getCod_tp_ex();

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

    public ResultSet consultarTipo_do_exame(Tipo_do_exameDTO tipo_do_exameDTO) {
        try {
            ConexaoDAO.ConectDB();

            stmt = ConexaoDAO.con.createStatement();

            String comando = "";

            //comando = "SELECT * FROM tipo_exame WHERE nome_ex LIKE '%" + tipo_do_exameDTO.getNome_ex() + "%' ORDER BY cod_tp_ex;";
            // comando = "SELECT * FROM tipo_exame WHERE cod_tp_ex =" + tipo_do_exameDTO.getCod_tp_ex() + ";";
            comando = "SELECT * FROM tipo_exame where status = 1";

            rs = stmt.executeQuery(comando);
            rs.next();
            //rs = null;
            return rs;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return rs;
        }
    }

    public ResultSet consultarTipo_do_exameCampos(Tipo_do_exameDTO tipo_do_exameDTO) {
        try {
            ConexaoDAO.ConectDB();

            stmt = ConexaoDAO.con.createStatement();

            String comando = "";
            comando = "SELECT * FROM tipo_exame where cod_tp_ex= " + tipo_do_exameDTO.getCod_tp_ex();
            rs = stmt.executeQuery(comando);
            return rs;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return rs;
        }
    }

    public boolean excluirTipo_do_exame(Tipo_do_exameDTO tipo_do_exameDTO) {
        try {
            String comando = "";
            ConexaoDAO.ConectDB();
            stmt = ConexaoDAO.con.createStatement();

            

            comando = "update tipo_exame set status=0 WHERE cod_tp_ex = " + tipo_do_exameDTO.getCod_tp_ex();
            //Fecha o statement
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
}
