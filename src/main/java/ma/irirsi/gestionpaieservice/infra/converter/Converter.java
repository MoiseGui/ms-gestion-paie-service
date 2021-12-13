package ma.irirsi.gestionpaieservice.infra.converter;

import java.util.ArrayList;
import java.util.List;

/*
 * T: Pojo | Dto
 * E : entity
 */
public abstract interface Converter<T, E> {

    public abstract T to(E e);

    public abstract E toItem(T item);


    default List<T> to(List<E> e) {
        if (e == null) {
            return null;
        }
        List<T> list = new ArrayList<>();
        for (E item : e) {
            list.add(to(item));
        }
        return list;
    }

    default List<E> toItem(List<T> items) {
        if (items == null) {
            return null;
        }
        List<E> list = new ArrayList<>();
        for (T item : items) {
            list.add(toItem(item));
        }
        return list;
    }

}
