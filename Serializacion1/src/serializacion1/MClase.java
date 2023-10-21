package serializacion1;

import java.io.Serializable;

public class MClase implements Serializable{
    String nome;
    //int numero1;
    transient int numero1;  // Marcamos la variable como transient
    double numero2;

    public MClase() {
    }

    public MClase(String nome, int numero1, double numero2) {
        this.nome = nome;
        this.numero1 = numero1;
        this.numero2 = numero2;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getNumero1() {
        return numero1;
    }

    public void setNumero1(int numero1) {
        this.numero1 = numero1;
    }

    public double getNumero2() {
        return numero2;
    }

    public void setNumero2(int numero2) {
        this.numero2 = numero2;
    }
    

}
