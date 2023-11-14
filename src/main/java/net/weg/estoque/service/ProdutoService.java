package net.weg.estoque.service;

import lombok.AllArgsConstructor;
import net.weg.estoque.model.Produto;
import net.weg.estoque.model.ProdutoDTO;
import net.weg.estoque.repository.ProdutoRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProdutoService {
    public ProdutoRepository produtoRepository;
     public Produto buscarUm(Integer id){
         return produtoRepository.findById(id).get();

     }
     public List<Produto> buscarTodos(){
        return  produtoRepository.findAll();
     }
     public void deletar(Integer id ){
         produtoRepository.deleteById(id);
     }
     public Produto cadastrar(ProdutoDTO produto) throws Exception {
        if(produtoRepository.existsByCodigoDeBarras(produto.getCodigoDeBarras())){
            throw  new Exception("Um produto com o código de barra: "+ produto.getCodigoDeBarras() + " já existe");
        }
        else if(produto.getPreco()<0){
            throw new Exception( "Preço não pode ser menor que 0!");
        }
         Produto produto1 = new Produto();
         produto1.setEstoque(0);
         BeanUtils.copyProperties(produto,produto1);

        return produtoRepository.save(produto1);
     }

    public Produto editarEstoque(Produto produto, Integer quantAuterarEstoque) throws Exception {
        if(!produtoRepository.existsByCodigoDeBarras(produto.getCodigoDeBarras())){
            throw  new Exception("Um produto com o código de barra: "+ produto.getCodigoDeBarras() + " não existe");
        }
        else if(produto.getPreco()<0){
            throw new Exception( "Preço não pode ser menor que 0!");
        }
        Integer estoque = (produtoRepository.findById(produto.getId()).get()).getEstoque();
        produto.setEstoque(estoque +quantAuterarEstoque);
        if(produto.getEstoque()<0){
            throw  new Exception("Estoque insuficiente! ");
        }

        return produtoRepository.save(produto);
    }

    public Produto editar(Produto produto) throws Exception {
        if(!produtoRepository.existsByCodigoDeBarras(produto.getCodigoDeBarras())){
            throw  new Exception("Um produto com o código de barra: "+ produto.getCodigoDeBarras() + " não existe");
        }
        else if(produto.getPreco()<0){
            throw new Exception( "Preço não pode ser menor que 0!");
        }
        if(produto.getEstoque()<0){
            throw  new Exception("Estoque insuficiente! ");
        }

        return produtoRepository.save(produto);
    }




}
