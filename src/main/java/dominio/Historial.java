/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;

import java.sql.Date;
import java.util.Objects;

/**
 *
 * @author Jorge Sánchez y Rosalía Pérez
 */
public class Historial {
    private Integer id;
    private String operacion;
    private Date fecha;
    private Integer id_clientes;

    /**
     * Constructor vacío
     */
    public Historial() {
    }

    /**
     * Constructor por defecto
     * @param id Identificación del historial
     * @param operacion Operación a realizar
     * @param fecha Fecha en la que una operación se realiza
     * @param id_clientes Identificación de cliente.
     */
    public Historial(Integer id, String operacion, Date fecha, Integer id_clientes) {
        this.id = id;
        this.operacion = operacion;
        this.fecha = fecha;
        this.id_clientes = id_clientes;
    }

    /**
     * Constructor sin identificación del historial
     * @param operacion Operación a realizar
     * @param fecha Fecha en la que una operación se realiza
     * @param id_clientes Identificación de cliente.
     */
    public Historial(String operacion, Date fecha, Integer id_clientes) {
        this.operacion = operacion;
        this.fecha = fecha;
        this.id_clientes = id_clientes;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOperacion() {
        return operacion;
    }

    public void setOperacion(String operacion) {
        this.operacion = operacion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Integer getId_clientes() {
        return id_clientes;
    }

    public void setId_clientes(Integer id_clientes) {
        this.id_clientes = id_clientes;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + Objects.hashCode(this.id);
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
        final Historial other = (Historial) obj;
        return Objects.equals(this.id, other.id);
    }

    @Override
    public String toString() {
        return "Historial{" + "id=" + id + ", operacion=" + operacion + ", fecha=" + fecha + ", id_clientes=" + id_clientes + '}';
    }
    
    
    
}
