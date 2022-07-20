/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import DTO.VendaDTO;


public class VendaDAO {
    Connection conn;
    PreparedStatement pstm;
    ResultSet rs;
    ArrayList<VendaDTO> lista = new ArrayList<>();
    
    public void novaVenda(VendaDTO objvendadto){
        String sql = "insert into venda (venda, valor, tipo_pag) values (?, ?, ?)";
        conn = new Conexao().conectaBD();
        
        try {
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, objvendadto.getVenda());
            pstm.setFloat(2, objvendadto.getValor());
            pstm.setString(3, objvendadto.getTipoPag());
            
            pstm.execute();
            pstm.close();
            
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "VendaDAO novaVenda "+erro);
        }
    }
    public ArrayList<VendaDTO> pesquisaVenda(){
        String sql = "select * from venda";
        conn = new Conexao().conectaBD();
        
        try{
            pstm = conn.prepareStatement(sql);
            rs = pstm.executeQuery();
        
            while(rs.next()){
                VendaDTO objvendadto = new VendaDTO();
                objvendadto.setId(rs.getInt("id"));
                objvendadto.setDataHora(rs.getString("data_hora"));
                objvendadto.setVenda(rs.getString("venda"));
                objvendadto.setValor(rs.getFloat("valor"));
                objvendadto.setTipoPag(rs.getString("tipo_pag"));
                
                lista.add(objvendadto);
            }
        }catch(SQLException erro){ 
            JOptionPane.showMessageDialog(null, "VendaDAO Pesquisar "+ erro);
        }
        return lista;
  
    }
    
    
    public void excluirVenda(VendaDTO objvendadto){
        String sql = "delete from venda where id = ?";
        conn = new Conexao().conectaBD();
        
        try {
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, objvendadto.getId());
            
            pstm.execute();
            pstm.close();
            
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "VendaDAO Excluir " + erro);
        }
    }
    
    
    public void alterarVenda(VendaDTO objvendadto){
        String sql = "update venda set venda = ?, valor = ?, tipo_pag = ? where id = ?";
        conn = new Conexao().conectaBD();
        
        try {
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, objvendadto.getVenda());
            pstm.setFloat(2, objvendadto.getValor());
            pstm.setString(3, objvendadto.getTipoPag());
            pstm.setInt(4, objvendadto.getId());
            
            pstm.execute();
            pstm.close();
            
        } catch (SQLException erro) {
        }
    }
    
}
