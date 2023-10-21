package baserelacionalapostgres;

import java.sql.Date;

public class BaseRelacionalA {

    public static void main(String[] args) {
        Metodos orden = new Metodos();

        orden.insireProduto("p1", "parafusos", 3, Date.valueOf("2020-12-27"));
        orden.insireProduto("p2", "cravos", 4, Date.valueOf("2020-04-06"));
        orden.insireProduto("p3", "tachas", 6, Date.valueOf("2020-07-03"));
        
        orden.listaProdutos();
        
        orden.actualizaPre("p1", 9);
        
        orden.listaProdutos();
        
        orden.eliminaProduto("p3");
        
        orden.listaProdutos();
        
        orden.buscarProduto("p2");
        
    }

}
