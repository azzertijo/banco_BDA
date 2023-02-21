/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;

import java.sql.Date;
import java.util.Objects;

public class Cuenta {

    private Integer id;
    private Integer num_cuenta;
    private Double saldo;
    private Date fecha_apertura;
    private Integer id_cliente;

    /**
     * Constructor vacío
     */
    public Cuenta() {
    }

    /**
     * Constructor por defecto
     *
     * @param id ID de la cuenta
     * @param num_cuenta Numero de cuenta
     * @param saldo Saldo en la cuenta
     * @param fecha_apertura Fecha de creación de la cuenta
     * @param id_cliente ID del dueño de la cuenta
     */
    public Cuenta(Integer id, Integer num_cuenta, Double saldo, Date fecha_apertura, Integer id_cliente) {
        this.id = id;
        this.num_cuenta = num_cuenta;
        this.saldo = saldo;
        this.fecha_apertura = fecha_apertura;
        this.id_cliente = id_cliente;
    }

    /**
     * Constructor sin ID
     *
     * @param num_cuenta Numero de cuenta
     * @param saldo Saldo en la cuenta
     * @param fecha_apertura Fecha de creación de la cuenta
     * @param id_cliente ID del dueño de la cuenta
     */
    public Cuenta(Integer num_cuenta, Double saldo, Date fecha_apertura, Integer id_cliente) {
        this.num_cuenta = num_cuenta;
        this.saldo = saldo;
        this.fecha_apertura = fecha_apertura;
        this.id_cliente = id_cliente;
    }

    /**
     * Constructor sin ID del cliente
     * @param num_cuenta Numero de cuenta
     * @param saldo Saldo en la cuenta
     * @param fecha_apertura Fecha de creación de la cuenta
     */
    public Cuenta(Integer num_cuenta, Double saldo, Date fecha_apertura) {
        this.num_cuenta = num_cuenta;
        this.saldo = saldo;
        this.fecha_apertura = fecha_apertura;
    }

    /**
     * Constructor con el número de cuenta y saldo
     * @param num_cuenta Numero de cuenta
     * @param saldo Saldo en la cuenta
     */
    public Cuenta(Integer num_cuenta, Double saldo) {
        this.num_cuenta = num_cuenta;
        this.saldo = saldo;
    }

    /**
     * Constructor con ID del cliente
     * @param num_cuenta Numero de cuenta
     * @param saldo Saldo en la cuenta
     * @param id_cliente ID del dueño de la cuenta
     */
    public Cuenta(Integer num_cuenta, Double saldo, Integer id_cliente) {
        this.num_cuenta = num_cuenta;
        this.saldo = saldo;
        this.id_cliente = id_cliente;
    }

   
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNum_cuenta() {
        return num_cuenta;
    }

    public void setNum_cuenta(Integer num_cuenta) {
        this.num_cuenta = num_cuenta;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    public Date getFecha_apertura() {
        return fecha_apertura;
    }

    public void setFecha_apertura(Date fecha_apertura) {
        this.fecha_apertura = fecha_apertura;
    }

    public Integer getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(Integer id_cliente) {
        this.id_cliente = id_cliente;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.id);
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
        final Cuenta other = (Cuenta) obj;
        return Objects.equals(this.id, other.id);
    }

    @Override
    public String toString() {
        return "" + num_cuenta;
    }

}
