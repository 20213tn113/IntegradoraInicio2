package mx.edu.utez.integradorainicio.model.administration.person;


public class beanPerson {
    private int id;
    private String name;
    private String user;
    private String pass;

    public beanPerson(int id, String name, String user, String pass) {
        this.id = id;
        this.name = name;
        this.user = user;
        this.pass = pass;
    }

    public beanPerson(int id, String user, String pass) {
        this.id = id;
        this.user = user;
        this.pass = pass;
    }

    public beanPerson(String user, String pass) {
        this.user = user;
        this.pass = pass;
    }

    public beanPerson(String name, String user, String pass) {
        this.user = user;
        this.pass = pass;
        this.name = name;
    }
    public beanPerson() {

    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }




    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getUser() {
        return user;
    }

    public String getPass() {
        return pass;
    }


}

