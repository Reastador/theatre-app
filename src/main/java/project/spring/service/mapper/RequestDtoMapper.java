package project.spring.service.mapper;

public interface RequestDtoMapper<D, T> {
    T mapToModel(D d);
}