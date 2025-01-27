package br.edu.iftm.tspi.gerenciamento_arquivos.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.iftm.tspi.gerenciamento_arquivos.model.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, UUID> {
    
}