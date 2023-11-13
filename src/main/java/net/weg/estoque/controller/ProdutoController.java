package net.weg.estoque.controller;

import lombok.AllArgsConstructor;
import net.weg.estoque.model.Produto;
import net.weg.estoque.model.ProdutoDTO;
import net.weg.estoque.service.ProdutoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;

@RestController
@RequestMapping("/produto")
@AllArgsConstructor
public class ProdutoController {
    ProdutoService produtoService ;
    @GetMapping("/{id}")
    public ResponseEntity buscarUm(@PathVariable (value = "id")Integer id){
        try{
            return new ResponseEntity<>(produtoService.buscarUm(id), HttpStatus.OK);

        }catch (NoSuchElementException e){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping()
    public ResponseEntity buscarTodos(){
        try{
            return new ResponseEntity<>(produtoService.buscarTodos(), HttpStatus.OK);

        }catch (NoSuchElementException e){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("{id}")
    public  void remover(@PathVariable (value = "id")Integer id){
          produtoService.deletar(id);
    }
    @PostMapping
    public ResponseEntity cadastrar(@RequestBody Produto produto){
        try{
           return new ResponseEntity<>( produtoService.cadastrar(produto),HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }

    }
    @PutMapping("{altEstoque}")
    public ResponseEntity editar(@RequestBody ProdutoDTO produto, @PathVariable (value ="altEstoque")Integer altEstoque){
        try{
            return new ResponseEntity<>( produtoService.editar(produto,altEstoque),HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
