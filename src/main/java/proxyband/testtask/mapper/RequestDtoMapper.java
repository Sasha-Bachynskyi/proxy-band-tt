package proxyband.testtask.mapper;

public interface RequestDtoMapper<D, T> {
    T mapToModel(D dto);
}
