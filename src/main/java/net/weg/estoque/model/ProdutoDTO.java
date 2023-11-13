package net.weg.estoque.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProdutoDTO  {
    private Integer id;
    private String nome;
    private Double preco;

    private String data;
    private String descricao;
    private Long codigoDeBarras;
    private  Double peso;
    private  Double medida;
    private  String fabricante;
    private String categoria;
}
