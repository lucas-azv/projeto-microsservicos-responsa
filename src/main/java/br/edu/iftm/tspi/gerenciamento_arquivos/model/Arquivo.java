package br.edu.iftm.tspi.gerenciamento_arquivos.model;

import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.data.mongodb.core.mapping.Field;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Arquivo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Field("nome")
    private String nome;

    @Field("descricao")
    private String descricao;

    @Field("link")
    private String link;

    @Field("tipo")
    private String tipo;

    @Field("data_upload")
    private LocalDateTime dataUpload;

    @ManyToOne
    @JoinColumn(name = "categoria_id", nullable = false)
    @Field("categoria_id")
    private Categoria categoria;
}
