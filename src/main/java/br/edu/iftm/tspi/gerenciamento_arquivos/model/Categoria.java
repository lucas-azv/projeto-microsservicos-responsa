package br.edu.iftm.tspi.gerenciamento_arquivos.model;

import java.util.UUID;

import org.springframework.data.mongodb.core.mapping.Field;

import br.edu.iftm.tspi.gerenciamento_arquivos.dto.CategoriaDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Field("nome")
    private String nome;

    public static Categoria convert(CategoriaDTO categoriaDTO){
        return new Categoria(
            categoriaDTO.getId(),
            categoriaDTO.getNome()
        );
    }
}
