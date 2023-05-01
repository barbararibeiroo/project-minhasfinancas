package com.projectminhasfinancas.projectminhasfinancas.service;

import com.projectminhasfinancas.projectminhasfinancas.model.entity.Usuario;

public interface UsuarioService {

    Usuario autenticar(String email, String senha);

    Usuario salvarUsuario(Usuario usuario);

    void validarEmail(String email);


}
