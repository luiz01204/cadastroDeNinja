package br.dev.luizmachado.CadastrosDeNinja.Missao;

import org.springframework.stereotype.Component;

@Component
public class MissaoMapper {

    public static MissaoDTO toDTO(MissaoModel model) {
        if (model == null) return null;

        MissaoDTO dto = new MissaoDTO();
        dto.setId(model.getId());
        dto.setName(model.getName());
        dto.setNivel(model.getNivel());
        dto.setNinjas(model.getNinjas()); // cuidado com recursão, explico abaixo

        return dto;
    }

    public static MissaoModel toEntity(MissaoDTO dto) {
        if (dto == null) return null;

        MissaoModel model = new MissaoModel();
        model.setId(dto.getId());
        model.setName(dto.getName());
        model.setNivel(dto.getNivel());
        model.setNinjas(dto.getNinjas());

        return model;
    }
}
