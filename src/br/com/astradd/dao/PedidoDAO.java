package br.com.astradd.dao;

import java.sql.*;
import br.com.astradd.dto.PedidoDTO;
import br.com.astradd.dto.BiomedicoDTO;
import br.com.astradd.dto.Tipo_do_exameDTO;
import br.com.astradd.dto.FuncionarioDTO;
import br.com.astradd.dto.PacienteDTO;
import br.com.astradd.dto.LoginDTO;
public class PedidoDAO {

    public PedidoDAO() {
    }

    private ResultSet rs = null;
    private Statement stmt = null;

    public boolean inserirPedido(PedidoDTO pedidoDTO, Tipo_do_exameDTO tipo_do_exameDTO, PacienteDTO pacienteDTO, LoginDTO loginDTO) {
        try {
            ConexaoDAO.ConectDB();
            stmt = ConexaoDAO.con.createStatement();
            
            String comando = "Insert into pedido (data_ped,cod_tp_ex,cod_pac,obs_ped,conf_receb_ped,medico,laudo "
                    + ") values ( "
                    + "'" + pedidoDTO.getData_ped() + "', "
                    + tipo_do_exameDTO.getCod_tp_ex() + ", "
                    + pedidoDTO.getCod_pac() + ", "
                    +"'"+ pedidoDTO.getObs_ped() + "',"
                    + "0"+", "
                    + loginDTO.p_login+","
                    + "'0')";
            
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
    public boolean inserirPedidoLaudo(PedidoDTO pedidoDTO, LoginDTO loginDTO) {
        try {
            ConexaoDAO.ConectDB();
            stmt = ConexaoDAO.con.createStatement();
            
            String comando = "update pedido set laudo= '"+pedidoDTO.getLaudo()  + "',cod_fun = "+loginDTO.p_login 
                    + " where cod_ped = "+pedidoDTO.getCod_ped();
            
         
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
    public boolean assocPedido(PedidoDTO pedidoDTO, Tipo_do_exameDTO tipo_do_exameDTO, PacienteDTO pacienteDTO, LoginDTO loginDTO,FuncionarioDTO funcionarioDTO) {
        try {
            ConexaoDAO.ConectDB();
            stmt = ConexaoDAO.con.createStatement();
            
            String comando = "update pedido set medico = "+funcionarioDTO.getCod_fun()+
                    " where cod_ped= "+pedidoDTO.getCod_ped();
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
    
    public boolean responderPedido(PedidoDTO pedidoDTO) {
        try {
            ConexaoDAO.ConectDB();
            stmt = ConexaoDAO.con.createStatement();
            
            String comando = "update pedido set laudo =  '"+pedidoDTO.getLaudo()
                    + "' where cod_ped = "+pedidoDTO.getCod_ped();
            stmt.execute(comando.toUpperCase());
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
    public boolean aceitarPedido(PedidoDTO pedidoDTO, LoginDTO loginDTO) {
        try {
            
            ConexaoDAO.ConectDB();
            stmt = ConexaoDAO.con.createStatement();
            String comando = "update pedido set conf_receb_ped=1, cod_fun = "+loginDTO.p_login 
                    + " where cod_ped = "+pedidoDTO.getCod_ped();
            stmt.execute(comando);
            ConexaoDAO.con.commit();
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        } finally {

            ConexaoDAO.CloseDB();
        }
    }
    
    public ResultSet consultarPedidoAssoc(PedidoDTO pedidoDTO, Tipo_do_exameDTO tipo_do_exameDTO, PacienteDTO pacienteDTO, LoginDTO loginDTO) {
        try {
            ResultSet rs=null;
            ConexaoDAO.ConectDB();
            stmt = ConexaoDAO.con.createStatement();
            String comando = "SELECT * FROM pedido p inner join tipo_exame t on t.cod_tp_ex=p.cod_tp_ex "
                    + " inner join paciente pa on pa.cod_pac=p.cod_pac WHERE t.nome_ex LIKE '%"+tipo_do_exameDTO.getNome_ex()+" %'" ;
            rs = stmt.executeQuery(comando);
            
            
            return rs;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return rs;
        } finally {
            
            ConexaoDAO.CloseDB();
        }
    }
    
    public ResultSet consultarPedido(PedidoDTO pedidoDTO, Tipo_do_exameDTO tipo_do_exameDTO, PacienteDTO pacienteDTO, LoginDTO loginDTO) {
        try {
            ResultSet rs=null;
            ConexaoDAO.ConectDB();
            stmt = ConexaoDAO.con.createStatement();
            String comando = "SELECT * FROM pedido p inner join tipo_exame t on t.cod_tp_ex=p.cod_tp_ex "
                    + " inner join paciente pa on pa.cod_pac=p.cod_pac WHERE  p.cod_ped= "+pedidoDTO.getCod_ped();
            rs = stmt.executeQuery(comando);
            ConexaoDAO.con.commit();
            
            return rs;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return rs;
        } finally {

            ConexaoDAO.CloseDB();
        }
    }
    public ResultSet consultarPedidoTab(PedidoDTO pedidoDTO, Tipo_do_exameDTO tipo_do_exameDTO, PacienteDTO pacienteDTO, LoginDTO loginDTO) {
        try {
            ResultSet rs=null;
            ConexaoDAO.ConectDB();
            stmt = ConexaoDAO.con.createStatement();
            String comando = "SELECT * FROM pedido p inner join tipo_exame t on t.cod_tp_ex=p.cod_tp_ex "
                    + " inner join paciente pa on pa.cod_pac=p.cod_pac WHERE conf_receb_ped=0 and p.cod_fun = "+loginDTO.p_login;
            rs = stmt.executeQuery(comando);
            ConexaoDAO.con.commit();
            
            return rs;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return rs;
        } finally {

            ConexaoDAO.CloseDB();
        }
    }
    public ResultSet consultarPedidoLaudo(PedidoDTO pedidoDTO, Tipo_do_exameDTO tipo_do_exameDTO, PacienteDTO pacienteDTO, LoginDTO loginDTO) {
        try {
            ResultSet rs=null;
            ConexaoDAO.ConectDB();
            stmt = ConexaoDAO.con.createStatement();
            String comando = "SELECT * FROM pedido p inner join tipo_exame t on t.cod_tp_ex=p.cod_tp_ex "
                    + " inner join paciente pa on pa.cod_pac=p.cod_pac WHERE conf_receb_ped=1 and p.laudo <>'0' and p.medico = "+loginDTO.p_login +" order by p.cod_ped desc";
            rs = stmt.executeQuery(comando);
            ConexaoDAO.con.commit();
            
            return rs;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return rs;
        } finally {

            ConexaoDAO.CloseDB();
        }
    }
    
    public ResultSet consultarPedidoPendentes() {
        try {
            ResultSet rs=null;
            ConexaoDAO.ConectDB();
            stmt = ConexaoDAO.con.createStatement();
            String comando = "SELECT * FROM pedido p inner join tipo_exame t on t.cod_tp_ex=p.cod_tp_ex "
            + " inner join paciente pa on p.cod_pac=pa.cod_pac inner join funcionario f "
            + " on f.cod_fun=p.medico where p.conf_receb_ped = 0";
            rs = stmt.executeQuery(comando);
            
            return rs;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return rs;
        } finally {

            ConexaoDAO.CloseDB();
        }
    }
    
    public ResultSet consultarPedidoResp(PedidoDTO pedidoDTO, LoginDTO loginDTO ) {
        try {
             ResultSet rs=null;          
            ConexaoDAO.ConectDB();
            stmt = ConexaoDAO.con.createStatement();
            String comando = "SELECT * FROM pedido p inner join tipo_exame t on t.cod_tp_ex=p.cod_tp_ex "
            + " inner join paciente pa on p.cod_pac=pa.cod_pac inner join funcionario f "
            + " on f.cod_fun=p.cod_fun where p.conf_receb_ped = 1 and p.laudo='0' and  f.cod_fun= "+ loginDTO.p_login;
            rs = stmt.executeQuery(comando);
            ConexaoDAO.con.commit();
           
            return rs;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return rs;
        } finally {

            ConexaoDAO.CloseDB();
        }
    }

}
