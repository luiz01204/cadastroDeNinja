package br.dev.luizmachado.CadastrosDeNinja.Ninja;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class NinjaService {

    private final NinjaRepository ninjaRepository;
    private final NinjaMapper ninjaMapper;

    public NinjaService(NinjaRepository ninjaRepository, NinjaMapper ninjaMapper) {
        this.ninjaRepository = ninjaRepository;
        this.ninjaMapper = ninjaMapper;
    }

    public List<NinjaDTO> getAll() {
        List<NinjaModel> ninjas = ninjaRepository.findAll();
        return ninjas.stream()
                .map(ninjaMapper::toDTO)
                .collect(Collectors.toList());
    }

    public NinjaDTO getById(long id) {
        Optional<NinjaModel> ninjaModel = ninjaRepository.findById(id);
        return ninjaModel.map(ninjaMapper::toDTO).orElse(null);
    }

    public NinjaDTO create(NinjaDTO ninjaDTO) {
        NinjaModel model = ninjaMapper.toEntity(ninjaDTO);
        NinjaModel saved = ninjaRepository.save(model);
        return ninjaMapper.toDTO(saved);
    }

    public NinjaDTO updateById(long id, NinjaDTO ninjaDTO) {
        return ninjaRepository.findById(id)
                .map(existingNinja -> {
                    NinjaModel updated = ninjaMapper.toEntity(ninjaDTO);
                    updated.setId(existingNinja.getId());
                    NinjaModel saved = ninjaRepository.save(updated);
                    return ninjaMapper.toDTO(saved);
                })
                .orElse(null);
    }

    public void deleteById(long id) {
        ninjaRepository.deleteById(id);
    }
}
