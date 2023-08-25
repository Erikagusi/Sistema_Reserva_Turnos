package Dao;
import java.util.List;

public interface IDao <T>{
    T guardar(T t);
    T buscar (Integer id);
    void eliminar (Integer id);
    void actualizar(T t);

    List<T>listarTodos();

}