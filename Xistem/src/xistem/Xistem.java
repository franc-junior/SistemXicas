package xistem;

import xistem.consulta.Imprime;
import xistem.consulta.SelectAll;

public class Xistem {

    public static void main(String[] args) {
        Imprime.printAllVendas(SelectAll.selectAllVendas());
        
    }
    
}
