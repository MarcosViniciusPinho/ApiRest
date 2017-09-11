package br.com.api.service.impl;

import br.com.api.entity.Usuario;
import br.com.api.repository.UsuarioRepository;
import br.com.api.service.UsuarioService;
import br.com.api.service.exception.ObjectNotFoundException;
import br.com.api.service.exception.UsuarioNaoEncontradoException;
import br.com.api.service.exception.util.ObjectExceptionUtil;
import br.com.api.service.exception.util.ParameterExceptionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UsuarioServiceImpl implements UsuarioService{

    @Autowired
    private UsuarioRepository usuarioRepository;

    /**
     * {@inheritDoc}
     */
    @Override
    public Usuario create(Usuario usuario) {
        return this.usuarioRepository.saveAndFlush(usuario.buildNovoUsuario());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Usuario update(Usuario usuario) {
        ParameterExceptionUtil.validateObjectNull(usuario.getId());
        this.verifyIfUsuarioExists(usuario.getId());
        return this.usuarioRepository.saveAndFlush(usuario);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Usuario findById(Long id) {
        Usuario usuario = this.usuarioRepository.findOne(id);
        this.validate(usuario);
        return usuario;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void delete(Long id) {
        this.verifyIfUsuarioExists(id);
        this.usuarioRepository.delete(id);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Usuario> findAll() {
        return this.usuarioRepository.findAll();
    }

    private void verifyIfUsuarioExists(Long id){
        this.findById(id);
    }

    private void validate(Usuario usuario){
        List<ObjectNotFoundException> exceptions = new ArrayList<>();
        ObjectExceptionUtil.addObjectNotFound(usuario, new UsuarioNaoEncontradoException("O usuário não existe, para este id informado"), exceptions);
        ObjectExceptionUtil.throwObjectNotFound(exceptions);
    }
}
