package br.com.rest.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
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

    @NotBlank(message = "Login obrigatório")
    @Size(max = 50, message = "Login pode conter no máximo 50 caracteres")
    @Column(name = "login", length = 50, nullable = false)
    private String login;

    @NotBlank(message = "Senha obrigatório")
    @Size(max = 10, message = "Senha pode conter no máximo 10 caracteres")
    @Column(name = "senha", length = 255, nullable = false)
    private String senha;

    @NotBlank(message = "Nome obrigatório")
    @Size(max = 50, message = "Nome pode conter no máximo 50 caracteres")
    @Column(name = "nome", length = 50, nullable = false)
    private String nome;

    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    @Size(max = 50, message = "Sobrenome pode conter no máximo 50 caracteres")
    @Column(name = "sobrenome", length = 50)
    private String sobrenome;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

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

    public Usuario getNovoUsuario(){
        this.setId(null);
        return this;
    }

}
