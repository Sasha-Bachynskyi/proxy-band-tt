package proxyband.testtask.mapper;

public interface ResponseDtoMapper<D, T> {
    D mapToDto(T t);
}
