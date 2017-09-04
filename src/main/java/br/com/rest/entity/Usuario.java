package br.com.rest.entity;


import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * Classe que representa a tabela usuario no banco de dados.
 */
@Entity
@Table(name = "usuario")
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @NotBlank(message = "Nome obrigatório")
    @Size(max = 50, message = "Nome pode conter no máximo 50 caracteres")
    @Column(name = "nome", length = 50, nullable = false)
    private String nome;

    @NotBlank(message = "Sobrenome obrigatório")
    @Size(max = 50, message = "Sobrenome pode conter no máximo 50 caracteres")
    @Column(name = "sobrenome", length = 50, nullable = false)
    private String sobrenome;

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

}
