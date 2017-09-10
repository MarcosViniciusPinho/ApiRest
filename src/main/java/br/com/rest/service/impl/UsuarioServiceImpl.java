package br.com.rest.service.impl;

import br.com.rest.entity.Usuario;
import br.com.rest.repository.UsuarioRepository;
import br.com.rest.service.UsuarioService;
import br.com.rest.service.exception.UsuarioNaoEncontradoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioServiceImpl implements UsuarioService{

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public Usuario create(Usuario usuario) {
        return this.usuarioRepository.saveAndFlush(usuario.getNovoUsuario());
    }

    @Override
    public Usuario update(Usuario usuario) {
        this.verifyIfUsuarioExists(usuario.getId());
        return this.usuarioRepository.saveAndFlush(usuario);
    }

    @Override
    public Usuario findById(Long id) {
        Usuario usuario = this.usuarioRepository.findOne(id);
        if(usuario == null){
            throw new UsuarioNaoEncontradoException("O usuário não existe, para este id informado.");
        }
        return usuario;
    }

    @Override
    public void delete(Long id) {
        this.verifyIfUsuarioExists(id);
        this.usuarioRepository.delete(id);
    }

    @Override
    public List<Usuario> findAll() {
        return this.usuarioRepository.findAll();
    }

    private void verifyIfUsuarioExists(Long id){
        this.findById(id);
    }
}
