package com.mitienda.model;

public enum Categoria {
    ELECTRONICA,
    ROPA,
    LIBROS,
    HOGAR,
    OTRO;

    public static Categoria fromString(String s) {
        if (s == null) return OTRO;
        try {
            return Categoria.valueOf(s.trim().toUpperCase());
        } catch (IllegalArgumentException e) {
            return OTRO;
        }
    }
}
