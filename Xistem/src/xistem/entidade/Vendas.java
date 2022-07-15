package xistem.entidade;

/**
 *
 * @author franc
 */
public class Vendas {
    int id;
    String tipoPagamento;
    String venda;
    double valor;
    String dataHora;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipoPagamento() {
        return tipoPagamento;
    }

    public void setTipoPagamento(String tipoPagamento) {
        this.tipoPagamento = tipoPagamento;
    }

    public String getVenda() {
        return venda;
    }

    public void setVenda(String venda) {
        this.venda = venda;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getDataHora() {
        return dataHora;
    }

    public void setDataHora(String dataHora) {
        this.dataHora = dataHora;
    }
    
}
