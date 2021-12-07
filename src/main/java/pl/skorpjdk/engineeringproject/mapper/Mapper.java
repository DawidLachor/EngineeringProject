package pl.skorpjdk.engineeringproject.mapper;

public interface Mapper<T, K> {

    K toDto(T entity);
    T toEntity(K dto);

}
