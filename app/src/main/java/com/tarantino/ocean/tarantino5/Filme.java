package com.tarantino.ocean.tarantino5;

import java.io.Serializable;

/**
 * Created by rafael trindade on 22/10/2016.
 */

public class Filme implements Serializable
{
    private String capa, titulo, atores;
    private int ano, duracao;

    public Filme()
    {
    }

    public Filme(String capa, String titulo, String atores, int ano, int duracao) {
        this.capa = capa;
        this.titulo = titulo;
        this.atores = atores;
        this.ano = ano;
        this.duracao = duracao;
    }

    public String getCapa() {
        return capa;
    }

    public void setCapa(String capa) {
        this.capa = capa;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAtores() {
        return atores;
    }

    public void setAtores(String atores) {
        this.atores = atores;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public int getDuracao() {
        return duracao;
    }

    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }
}
