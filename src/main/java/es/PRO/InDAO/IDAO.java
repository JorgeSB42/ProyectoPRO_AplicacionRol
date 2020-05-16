package es.PRO.InDAO;

import java.util.List;

/**
 *
 * @author Jorge
 * @param <T>
 * @param <R>
 */
public interface IDAO<T, R> {

    /* Esta será la interfaz genérica para todos los DAO de la aplicación. 
    En ella tendremos planteadas las funciones básicas de un CRUD*/

    // Crear
    public void insert(T obj);

    // Listar todo
    public List<T> getObj();

    // Listar por código
    public T getObj(R codigo);

    // Actualizar
    public void update(T obj);

    // Borrar
    public void delete(T obj);
}
