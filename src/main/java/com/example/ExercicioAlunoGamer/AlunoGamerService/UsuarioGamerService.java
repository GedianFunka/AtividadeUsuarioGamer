package com.example.ExercicioAlunoGamer.AlunoGamerService;

import com.example.ExercicioAlunoGamer.AlunoGamerModel.UsuarioGamer;
import com.example.ExercicioAlunoGamer.AlunoGamerRepository.UsuarioGamerRepositorio;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor

public class UsuarioGamerService {

    private final UsuarioGamerRepositorio repositorio;

    public List <UsuarioGamer> listar(){
        return repositorio.findAll();
    }

    public UsuarioGamer BuscarporId(Long id){
        return repositorio.findById(id).orElseThrow(() -> new RuntimeException("Usuario gamer não encontrado"));
    }

    public UsuarioGamer salvar(UsuarioGamer usuarios){
        return repositorio.save(usuarios);
    }

    public UsuarioGamer atualizar (Long id, UsuarioGamer dados){
         UsuarioGamer usuarios = BuscarporId(id);
         usuarios.setNickname(dados.getNickname());
         usuarios.setNivel(dados.getNivel());
         usuarios.setEmail(dados.getEmail());
         usuarios.setJogoFavorito(dados.getJogoFavorito());
         return repositorio.save(usuarios);
    }
    public void excluir(Long id){
        repositorio.deleteById(id);
    }
}


