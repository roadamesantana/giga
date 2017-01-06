package giga.model;

/**
 *
 * @author Ronald
 */
public class Item {
    private int ID;
    private float quantidade;
    private float valor;
    private int pedidoID;
    private Produto produto;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public float getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(float quantidade) {
        this.quantidade = quantidade;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public int getPedidoID() {
        return pedidoID;
    }

    public void setPedidoID(int pedidoID) {
        this.pedidoID = pedidoID;
    }

    public Produto getProdutoID() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    @Override
    public String toString() {
        if( null == produto ){
            return "";
        }
        
        return produto.getNome() + "  -  " + getQuantidade() + "  -  R$ " + getValor();
    }
    
    
}
