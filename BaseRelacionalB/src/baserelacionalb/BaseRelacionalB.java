package baserelacionalb;

import java.sql.Date;

public class BaseRelacionalB {

    public static void main(String[] args) {
        Metodos orden = new Metodos();

        orden.insireProduto("p1", "parafusos", 3, Date.valueOf("2020-12-27"));
        orden.insireProduto("p2", "cravos", 4, Date.valueOf("2020-04-06"));
        orden.insireProduto("p3", "tachas", 6, Date.valueOf("2020-07-03"));
        
        orden.listaProdutos();
        
        orden.actualizaPre("p2", 20);
        
        orden.listaProdutos();
        
        orden.eliminaProduto("p3");
        
        orden.listaProdutos();
        
    }

}
