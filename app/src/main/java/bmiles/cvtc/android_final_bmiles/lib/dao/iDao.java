package bmiles.cvtc.android_final_bmiles.lib.dao;

import java.util.List;

public interface iDao<T> {

    T find(long id);
    List<T> find_all();


    T save(T t);
    T update(T t);
    void delete(T t);

}
