package alumnoDAO;

import alumnoDTO.alumno;
import interfaces.operaciones;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static conexion.cnx.getConexion;

public class alumnoDAO implements operaciones <alumno>{

    private ResultSet rs;
    private PreparedStatement ps;
    private Connection cx;
    private static final String SQL_REALL = "SELECT * FROM alumnos";
    private static final String SQL_CREATE = "INSERT INTO alumnos (nombre, apellido, edad, sexo)VALUES (?,?,?,?)";
    private static final String SQL_READ = "SELECT * FROM alumnos WHERE id = ?";
    private static final String SQL_UPDATE = "UPDATE alumnos SET nombre = ?, apellido = ?, edad =?, sexo =? WHERE id = ?";
    private static final String SQL_DELETE = "DELETE FROM alumnos WHERE id = ?";



    //====================MÉTODO CREAR====================//
    @Override
    public int create(alumno t) {

        int x = 0;
        try {
            cx = getConexion();
            ps = cx.prepareStatement(SQL_CREATE);
            ps.setString(1, t.getNombre());
            ps.setString(2, t.getApellido());
            ps.setInt(3, t.getEdad());
            ps.setString(4, t.getSexo());
            x = ps.executeUpdate();
        }catch (Exception e){
            System.out.println("ERROR:"+e);
        }
        return x;
    }

    //====================MÉTODO ACTUALIZAR====================//

    @Override
    public int update(alumno t) {
        int x = 0;
        try {
            cx = getConexion();
            ps = cx.prepareStatement(SQL_UPDATE);
            ps.setString(1, t.getNombre());
            ps.setString(2, t.getApellido());
            ps.setInt(3, t.getEdad());
            ps.setString(4, t.getSexo());
            ps.setInt(5, t.getId());
            x = ps.executeUpdate();
        }catch (Exception e){
            System.out.println("ERROR:"+e);
        }
        return x;
    }

    //====================MÉTODO ELIMINAR====================//

    @Override
    public int delete(int key) {
        int x = 0;
        try {
            cx = getConexion();
            ps = cx.prepareStatement(SQL_DELETE);
            ps.setInt(1, key);
            x = ps.executeUpdate();
        }catch (Exception e){
            System.out.println("ERROR:"+e);
        }
        return x;
    }

    //====================MÉTODO BUSCAR====================//

    @Override
    public alumno read(int key) {
        alumno dTO = new alumno();
        try {
            cx = getConexion();
            ps = cx.prepareStatement(SQL_READ);
            ps.setInt(1, key);
            rs = ps.executeQuery();
            while (rs.next()){
                dTO.setId(rs.getInt(1));
                dTO.setNombre(rs.getString(2));
                dTO.setApellido(rs.getString(3));
                dTO.setEdad(rs.getInt(4));
                dTO.setSexo(rs.getString(5));
            }
        }catch (Exception e){
            System.out.println("ERROR:"+e);
        }
        return dTO;
    }

    //====================MÉTODO PRINCIPAL LISTAR ====================//
    @Override
    public List<alumno> readAll() {

        List<alumno> lista = new ArrayList<>();
        try {
            cx = getConexion();
            ps = cx.prepareStatement(SQL_REALL);
            rs = ps.executeQuery();
            while (rs.next()){
                alumno dTO = new alumno();
                dTO.setId(rs.getInt(1));
                dTO.setNombre(rs.getString(2));
                dTO.setApellido(rs.getString(3));
                dTO.setEdad(rs.getInt(4));
                dTO.setSexo(rs.getString(5));
                lista.add(dTO);
            }
        }catch (SQLException e) {
            System.out.println("ERROR:" + e);
        }
        return lista;

    }
}
