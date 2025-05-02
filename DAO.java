
package za.ac.tut.bl;

import java.util.List;


public interface DAO<T> {
    
    T get(Integer code);
    List<T> getAll();
    boolean add(T t);
    boolean update(T t);
    boolean delete(T t);
    
    
}
