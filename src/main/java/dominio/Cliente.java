/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;

import java.sql.Date;
import java.util.Objects;

/**
 *
 * @author JORGE
 */
public class Cliente {

    private Integer id;
    private String nombre;
    private String apellido_paterno;
    private String apellido_materno;
    private Date fecha_nacimiento;
    private String usuario;
    private String contrasenia;
    private Integer idDireccion;

    public Cliente() {
    }

    ;

    /**
     * Constructor con id
     * @param id id del cliente
     * @param nombre nombre del cliente
     * @param apellido_paterno apellido paterno del cliente
     * @param apellido_materno apellido materno del cliente
     * @param fecha_nacimiento fecha de nacimiento del cliente
     * @param usuario usuario del cliente
     * @param contrasenia contraseña del cliente
     * @param idDireccion identificación de la dirección
     */
    public Cliente(Integer id, String nombre, String apellido_paterno, String apellido_materno, Date fecha_nacimiento, String usuario, String contrasenia, Integer idDireccion) {
        this.id = id;
        this.nombre = nombre;
        this.apellido_paterno = apellido_paterno;
        this.apellido_materno = apellido_materno;
        this.fecha_nacimiento = fecha_nacimiento;
        this.usuario = usuario;
        this.contrasenia = contrasenia;
        this.idDireccion = idDireccion;
    }

    /**
     * Constructor sin identificación
     *
     * @param nombre nombre del cliente
     * @param apellido_paterno apellido paterno del cliente
     * @param apellido_materno apellido materno del cliente
     * @param fecha_nacimiento fecha de nacimiento del cliente
     * @param usuario usuario del cliente
     * @param contrasenia contraseña del cliente
     * @param idDireccion identificación de la dirección
     */
    public Cliente(String nombre, String apellido_paterno, String apellido_materno, Date fecha_nacimiento, String usuario, String contrasenia, Integer idDireccion) {
        this.nombre = nombre;
        this.apellido_paterno = apellido_paterno;
        this.apellido_materno = apellido_materno;
        this.fecha_nacimiento = fecha_nacimiento;
        this.usuario = usuario;
        this.contrasenia = contrasenia;
        this.idDireccion = idDireccion;
    }

    /**
     * Constructor sin la identificación de la dirección
     *
     * @param nombre nombre del cliente
     * @param apellido_paterno apellido paterno del cliente
     * @param apellido_materno apellido materno del cliente
     * @param fecha_nacimiento fecha de nacimiento del cliente
     * @param usuario usuario del cliente
     * @param contrasenia contraseña del cliente
     */
    public Cliente(String nombre, String apellido_paterno, String apellido_materno, Date fecha_nacimiento, String usuario, String contrasenia) {
        this.nombre = nombre;
        this.apellido_paterno = apellido_paterno;
        this.apellido_materno = apellido_materno;
        this.fecha_nacimiento = fecha_nacimiento;
        this.usuario = usuario;
        this.contrasenia = contrasenia;
    }

    /**
     * Busca el ID
     *
     * @return ID
     */
    public Integer getId() {
        return id;
    }

    /**
     * Setea un valor al ID
     *
     * @param id id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Busca el nombre del usuario
     *
     * @return Nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Setea un nombre
     *
     * @param nombre Nombre del usuario
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Busca el apellido paterno del usuario
     *
     * @return Apellido paterno
     */
    public String getApellido_paterno() {
        return apellido_paterno;
    }

    /**
     * Setea el apellido paterno
     *
     * @param apellido_paterno Apellido paterno del usuario
     */
    public void setApellido_paterno(String apellido_paterno) {
        this.apellido_paterno = apellido_paterno;
    }

    /**
     * Busca el apellido materno del usuario
     *
     * @return Apellido materno
     */
    public String getApellido_materno() {
        return apellido_materno;
    }

    /**
     * Setea el apellido materno
     *
     * @param apellido_materno Apellido materno del usuario
     */
    public void setApellido_materno(String apellido_materno) {
        this.apellido_materno = apellido_materno;
    }

    /**
     * Busca el ID de una dirección
     *
     * @return ID de dirección
     */
    public Integer getIdDireccion() {
        return idDireccion;
    }

    /**
     * Setea a la dirección una identificación
     *
     * @param idDireccion Identificación de dirección
     */
    public void setIdDireccion(Integer idDireccion) {
        this.idDireccion = idDireccion;
    }

    /**
     * Busca el nombre de usuario del cliente
     *
     * @return Nombre de usuario
     */
    public String getUsuario() {
        return usuario;
    }

    /**
     * Setea el usuario que el cliente proporcionó
     *
     * @param usuario Nombre de usuario
     */
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    /**
     * Busca la contraseña del usuario
     *
     * @return Contraseña
     */
    public String getContrasenia() {
        return contrasenia;
    }

    /**
     * Setea la contraseña del usuario
     *
     * @param contrasenia Contraseña del usuario
     */
    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    /**
     * Busca la fecha de nacimiento del usuario
     *
     * @return Fecha de nacimiento
     */
    public Date getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    /**
     * Setea la fecha de nacimiento del usuario
     *
     * @param fecha_nacimiento Fecha de nacimiento del usuario
     */
    public void setFecha_nacimiento(Date fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    @Override
    public int hashCode() {
        int hash = 7;
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
        final Cliente other = (Cliente) obj;
        return Objects.equals(this.id, other.id);
    }

    @Override
    public String toString() {
        return "Cliente{" + "id=" + id + ", nombre=" + nombre + ", apellido_paterno=" + apellido_paterno + ", apellido_materno=" + apellido_materno + ", fecha_nacimiento=" + fecha_nacimiento + ", usuario=" + usuario + ", contrasenia=" + contrasenia + ", idDireccion=" + idDireccion + '}';
    }

}
