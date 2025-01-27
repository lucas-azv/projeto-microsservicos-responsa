package br.edu.iftm.tspi.gerenciamento_arquivos.dto;

import java.time.LocalDateTime;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ArquivoDTO {
    private UUID id;
    private String nome;
    private String descricao;
    private String link;
    private String tipo;
    private LocalDateTime dataUpload;

    private CategoriaDTO categoria;

    public CategoriaDTO convert(CategoriaDTO categoriaDTO){
        return new CategoriaDTO(
            categoriaDTO.getId(),
            categoriaDTO.getNome()
        );
    }
}
