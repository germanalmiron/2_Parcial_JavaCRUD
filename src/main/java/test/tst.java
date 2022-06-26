package test;

import alumnoDAO.alumnoDAO;
import alumnoDTO.alumno;
import conexion.cnx;
import java.util.ArrayList;
import java.util.List;

public class tst {

    public static alumnoDAO dao = new alumnoDAO();

    public static void main(String[] args){

        System.out.println("");
        System.out.println("--------------------App ABM con JAVA en MYSQL---------------------");

        System.out.println("");
        System.out.println("¿Accede a la base de datos?");
        System.out.println("");

        conex(); //Para verificar solamante en el inicio la conexión a la base de datos.

        System.out.println("");
        System.out.println("==================================TABLA=========================================");
        System.out.println("");
        readall(); //==> Método principal; Para obtener los datos de la tabla alumno.

        //System.out.println("");
        //System.out.println("OPCIÓN: 1 <Aplica la instrucción de manera correcta> | OPCION: 0 <ERROR en la carga de la data>");
        //create(); //==> crea nueva data según Tabla MYSQL.

        //*******ABM***********//

        //update(); //==> Actualiza los datos

        System.out.println("");
        System.out.println("=====================BUSQUEDA POR ID===========================");
        read(); //==> Lee los datos por medio del Id.
        //delete(); // ==> Para borrar según Id.

    }

    private static void delete() {
        System.out.println(dao.delete(21));
        System.out.println(dao.delete(22));
    }

    public static void read() {
        alumno alum = dao.read(2);
        if (dao != null) {
            System.out.println("Nombre: " + alum.getNombre());
            System.out.println("Apellido: " + alum.getApellido());
            System.out.println("Edad: " + alum.getEdad());
            System.out.println("Sexo: " + alum.getSexo());

        } else {
            System.out.println("No se enconntro el contacto");
        }

    }

    private static void update() {
        alumno DTO = new alumno(2, "Susana", "Perez", 25, "F" );
        System.out.println(dao.update(DTO));
    }

    private static void create() {
        alumno DTO = new alumno("Cecilia", "Becchi", 37, "F");
        System.out.println(dao.create(DTO));
    }

    private static void readall() {
        List<alumno> lista = new ArrayList<>();
        lista = dao.readAll();
        for (int i=0; i<lista.size();i++){
            System.out.println(lista.get(i).getId() + "          " + lista.get(i).getNombre()
                    + "          " + lista.get(i).getApellido()
                    + "          " + lista.get(i).getEdad()
                    + "          " + lista.get(i).getSexo() + "");
        }
    }

    public static void conex(){ //Verifica si se logra la conexión a la base de datos por parte del Usuario.

        if(cnx.getConexion()!=null){
            System.out.println("Conexión exitosa!!!");
        }else {
            System.out.println("ERROR!! No existe la conexión!!!"); //Para testear si se realizó la conexión
        }

    }

}
