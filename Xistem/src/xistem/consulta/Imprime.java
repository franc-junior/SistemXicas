package xistem.consulta;

import xistem.entidade.*;


public class Imprime {
    public static void printAllVendas(Vendas[] vendas){
        for (Vendas v : vendas){
            System.out.println("ID: "+v.getId()+" | Data e Hora: "+v.getDataHora()+" | Venda: "+v.getVenda()+" | Valor: "+v.getValor()+" | Pagamento: "+v.getTipoPagamento());
        }
    }   
    
}
