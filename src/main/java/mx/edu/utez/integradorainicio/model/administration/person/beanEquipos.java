package mx.edu.utez.integradorainicio.model.administration.person;

public class beanEquipos {

    private String id_eqo;
    private String nombre;
    private String descripcion;
    private String marca;
    private String modelo;
    private String n_serie;
    private String disponibilidad;
    private String estado;

    public beanEquipos(String id_eqo, String nombre, String descripcion, String marca, String modelo, String n_serie, String disponibilidad, String estado) {
        this.id_eqo = id_eqo;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.marca = marca;
        this.modelo = modelo;
        this.n_serie = n_serie;
        this.disponibilidad = disponibilidad;
        this.estado = estado;
    }


    public void setId_eqo(String id_eqo) {
        this.id_eqo = id_eqo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setN_serie(String n_serie) {
        this.n_serie = n_serie;
    }

    public void setDisponibilidad(String disponibilidad) {
        this.disponibilidad = disponibilidad;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }



    public String getId_eqo() {
        return id_eqo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public String getN_serie() {
        return n_serie;
    }

    public String getDisponibilidad() {
        return disponibilidad;
    }

    public String getEstado() {
        return estado;
    }
}
