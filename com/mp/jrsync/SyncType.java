package com.mp.jrsync;

/**
 *
 * @author Matteo Ferrone
 */
public class SyncType {

    private String nome;
    private String comando;

    public SyncType(String nome, String comando) {
        this.nome = nome;
        this.comando = comando;
    }

    public String getNome() {
        return nome;
    }

    public String getComando() {
        return comando;
    }

    @Override
    public String toString() {
        return nome;
    }
}
