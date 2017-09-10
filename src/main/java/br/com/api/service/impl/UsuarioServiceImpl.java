package br.com.api.service.impl;

import br.com.api.entity.Usuario;
import br.com.api.repository.UsuarioRepository;
import br.com.api.service.UsuarioService;
import br.com.api.service.exception.ObjectNotFoundException;
import br.com.api.service.exception.UsuarioNaoEncontradoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UsuarioServiceImpl implements UsuarioService{

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public Usuario create(Usuario usuario) {
        return this.usuarioRepository.saveAndFlush(usuario.buildNovoUsuario());
    }

    @Override
    public Usuario update(Usuario usuario) {
        this.verifyIfUsuarioExists(usuario.getId());
        return this.usuarioRepository.saveAndFlush(usuario);
    }

    @Override
    public Usuario findById(Long id) {
        List<ObjectNotFoundException> exceptions = new ArrayList<>();
        Usuario usuario = this.usuarioRepository.findOne(id);
        if(usuario == null){
            exceptions.add(new UsuarioNaoEncontradoException("O usuário não existe, para este id informado."));
        }
        if(!exceptions.isEmpty()){
            throw new ObjectNotFoundException(exceptions);
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
