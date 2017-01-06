package giga.model;

import java.util.ArrayList;

/**
 *
 * @author Ronald
 */
public class Fornecedor {
    private int ID;
    private String nome;
    private String descricao;
    private String cidade;
    private String endereco;
    private String bairro;
    private int numero;
    private ArrayList<Email> emails;
    private ArrayList<Telefone> telefones;

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
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public ArrayList<Email> getEmails() {
        return emails;
    }

    public void addEmail(Email email) {
        if ( null == emails ){
            emails = new ArrayList<>();
        }
        
        this.emails.add(email);
    }

    public ArrayList<Telefone> getTelefones() {
        return telefones;
    }
    
    public void addTelefone(Telefone telefone) {
        if ( null == telefone ){
            telefones = new ArrayList<>();
        }
        
        this.telefones.add(telefone);
    }

    public void setEmails(ArrayList<Email> emails) {
        this.emails = emails;
    }

    public void setTelefones(ArrayList<Telefone> telefones) {
        this.telefones = telefones;
    }

    @Override
    public String toString() {
        return getNome();
    }
    
    
}
