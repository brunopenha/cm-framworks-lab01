/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cm.java.jpa.inicial;

import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author escm
 */
@Entity
public class Livro {
    
    @Id
     @GeneratedValue(strategy = GenerationType.AUTO)
    private Long chavePrimaria;
    private String titulo;
    private Float preco;
    private String descricao;
    private String isbn;
    private Integer nroDePaginas;
    private Boolean ilustracao;
    
    public Livro(){
        
    }

    public Long getChavePrimaria() {
        return chavePrimaria;
    }

    public void setChavePrimaria(Long chavePrimaria) {
        this.chavePrimaria = chavePrimaria;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Float getPreco() {
        return preco;
    }

    public void setPreco(Float preco) {
        this.preco = preco;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Integer getNroDePaginas() {
        return nroDePaginas;
    }

    public void setNroDePaginas(Integer nroDePaginas) {
        this.nroDePaginas = nroDePaginas;
    }

    public Boolean isIlustracao() {
        return ilustracao;
    }

    public void setIlustracao(Boolean ilustracao) {
        this.ilustracao = ilustracao;
    }
    
    

    
}
