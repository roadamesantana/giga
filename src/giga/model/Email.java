package giga.model;

/**
 *
 * @author Ronald
 */
public class Email {
    private int ID;
    private String email;
    private String referencia;
    private int fornecedorID;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
        return getEmail();
    }
    
    
}
