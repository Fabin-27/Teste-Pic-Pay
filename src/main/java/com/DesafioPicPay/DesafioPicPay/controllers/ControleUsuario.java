package com.DesafioPicPay.DesafioPicPay.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.DesafioPicPay.DesafioPicPay.Dtos.UsuarioDTO;
import com.DesafioPicPay.DesafioPicPay.Servicos.ServicoUsuario;
import com.DesafioPicPay.DesafioPicPay.dominio.usuarios.Usuario;

@RestController()
@RequestMapping("/usuarios")
public class ControleUsuario {

    @Autowired
    private ServicoUsuario ServicoUsuario;

    @PostMapping
    public ResponseEntity<Usuario> criarUsuario(@RequestBody UsuarioDTO usuario){
        Usuario novoUsuario = ServicoUsuario.criarUsuario(usuario);
        return new ResponseEntity<>(novoUsuario, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Usuario>> ListarTodos(){
        List<Usuario> usuarios = this.ServicoUsuario.ListarTodos();
        return new ResponseEntity<>(usuarios, HttpStatus.OK);
    }
        
        
    }

