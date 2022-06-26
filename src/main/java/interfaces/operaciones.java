package interfaces;

import java.sql.PreparedStatement;
import java.util.List;

public interface operaciones <T>{

    public int create (T t);
    public int update (T t);
    public int delete (int key);
    public T read(int id);
    public List<T> readAll();

}
