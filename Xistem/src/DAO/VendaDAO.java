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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


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
    
    public ArrayList<VendaDTO> pesquisaVenda(int dia, int mes, int ano){
        String sql = "select * from venda where YEAR(data_hora) = ? and MONTH(data_hora) = ? and DAY(data_hora) = ?";
        conn = new Conexao().conectaBD();
        
        try{
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1,ano);
            pstm.setInt(2, mes);
            pstm.setInt(3, dia);
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
            JOptionPane.showMessageDialog(null, "VendaDAO PesquisarVendaDia "+ erro);
        }
        return lista;
    }
    
    public ArrayList<VendaDTO> pesquisaVenda(int mes, int ano){
        String sql = "select * from venda where YEAR(data_hora) = ? and MONTH(data_hora) = ?";
        conn = new Conexao().conectaBD();
        
        try{
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1,ano);
            pstm.setInt(2, mes);
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
            JOptionPane.showMessageDialog(null, "VendaDAO PesquisarVendaMes "+ erro);
        }
        return lista;
    }
    
    public ArrayList<VendaDTO> pesquisaVenda(int ano){
        String sql = "select * from venda where YEAR(data_hora) = ?";
        conn = new Conexao().conectaBD();
        
        try{
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1,ano);
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
            JOptionPane.showMessageDialog(null, "VendaDAO PesquisarVendaMes "+ erro);
        }
        return lista;
    }
    
    public ArrayList<Date> listaAnos() throws ParseException{
        ArrayList<Date> listaDistinta = new ArrayList<>();
        SimpleDateFormat formatAno = new SimpleDateFormat("yyyy");
        
        String sql = "select distinct year(data_hora) from venda;";
        Date anoFormatado;
        
        conn = new Conexao().conectaBD();
        
        try {
            pstm = conn.prepareStatement(sql);
            rs = pstm.executeQuery();
            
            while (rs.next()){
                anoFormatado = formatAno.parse(rs.getString("YEAR(data_hora)"));
                
                listaDistinta.add(anoFormatado);
          
            }
  
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "VendaDAO listaAnos "+ erro);
        }
        return listaDistinta;
    }
    
    public ArrayList<Date> listaMeses() throws ParseException{
        ArrayList<Date> listaDistinta = new ArrayList<>();     //******
        SimpleDateFormat formatMes = new SimpleDateFormat("MM/yyyy"); //******
        
        String sql = "select distinct year(data_hora), month(data_hora) from venda;";
        Date mesFormatado; // formatMes.parse(""); //*******
        
        conn = new Conexao().conectaBD();
        
        try {
            pstm = conn.prepareStatement(sql);
            rs = pstm.executeQuery();
            
            while (rs.next()){
                mesFormatado = formatMes.parse(rs.getString("MONTH(data_hora)")+"/"+rs.getString("YEAR(data_hora)")); //******
                
                listaDistinta.add(mesFormatado);
            }
  
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "VendaDAO listaAnos "+ erro);
        }
        return listaDistinta;
    }
    
    public ArrayList<Date> listaDias() throws ParseException{
        ArrayList<Date> listaDistinta = new ArrayList<>();
        SimpleDateFormat formatDia = new SimpleDateFormat("dd/MM/yyyy");
        
        String sql = "select distinct year(data_hora), month(data_hora), day(data_hora) from venda;";
        Date diaFormatado;
        
        conn = new Conexao().conectaBD();
        
        try {
            pstm = conn.prepareStatement(sql);
            rs = pstm.executeQuery();
            
            while (rs.next()){
                diaFormatado = formatDia.parse(rs.getString("DAY(data_hora)")+"/"+rs.getString("MONTH(data_hora)")+"/"+rs.getString("YEAR(data_hora)"));
                listaDistinta.add(diaFormatado);
            }
  
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "VendaDAO listaAnos "+ erro);
        }
        return listaDistinta;
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
