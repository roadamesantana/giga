package giga.model;

/**
 *
 * @author Ronald
 */
public class Telefone {
    private int ID;
    private String ddd;
    private String numero;
    private String referencia;
    private int fornecedorID;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getDdd() {
        return ddd;
    }

    public void setDdd(String ddd) {
        this.ddd = ddd;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public int getFornecedorID() {
        return fornecedorID;
    }

    public void setFornecedorID(int fornecedorID) {
        this.fornecedorID = fornecedorID;
    }

    @Override
    public String toString() {
        return "(" + getDdd() + ") " + getNumero();
    }
    
    
}
