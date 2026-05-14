package com.example.ExercicioAlunoGamer.AlunoGamerController;

import com.example.ExercicioAlunoGamer.AlunoGamerModel.UsuarioGamer;
import com.example.ExercicioAlunoGamer.AlunoGamerService.UsuarioGamerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
@RequiredArgsConstructor

public class UsuarioGamerController {

    private final UsuarioGamerService service;

    @GetMapping
    public List<UsuarioGamer> listar(){

        return service.listar();
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioGamer> BuscarporId(@PathVariable Long id){
        return ResponseEntity.ok(service.BuscarporId(id));
    }

    @PostMapping
    public ResponseEntity<UsuarioGamer> salvar(@RequestBody UsuarioGamer usuarios){
        return ResponseEntity.ok(service.salvar(usuarios));
    }

    @PutMapping("/{id}")
    public ResponseEntity<UsuarioGamer> atualizar(@PathVariable Long id, @RequestBody UsuarioGamer usuarios){
        return ResponseEntity.ok(service.atualizar(id, usuarios));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<UsuarioGamer> excluir(@PathVariable Long id){
        service.excluir(id);
        return ResponseEntity.noContent().build();
    }
}