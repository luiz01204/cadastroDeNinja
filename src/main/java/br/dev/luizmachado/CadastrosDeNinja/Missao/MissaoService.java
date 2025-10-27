package br.dev.luizmachado.CadastrosDeNinja.Missao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MissaoService {

    @Autowired
    private final MissaoRepository missaoRepository;

    public MissaoService(MissaoRepository missaoRepository, MissaoMapper missaoMapper) {
        this.missaoRepository = missaoRepository;
    }

    public List<MissaoDTO> getAll() {
        return missaoRepository.findAll()
                .stream()
                .map(MissaoMapper::toDTO)
                .collect(Collectors.toList());
    }

    public MissaoDTO getById(long id) {
        return missaoRepository.findById(id)
                .map(MissaoMapper::toDTO)
                .orElse(null);
    }

    public MissaoDTO create(MissaoDTO missaoDTO) {
        MissaoModel model = MissaoMapper.toEntity(missaoDTO);
        MissaoModel saved = missaoRepository.save(model);
        return MissaoMapper.toDTO(saved);
    }

    public MissaoDTO updateById(long id, MissaoDTO missaoDTO) {
        return missaoRepository.findById(id)
                .map(existing -> {
                    MissaoModel updatedModel = MissaoMapper.toEntity(missaoDTO);
                    updatedModel.setId(existing.getId());
                    MissaoModel saved = missaoRepository.save(updatedModel);
                    return MissaoMapper.toDTO(saved);
                })
                .orElse(null);
    }

    public void deleteById(long id) {
        missaoRepository.deleteById(id);
    }
}
