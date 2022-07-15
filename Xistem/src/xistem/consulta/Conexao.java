package xistem.consulta;

import java.sql.Connection;
import javax.swing.JOptionPane;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
    
    public Connection conectaBD(){
        Connection conn = null;
        
        try {
            String url = "jdbc:mysql://localhost:3306/testes?user=root&password=";
            conn = DriverManager.getConnection(url);
            
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return conn;
    }
    
}
