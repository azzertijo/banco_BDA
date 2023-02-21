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
public class RetiroSinCuenta {
    
  private Integer id;
  private Integer cuenta_origen;
  private Double monto;
  private Integer folio;
  private Integer contrasenia;

    public RetiroSinCuenta(Integer id, Integer cuenta_origen, Double monto, Integer folio, Integer contrasenia) {
        this.id = id;
        this.cuenta_origen = cuenta_origen;
        this.monto = monto;
        this.folio = folio;
        this.contrasenia = contrasenia;
    }

    public RetiroSinCuenta(Integer cuenta_origen, Double monto, Integer folio, Integer contrasenia) {
        this.cuenta_origen = cuenta_origen;
        this.monto = monto;
        this.folio = folio;
        this.contrasenia = contrasenia;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCuenta_origen() {
        return cuenta_origen;
    }

    public void setCuenta_origen(Integer cuenta_origen) {
        this.cuenta_origen = cuenta_origen;
    }

    public Double getMonto() {
        return monto;
    }

    public void setMonto(Double monto) {
        this.monto = monto;
    }

    public Integer getFolio() {
        return folio;
    }

    public void setFolio(Integer folio) {
        this.folio = folio;
    }

    public Integer getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(Integer contrasenia) {
        this.contrasenia = contrasenia;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 47 * hash + Objects.hashCode(this.id);
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
        final RetiroSinCuenta other = (RetiroSinCuenta) obj;
        return Objects.equals(this.id, other.id);
    }

    @Override
    public String toString() {
        return "RetiroSinCuenta{" + "id=" + id + ", cuenta_origen=" + cuenta_origen + ", monto=" + monto + ", folio=" + folio + ", contrasenia=" + contrasenia + '}';
    }
  
  
}
