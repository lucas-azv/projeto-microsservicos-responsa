package br.edu.iftm.tspi.gerenciamento_arquivos.sevice;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.iftm.tspi.gerenciamento_arquivos.dto.ArquivoDTO;
import br.edu.iftm.tspi.gerenciamento_arquivos.dto.CategoriaDTO;
import br.edu.iftm.tspi.gerenciamento_arquivos.model.Arquivo;
import br.edu.iftm.tspi.gerenciamento_arquivos.model.Categoria;
import br.edu.iftm.tspi.gerenciamento_arquivos.repository.ArquivoRepository;
import br.edu.iftm.tspi.gerenciamento_arquivos.repository.CategoriaRepository;
import jakarta.persistence.EntityNotFoundException;

@Service
public class ArquivoService {

    @Autowired
    private ArquivoRepository arquivoRepository;

    @Autowired
    private CategoriaRepository categoriaRepository;

    public List<ArquivoDTO> findAll() {
        return arquivoRepository.findAll().stream()
                .map(Arquivo::convert)
                .map(arquivo -> new ArquivoDTO(
                        arquivo.getId(),
                        arquivo.getNome(),
                        arquivo.getDescricao(),
                        arquivo.getLink(),
                        arquivo.getTipo(),
                        arquivo.getDataUpload(),
                        CategoriaDTO.convert(arquivo.getCategoria())))
                .toList();
    }

    public ArquivoDTO findById(UUID id) {
        Arquivo arquivo = arquivoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Arquivo não encontrado com ID: " + id));
        return Arquivo.convert(arquivo);
    }

    public ArquivoDTO create(ArquivoDTO arquivoDTO) {
        Categoria categoria = categoriaRepository.findById(arquivoDTO.getCategoria().getId())
                .orElseThrow(() -> new EntityNotFoundException(
                        "Categoria não encontrada com ID: " + arquivoDTO.getCategoria().getId()));

        Arquivo arquivo = Arquivo.convert(arquivoDTO);
        arquivo.setCategoria(categoria);
        arquivo = arquivoRepository.save(arquivo);
        return Arquivo.convert(arquivo);
    }

    public ArquivoDTO update(UUID id, ArquivoDTO arquivoDTO) {
        Arquivo arquivo = arquivoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Arquivo não encontrado com ID: " + id));

        Categoria categoria = categoriaRepository.findById(arquivoDTO.getCategoria().getId())
                .orElseThrow(() -> new EntityNotFoundException(
                        "Categoria não encontrada com ID: " + arquivoDTO.getCategoria().getId()));

        arquivo.setNome(arquivoDTO.getNome());
        arquivo.setDescricao(arquivoDTO.getDescricao());
        arquivo.setLink(arquivoDTO.getLink());
        arquivo.setTipo(arquivoDTO.getTipo());
        arquivo.setDataUpload(arquivoDTO.getDataUpload());
        arquivo.setCategoria(categoria);

        arquivo = arquivoRepository.save(arquivo);
        return Arquivo.convert(arquivo);
    }

    public void delete(UUID id) {
        if (!arquivoRepository.existsById(id)) {
            throw new EntityNotFoundException("Arquivo não encontrado com ID: " + id);
        }
        arquivoRepository.deleteById(id);
    }
}
