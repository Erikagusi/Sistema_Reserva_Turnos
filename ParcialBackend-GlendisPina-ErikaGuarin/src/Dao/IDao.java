package Dao;
import java.util.List;

public interface IDao <T>{
    T registroOdontologo(T t);

    List<T>listaOdontologos();

}