package net.weg.estoque.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column (nullable = false)
    private String nome;
    private Double preco;
    private  Integer estoque;
    private String data;
    private String descricao;
    private Long codigoDeBarras;
    private  Double peso;
    private  Double medida;
    private  String fabricante;
    private String categoria;


}
