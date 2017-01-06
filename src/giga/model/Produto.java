package giga.model;

/**
 *
 * @author Ronald
 */
public class Produto {
    private int ID;
    private String nome;
    private String descicao;
    private int fornecedorID;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descicao;
    }

    public void setDescricao(String descicao) {
        this.descicao = descicao;
    }

    public int getFornecedorID() {
        return fornecedorID;
    }

    public void setFornecedorID(int fornecedorID) {
        this.fornecedorID = fornecedorID;
    }

    @Override
    public String toString() {
        return getNome();
    }
    
    
}
