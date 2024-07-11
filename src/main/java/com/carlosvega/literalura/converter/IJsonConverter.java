package com.carlosvega.literalura.converter;

public interface IJsonConverter {
    <T> T obtenerDatos(String json, Class<T> clase);
}
