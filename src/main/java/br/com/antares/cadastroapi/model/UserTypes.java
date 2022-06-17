package br.com.antares.cadastroapi.model;

public enum UserTypes {

    ADMINISTRADOR("Administrador", 1),
    APPUSER("Usuário APP", 2);

    private Integer id;

    UserTypes(String tipo, int id) {

    }
}
