package com.projectminhasfinancas.projectminhasfinancas.service.impl;

import com.projectminhasfinancas.projectminhasfinancas.model.entity.Usuario;
import com.projectminhasfinancas.projectminhasfinancas.repository.UsuarioRepository;
import com.projectminhasfinancas.projectminhasfinancas.service.UsuarioService;
import com.projectminhasfinancas.projectminhasfinancas.service.exception.ErroAutenticacao;
import com.projectminhasfinancas.projectminhasfinancas.service.exception.RegraNegocioException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository repository;

    public UsuarioServiceImpl(UsuarioRepository repository) {
        this.repository = repository;
    }

    @Override
    public Usuario autenticar(String email, String senha) {
        Optional<Usuario> usuario = repository.findByEmail(email);

        if (!usuario.isPresent()){
            throw new ErroAutenticacao("Usuário não encontrado para o e-mail informado.");
        }
        if(!usuario.get().getSenha().equals(senha)){
            throw new ErroAutenticacao("Senha inválida.");
        }
        return usuario.get();
    }


    @Override
    @Transactional
    public Usuario salvarUsuario(Usuario usuario) {
        validarEmail(usuario.getEmail());
        return repository.save(usuario);
    }

    @Override
    public void validarEmail(String email) {
        boolean existe = repository.existsByEmail(email);
        if (existe){
            throw new RegraNegocioException("Já existe um usuário cadastrado com esse e-mail.");
        }
    }
}
