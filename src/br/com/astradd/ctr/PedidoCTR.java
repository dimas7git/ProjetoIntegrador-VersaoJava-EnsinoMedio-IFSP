package br.com.astradd.ctr;
import java.sql.*;
import br.com.astradd.dto.PedidoDTO;
import br.com.astradd.dto.BiomedicoDTO;
import br.com.astradd.dto.Tipo_do_exameDTO;
import br.com.astradd.dto.PacienteDTO;
import br.com.astradd.dto.FuncionarioDTO;
import br.com.astradd.dao.ConexaoDAO;
import br.com.astradd.dao.PedidoDAO;
import br.com.astradd.dto.LoginDTO;
public class PedidoCTR {
   PedidoDAO pedidoDAO = new PedidoDAO();

    public PedidoCTR() {
    }
    
    public String inserirPedido(PedidoDTO pedidoDTO, Tipo_do_exameDTO tipo_do_exameDTO, PacienteDTO pacienteDTO, LoginDTO loginDTO) {
        try {
            
            if (pedidoDAO.inserirPedido(pedidoDTO,  tipo_do_exameDTO,  pacienteDTO,  loginDTO)) {
                
                return "Pedido feito com sucesso!";
            } else {
                return "Pedido não concluido!";
            }
            
        } 
        catch (Exception e) {
            System.out.println(e.getMessage());
            return "Pedido não alterado!";
        }
    }
    
    public String inserirPedidoLaudo(PedidoDTO pedidoDTO, LoginDTO loginDTO) {
        try {
            
            if (pedidoDAO.inserirPedidoLaudo(pedidoDTO,loginDTO)) {
                
                return "Laudo inserido com sucesso";
            } else {
                return "Laudo nao inserido ";
            }
            
        } 
        catch (Exception e) {
            System.out.println(e.getMessage());
                return "Laudo nao inserido ";
        }
    }
    
    public String aceitarPedido(PedidoDTO pedidoDTO, LoginDTO loginDTO) {
        try {
            
            if (pedidoDAO.aceitarPedido(pedidoDTO,loginDTO)) {
                
                return "Pedido aceito com sucesso";
            } else {
                return "pedido nao aceito ";
            }
            
        } 
        catch (Exception e) {
            System.out.println(e.getMessage());
                return "pedido nao aceito ";
        }
    }
    
    public String assocPedido(PedidoDTO pedidoDTO, Tipo_do_exameDTO tipo_do_exameDTO, PacienteDTO pacienteDTO, LoginDTO loginDTO, FuncionarioDTO funcionarioDTO) {
        try {
            
            if (pedidoDAO.assocPedido(pedidoDTO,  tipo_do_exameDTO,  pacienteDTO,  loginDTO, funcionarioDTO)) {
                   return "Pedido alterado com sucesso!";
            } else {
                return "Pedido não alterado!";
            }
        } 
            
         
        catch (Exception e) {
            System.out.println(e.getMessage());
            return "Pedido não concluido!";
        }
    }
    
    public String responderPedido(PedidoDTO pedidoDTO) {
        try {
          
            if (pedidoDAO.responderPedido(pedidoDTO)) {
                return "Pedido respondido com sucesso!";
            } else {
                return "Pedido não respondido!";
            }
        } 
        catch (Exception e) {
            System.out.println(e.getMessage());
                return "Pedido não respondido!";
        }
    }
    
    public ResultSet consultarPedidoAssoc(PedidoDTO pedidoDTO, Tipo_do_exameDTO tipo_do_exameDTO, PacienteDTO pacienteDTO, LoginDTO loginDTO) {
     
        ResultSet rs = null;

        
        rs = pedidoDAO.consultarPedidoAssoc( pedidoDTO,  tipo_do_exameDTO,  pacienteDTO,  loginDTO);

        return rs;
    }
    public ResultSet consultarPedido(PedidoDTO pedidoDTO, Tipo_do_exameDTO tipo_do_exameDTO, PacienteDTO pacienteDTO, LoginDTO loginDTO) {
     
        ResultSet rs = null;

        
        rs = pedidoDAO.consultarPedido( pedidoDTO,  tipo_do_exameDTO,  pacienteDTO,  loginDTO);

        return rs;
    }
    
    public ResultSet consultarPedidoTab(PedidoDTO pedidoDTO, Tipo_do_exameDTO tipo_do_exameDTO, PacienteDTO pacienteDTO, LoginDTO loginDTO) {
     
        ResultSet rs = null;

        
        rs = pedidoDAO.consultarPedidoTab( pedidoDTO,  tipo_do_exameDTO,  pacienteDTO, loginDTO);

        return rs;
    }
    public ResultSet consultarPedidoLaudo(PedidoDTO pedidoDTO, Tipo_do_exameDTO tipo_do_exameDTO, PacienteDTO pacienteDTO, LoginDTO loginDTO) {
     
        ResultSet rs = null;

        
        rs = pedidoDAO.consultarPedidoLaudo( pedidoDTO,  tipo_do_exameDTO,  pacienteDTO, loginDTO);

        return rs;
    }
    
    public ResultSet consultarPedidoPendentes() {
     
        ResultSet rs = null;

        
        rs = pedidoDAO.consultarPedidoPendentes( );

        return rs;
    }
    
    public ResultSet consultarPedidoResp(PedidoDTO pedidoDTO, LoginDTO loginDTO) {
       
        ResultSet rs = null;

        //ainda falta faser o DAO
        rs = pedidoDAO.consultarPedidoResp( pedidoDTO, loginDTO);

        return rs;
    }
}
