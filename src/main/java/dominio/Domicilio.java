/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;

import java.util.Objects;

public class Domicilio {
    private Integer id;
    private String calle;
    private String colonia;
    private String num_casa;

    /**
     * Constructor vacío
     */
    public Domicilio() {
    }

    /**
     * Constructor por defecto
     * @param id Identificación del domicilio
     * @param calle Calle 
     * @param colonia Colonia
     * @param num_casa Número de casa
     */
    public Domicilio(Integer id, String calle, String colonia, String num_casa) {
        this.id = id;
        this.calle = calle;
        this.colonia = colonia;
        this.num_casa = num_casa;
    }

    /**
     * Constructor sin identificación del domicilio 
     * @param calle Calle 
     * @param colonia Colonia
     * @param num_casa Número de casa
     */
    public Domicilio(String calle, String colonia, String num_casa) {
        this.calle = calle;
        this.colonia = colonia;
        this.num_casa = num_casa;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getColonia() {
        return colonia;
    }

    public void setColonia(String colonia) {
        this.colonia = colonia;
    }

    public String getNum_casa() {
        return num_casa;
    }

    public void setNum_casa(String num_casa) {
        this.num_casa = num_casa;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 43 * hash + Objects.hashCode(this.id);
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
        final Domicilio other = (Domicilio) obj;
        return Objects.equals(this.id, other.id);
    }

    @Override
    public String toString() {
        return "Domicilio{" + "id=" + id + ", calle=" + calle + ", colonia=" + colonia + ", num_casa=" + num_casa + '}';
    }
    
    
}
