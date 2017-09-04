package br.com.rest.resource;

import br.com.rest.entity.Usuario;
import br.com.rest.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioResource {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping
    public ResponseEntity<Usuario> create(@RequestBody Usuario usuario){
        return new ResponseEntity<>(this.usuarioService.createOrUpdate(usuario), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Usuario> update(@RequestBody Usuario usuario){
        return new ResponseEntity<>(this.usuarioService.createOrUpdate(usuario), HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Usuario> findById(@PathVariable(value = "id") Long id){
        Usuario usuario = this.usuarioService.findById(id);
        return usuario != null ? new ResponseEntity<>(this.usuarioService.findById(id), HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable(value = "id") Long id){
        Usuario usuario = this.usuarioService.findById(id);
        if(usuario == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        this.usuarioService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Usuario>> findAll(){
        return new ResponseEntity<>(this.usuarioService.findAll(), HttpStatus.OK);
    }

}
