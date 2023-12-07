package pasaxeirosvoosserializadooracle_3;

import java.io.IOException;
import java.sql.SQLException;

public class Pasaxeirosvoosserializadooracle_3 {

    public static void main(String[] args) throws SQLException, IOException, ClassNotFoundException {
        Metodos metodos = new Metodos();
        metodos.lerReservas();
    }
    
}
