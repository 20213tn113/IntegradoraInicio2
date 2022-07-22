package mx.edu.utez.integradorainicio.model.administration.person;


public class beanUsuario {
    private String matricula;
    private String nombre;

    private String apellido;

    private String correo;
    private String rol;

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public beanUsuario() {

    }

    public beanUsuario(String matricula, String nombre, String apellido, String correo, String rol) {
    this.matricula=matricula;
    this.nombre=nombre;
    this.apellido=apellido;
    this.correo=correo;
    this.rol=rol;
    }

}



