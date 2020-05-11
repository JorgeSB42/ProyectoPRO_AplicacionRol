package es.PRO.InDAO;

import java.util.List;

/**
 *
 * @author Jorge
 * @param <T>
 * @param <R>
 */
public interface IDAO <T,R> {
    
    // crear
    public void insert(T obj);
    
    public List<T> getObj();
    
    public T getObj(R codigo);
    
    // Actualizar
    public void update(T obj);
    
    // Borrar
    public void delete(T obj);
    
}
