package ma.irirsi.gestionpaieservice.infra.converter;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.ArrayList;
import java.util.List;

/*
 * T: Pojo | Dto
 * E : entity
 */
public abstract interface AbstractConverter<T, E> {

    AbstractConverter INSTANCE = Mappers.getMapper(AbstractConverter.class);

    public abstract T to(E e);

    public abstract List<T> to(List<E> e);

    public abstract E toItem(T item);

    public abstract List<E> toItem(List<T> items);

}