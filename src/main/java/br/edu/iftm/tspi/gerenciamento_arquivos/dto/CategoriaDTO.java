package br.edu.iftm.tspi.gerenciamento_arquivos.dto;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoriaDTO {
    private UUID id;
    private String nome;

    public CategoriaDTO convert(CategoriaDTO categoriaDTO){
        return new CategoriaDTO(
            categoriaDTO.getId(),
            categoriaDTO.getNome()
        );
    }

    public CategoriaDTO(String nome) {
        this.nome = nome;
    }
}
