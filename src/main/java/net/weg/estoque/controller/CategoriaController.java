package net.weg.estoque.controller;

import lombok.AllArgsConstructor;
import net.weg.estoque.model.Categoria;
import net.weg.estoque.model.CategoriaDTO;
import net.weg.estoque.service.CategoriaService;
import net.weg.estoque.service.FabricanteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;

@RestController
@RequestMapping("/categoria")
@AllArgsConstructor
public class CategoriaController {
    CategoriaService categoriaService;
    @GetMapping("{id}")
    public ResponseEntity buscarUm(@PathVariable (value = "id")Integer id){
        try {
            return new ResponseEntity<>(categoriaService.buscarUm(id), HttpStatus.OK);
        }catch (NoSuchElementException e){
            return new ResponseEntity(HttpStatus.NOT_FOUND);

        }

    }
    @GetMapping()
    public ResponseEntity buscarTodos(){
        try {
            return new ResponseEntity<>(categoriaService.buscarTodos(), HttpStatus.OK);
        }catch (NoSuchElementException e){
            return new ResponseEntity(HttpStatus.NOT_FOUND);

        }

    }
    @DeleteMapping("{id}")
    public void deletar(@PathVariable (value = "id")Integer id){
        categoriaService.deletar(id);
    }
    @PostMapping()
    public ResponseEntity cadastrar(@RequestBody CategoriaDTO categoriaDTO){
        try{
            return new ResponseEntity<>( categoriaService.cadastrar(categoriaDTO),HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
    }
    @PutMapping()
    public ResponseEntity editar(@RequestBody Categoria categoria){
        try{
            return new ResponseEntity<>( categoriaService.editar(categoria),HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
    }


}
