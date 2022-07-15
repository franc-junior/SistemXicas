/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package xistem.consulta;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import xistem.entidade.*;


/**
 *
 * @author franc
 */
public class SelectAll {
    static Conexao conexao = new Conexao();
    
    public static Vendas[] selectAllVendas(){
        try{
            Connection con = conexao.conectaBD();
            Statement stmt = con.createStatement();
            
            ResultSet linhas = stmt.executeQuery("select count(*) from vendas");
            linhas.next();
            Vendas[] vendas = new Vendas[linhas.getInt(1)];
            int i = 0;
            
            String query = "select * from vendas;";
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()){
                int id = rs.getInt(1);
                String dataHora = rs.getString(2);
                String venda = rs.getString(3);
                double valor = rs.getDouble(4);
                String tipoPagamento = rs.getString(5);
                
                Vendas v = new Vendas();
                
                v.setId(id);
                v.setDataHora(dataHora);
                v.setVenda(venda);
                v.setValor(valor);
                v.setTipoPagamento(tipoPagamento);
                vendas[i] = v;
                i++;     
            }
            rs.close();
            return vendas;
        }
        catch (Exception e){
            System.out.println("e");
            return null;
        }
        
    }
    
}
