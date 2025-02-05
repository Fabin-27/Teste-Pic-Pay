package com.DesafioPicPay.DesafioPicPay.Servicos;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.DesafioPicPay.DesafioPicPay.Dtos.UsuarioDTO;
import com.DesafioPicPay.DesafioPicPay.dominio.usuarios.TipoUsuario;
import com.DesafioPicPay.DesafioPicPay.dominio.usuarios.Usuario;
import com.DesafioPicPay.DesafioPicPay.dominio.usuarios.tipoUsuario;
import com.DesafioPicPay.DesafioPicPay.repositorios.repositorioUsuario;

@Service
public class ServicoUsuario {

    @Autowired
    private repositorioUsuario repositorio;

    public void validarTransacao(Usuario emissor, BigDecimal valor) throws Exception {

        if (emissor.getTipoDeUsuario() == TipoUsuario.LOJISTA) {

            throw new Exception("Usuario do tipo lojista não esta autorizado a realizar transação!");
        }

        if (emissor.getSaldo().compareTo(valor) < 0) {

            throw new Exception("Saldo Insuficiente!");

        }

    }

    public void salvarUsuario(Usuario usuario){

        this.repositorio.save(usuario);

    }

    public Usuario criarUsuario(UsuarioDTO data){
        Usuario novoUsuario = new Usuario(data);
        this.salvarUsuario(novoUsuario);
                return novoUsuario;
    }

    public Usuario findById(Long id) throws Exception{

        return this.repositorio.findById(id).orElseThrow(() -> new Exception("Usuario não encontrado!"));
    }

    public List<Usuario> ListarTodos(){
        return this.repositorio.findAll();
    }

}
