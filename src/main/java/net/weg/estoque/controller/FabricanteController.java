package net.weg.estoque.controller;

import lombok.AllArgsConstructor;
import net.weg.estoque.model.Categoria;
import net.weg.estoque.model.CategoriaDTO;
import net.weg.estoque.model.Fabricante;
import net.weg.estoque.model.FabricanteDTO;
import net.weg.estoque.service.FabricanteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;

@RestController
@RequestMapping("/fabricante")
@AllArgsConstructor
public class FabricanteController {
    FabricanteService fabricanteService;
    @GetMapping("{id}")
    public ResponseEntity buscarUm(@PathVariable(value = "id")Integer id){
        try {
            return new ResponseEntity<>(fabricanteService.buscarUm(id), HttpStatus.OK);
        }catch (NoSuchElementException e){
            return new ResponseEntity(HttpStatus.NOT_FOUND);

        }

    }
    @GetMapping()
    public ResponseEntity buscarTodos(){
        try {
            return new ResponseEntity<>(fabricanteService.buscarTodos(), HttpStatus.OK);
        }catch (NoSuchElementException e){
            return new ResponseEntity(HttpStatus.NOT_FOUND);

        }

    }
    @DeleteMapping("{id}")
    public void deletar(@PathVariable (value = "id")Integer id){
        fabricanteService.deletar(id);
    }
    @PostMapping()
    public ResponseEntity cadastrar(@RequestBody FabricanteDTO fabricanteDTO){
        try{
            return new ResponseEntity<>( fabricanteService.cadastrar(fabricanteDTO),HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
    }
    @PutMapping()
    public ResponseEntity editar(@RequestBody Fabricante fabricante){
        try{
            return new ResponseEntity<>( fabricanteService.editar(fabricante),HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
    }
}
