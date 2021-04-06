package com.example.projet_web.services.mappers;

public interface IEntityMapper<T, D> {
    public D entityToDTO(T t);
}
