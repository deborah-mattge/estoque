package net.weg.estoque.service;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import net.weg.estoque.model.Categoria;
import net.weg.estoque.model.CategoriaDTO;
import net.weg.estoque.repository.CategoriaRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CategoriaService {
    private CategoriaRepository categoriaRepository;

    public Categoria buscarUm(Integer id){
        return categoriaRepository.findById(id).get();
    }
    public List<Categoria> buscarTodos(){
        return categoriaRepository.findAll();
    }
    public void deletar(Integer id){
        categoriaRepository.deleteById(id);
    }
    public Categoria cadastrar(CategoriaDTO categoriaDTo){
        Categoria categoria = new Categoria();
        BeanUtils.copyProperties(categoriaDTo, categoria);
        return categoriaRepository.save(categoria);
    }

    public Categoria editar(Categoria categoria) throws Exception {
    if(!(categoriaRepository.existsById(categoria.getId()))){
        throw new Exception("Não há uma categoria com o id "+categoria.getId()+" cadastrado.");
    }
        return categoriaRepository.save(categoria);
    }
}
