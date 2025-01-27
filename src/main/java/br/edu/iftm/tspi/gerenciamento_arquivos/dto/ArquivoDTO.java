package br.edu.iftm.tspi.gerenciamento_arquivos.dto;

import java.time.LocalDate;
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
    private LocalDate dataUpload;

    private CategoriaDTO categoria;
}
