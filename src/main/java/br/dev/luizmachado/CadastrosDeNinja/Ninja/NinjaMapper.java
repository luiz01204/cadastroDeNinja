package br.dev.luizmachado.CadastrosDeNinja.Ninja;

import br.dev.luizmachado.CadastrosDeNinja.Missao.MissaoMapper;
import br.dev.luizmachado.CadastrosDeNinja.Missao.MissaoModel;
import org.springframework.stereotype.Component;

@Component
public class NinjaMapper {

    public NinjaModel toEntity(NinjaDTO dto) {
        if (dto == null) return null;

        NinjaModel model = new NinjaModel();
        model.setId(dto.getId());
        model.setName(dto.getName());
        model.setEmail(dto.getEmail());
        model.setAge(dto.getAge());
        model.setRank(dto.getRank());

        // Se vier o ID da missão, cria um model só com o ID
        if (dto.getMissaoId() != null) {
            MissaoModel missao = new MissaoModel();
            missao.setId(dto.getMissaoId());
            model.setMissao(missao);
        }

        return model;
    }

    public NinjaDTO toDTO(NinjaModel model) {
        if (model == null) return null;

        NinjaDTO dto = new NinjaDTO();
        dto.setId(model.getId());
        dto.setName(model.getName());
        dto.setEmail(model.getEmail());
        dto.setAge(model.getAge());
        dto.setRank(model.getRank());

        // Inclui o objeto completo da missão no retorno
        if (model.getMissao() != null) {
            dto.setMissaoId(model.getMissao().getId());
            dto.setMissao(MissaoMapper.toDTO(model.getMissao()));
        }

        return dto;
    }
}
