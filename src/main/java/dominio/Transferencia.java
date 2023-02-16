/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;

import java.util.Objects;


public class Transferencia {
    private Integer id;
    private Integer cuenta_destino;

    public Transferencia() {
    }

    public Transferencia(Integer id, Integer cuenta_destino) {
        this.id = id;
        this.cuenta_destino = cuenta_destino;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCuenta_destino() {
        return cuenta_destino;
    }

    public void setCuenta_destino(Integer cuenta_destino) {
        this.cuenta_destino = cuenta_destino;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 71 * hash + Objects.hashCode(this.id);
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
        return "Transferencia{" + "id=" + id + ", cuenta_destino=" + cuenta_destino + '}';
    }
}
