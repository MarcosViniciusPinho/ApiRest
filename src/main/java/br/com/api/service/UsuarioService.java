package br.com.api.service;

import br.com.api.entity.Usuario;
import java.util.List;

public interface UsuarioService {

    /**
     * Cria um usuario
     * @param usuario usuario
     * @return Usuario
     */
    Usuario create(Usuario usuario);

    /**
     * Altera um usuario
     * @param usuario usuario
     * @return Usuario
     */
    Usuario update(Usuario usuario);

    /**
     * Busca um usuario
     * @param id id
     * @return Usuario
     */
    Usuario findById(Long id);

    /**
     * Exclui um usuario
     * @param id id
     */
    void delete(Long id);

    /**
     * Lista os usuarios
     * @return List<Usuario>
     */
    List<Usuario> findAll();

}
