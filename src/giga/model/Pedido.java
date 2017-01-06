package giga.model;

import java.util.Calendar;

/**
 *
 * @author Ronald
 */
public class Pedido {
    private int ID;
    private Calendar dataHora;
    private String notaFiscal;
    private float valorFrete;
    private float desconto;
    private float valorTotal;
    private int transportadoraID;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public Calendar getDataHora() {
        return dataHora;
    }

    public void setDataHora(Calendar dataHora) {
        this.dataHora = dataHora;
    }

    public String getNotaFiscal() {
        return notaFiscal;
    }

    public void setNotaFiscal(String notaFiscal) {
        this.notaFiscal = notaFiscal;
    }

    public float getValorFrete() {
        return valorFrete;
    }

    public void setValorFrete(float valorFrete) {
        this.valorFrete = valorFrete;
    }

    public float getDesconto() {
        return desconto;
    }

    public void setDesconto(float desconto) {
        this.desconto = desconto;
    }

    public float getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(float valorTotal) {
        this.valorTotal = valorTotal;
    }

    public int getTransportadoraID() {
        return transportadoraID;
    }

    public void setTransportadoraID(int transportadoraID) {
        this.transportadoraID = transportadoraID;
    }
}
