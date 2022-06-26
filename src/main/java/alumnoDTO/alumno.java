package alumnoDTO;

public class alumno {

    public int id;
    public String nombre;
    public String apellido;
    public int edad;
    public String sexo;

    //Cosntructores

    public alumno() {
        super();
    }

    public alumno(String nombre, String apellido, int edad, String sexo) {
        super();
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.sexo = sexo;
    }

    public alumno(int id, String nombre, String apellido, int edad, String sexo) {
        super();
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.sexo = sexo;
    }

    //Get and set

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public void setId(long id) {this.id = (int) id;
    }
}
