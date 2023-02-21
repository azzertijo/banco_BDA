/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;

import java.util.Objects;


public class Transferencia {
    private Integer id;
    private Double monto;
    private Integer cuenta_origen;
    private Integer cuenta_destino;
    
/**
 * Constructor vacio
 */
    public Transferencia() {
    }

    /**
     * Constructor por defecto
     * @param id Identificación de la transferencia
     * @param monto Monto que se desea mandar
     * @param cuenta_origen Cuenta de origen
     * @param cuenta_destino Cuenta a la que se le va a mandar el dinero
     */
    public Transferencia(Integer id, Double monto, Integer cuenta_origen, Integer cuenta_destino) {
        this.id = id;
        this.monto = monto;
        this.cuenta_origen = cuenta_origen;
        this.cuenta_destino = cuenta_destino;
    }

    /**
     * Constructor sin identificación de la transferencia
     * @param monto Monto que se desea mandar
     * @param cuenta_origen Cuenta de origen
     * @param cuenta_destino Cuenta a la que se le va a mandar el dinero
     */
    public Transferencia(Double monto, Integer cuenta_origen, Integer cuenta_destino) {
        this.monto = monto;
        this.cuenta_origen = cuenta_origen;
        this.cuenta_destino = cuenta_destino;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getMonto() {
        return monto;
    }

    public void setMonto(Double monto) {
        this.monto = monto;
    }

    public Integer getCuenta_origen() {
        return cuenta_origen;
    }

    public void setCuenta_origen(Integer cuenta_origen) {
        this.cuenta_origen = cuenta_origen;
    }

    public Integer getCuenta_destino() {
        return cuenta_destino;
    }

    public void setCuenta_destino(Integer cuenta_destino) {
        this.cuenta_destino = cuenta_destino;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Transferencia other = (Transferencia) obj;
        return Objects.equals(this.id, other.id);
    }

    @Override
    public String toString() {
        return "Transferencia{" + "id=" + id + ", monto=" + monto + ", cuenta_origen=" + cuenta_origen + ", cuenta_destino=" + cuenta_destino + '}';
    }

    
    
}
