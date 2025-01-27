package br.edu.iftm.tspi.gerenciamento_arquivos.sevice;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.iftm.tspi.gerenciamento_arquivos.dto.CategoriaDTO;
import br.edu.iftm.tspi.gerenciamento_arquivos.model.Categoria;
import br.edu.iftm.tspi.gerenciamento_arquivos.repository.CategoriaRepository;
import jakarta.persistence.EntityNotFoundException;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    public List<CategoriaDTO> findAll() {
        return categoriaRepository.findAll().stream()
                .map(CategoriaDTO::new)
                .toList();
    }

    public CategoriaDTO findById(UUID id) {
        Categoria categoria = categoriaRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Categoria não encontrada com ID: " + id));
        return new CategoriaDTO(categoria.getId(), categoria.getNome());
    }

    public CategoriaDTO create(CategoriaDTO categoriaDTO) {
        Categoria categoria = Categoria.convert(categoriaDTO);
        categoria = categoriaRepository.save(categoria);
        return new CategoriaDTO(categoria.getId(), categoria.getNome());
    }

    public CategoriaDTO update(UUID id, CategoriaDTO categoriaDTO) {
        Categoria categoria = categoriaRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Categoria não encontrada com ID: " + id));
        categoria.setNome(categoriaDTO.getNome());
        categoria = categoriaRepository.save(categoria);
        return new CategoriaDTO(categoria.getId(), categoria.getNome());
    }

    public void delete(UUID id) {
        if (!categoriaRepository.existsById(id)) {
            throw new EntityNotFoundException("Categoria não encontrada com ID: " + id);
        }
        categoriaRepository.deleteById(id);
    }
}
