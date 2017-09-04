package br.com.rest.service.impl;

import br.com.rest.entity.Usuario;
import br.com.rest.repository.UsuarioRepository;
import br.com.rest.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioServiceImpl implements UsuarioService{

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public Usuario createOrUpdate(Usuario usuario) {
        return this.usuarioRepository.saveAndFlush(usuario);
    }

    @Override
    public Usuario findById(Long id) {
        return this.usuarioRepository.findOne(id);
    }

    @Override
    public void delete(Long id) {
        this.usuarioRepository.delete(id);
    }

    @Override
    public List<Usuario> findAll() {
        return this.usuarioRepository.findAll();
    }
}
