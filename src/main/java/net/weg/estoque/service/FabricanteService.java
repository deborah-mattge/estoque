package net.weg.estoque.service;

import lombok.AllArgsConstructor;
import net.weg.estoque.model.Categoria;
import net.weg.estoque.model.Fabricante;
import net.weg.estoque.model.FabricanteDTO;
import net.weg.estoque.repository.FabricanteRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class FabricanteService {
    FabricanteRepository fabricanteRepository;
    public Fabricante buscarUm(Integer id){
       return fabricanteRepository.findById(id).get();

    }
    public List<Fabricante> buscarTodos(){
        return fabricanteRepository.findAll();
    }
    public void deletar(Integer id){
        fabricanteRepository.deleteById(id);
    }
    public Fabricante cadastrar(FabricanteDTO fabricanteDTO){
        Fabricante fabricante = new Fabricante();
        BeanUtils.copyProperties(fabricanteDTO,fabricante);
        return fabricanteRepository.save(fabricante);
    }
    public Fabricante editar(Fabricante fabricante) throws Exception {
        if(!(fabricanteRepository.existsById(fabricante.getId()))){
            throw new Exception("Não há uma categoria com o id "+fabricante.getId()+" cadastrado.");
        }
       return fabricanteRepository.save(fabricante);
    }

}
