package mx.edu.utez.integradorainicio.model.administration.person;

public class beanPrestamo {

    private int id_prestamo;
    private String id_eqo;
    private String matricula;
    private String hora_inicio;
    private String hora_final;
    private String nombre;
    private String apellido;

    private String correo;
    private String fecha;
    private String rol;

    public beanPrestamo(int id_prestamo, String id_eqo, String matricula, String hora_inicio, String hora_final) {
        this.id_prestamo = id_prestamo;
        this.id_eqo = id_eqo;
        this.matricula = matricula;
        this.hora_inicio = hora_inicio;
        this.hora_final = hora_final;
    }

    public beanPrestamo(int id_prestamo, String id_eqo) {
        this.id_prestamo = id_prestamo;
        this.id_eqo = id_eqo;
    }

    public beanPrestamo() {

    }

    public beanPrestamo(String matricula, String nombre, String apellido, String correo, String rol) {
        this.matricula=matricula;
        this.nombre=nombre;
        this.apellido=apellido;
        this.correo=correo;
        this.rol=rol;
    }

    public int getId_prestamo() {
        return id_prestamo;
    }

    public void setId_prestamo(int id_prestamo) {
        this.id_prestamo = id_prestamo;
    }

    public String getId_eqo() {
        return id_eqo;
    }

    public void setId_eqo(String id_eqo) {
        this.id_eqo = id_eqo;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getHora_inicio() {
        return hora_inicio;
    }

    public void setHora_inicio(String hora_inicio) {
        this.hora_inicio = hora_inicio;
    }

    public String getHora_final() {
        return hora_final;
    }

    public void setHora_final(String hora_final) {
        this.hora_final = hora_final;
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

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }
}

