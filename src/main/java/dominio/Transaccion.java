/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;

import java.util.Objects;

/**
 *
 * @author JORGE
 */
public class Transaccion {
    private Integer id;
    private Double monto;
    private Integer cuenta_origen;

    public Transaccion() {
    }

    public Transaccion(Integer id, Double monto, Integer cuenta_origen) {
        this.id = id;
        this.monto = monto;
        this.cuenta_origen = cuenta_origen;
    }

    public Transaccion(Double monto, Integer cuenta_origen) {
        this.monto = monto;
        this.cuenta_origen = cuenta_origen;
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

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 19 * hash + Objects.hashCode(this.id);
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
        final Transaccion other = (Transaccion) obj;
        return Objects.equals(this.id, other.id);
    }

    @Override
    public String toString() {
        return "Transaccion{" + "id=" + id + ", monto=" + monto + ", cuenta_origen=" + cuenta_origen + '}';
    }
    
}
