package br.com.rest.service;

import br.com.rest.entity.Usuario;
import java.util.List;

public interface UsuarioService {

    /**
     * Cria ou altera um usuario
     * @param usuario usuario
     * @return Usuario
     */
    Usuario createOrUpdate(Usuario usuario);

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
