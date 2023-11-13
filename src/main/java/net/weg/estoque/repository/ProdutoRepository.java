package net.weg.estoque.repository;

import net.weg.estoque.model.Produto;
import net.weg.estoque.model.ProdutoDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Integer> {
    Boolean existsByCodigoDeBarras(Long codigoDeBarra);

}
