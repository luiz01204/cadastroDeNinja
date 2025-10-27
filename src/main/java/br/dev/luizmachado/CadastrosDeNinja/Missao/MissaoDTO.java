package br.dev.luizmachado.CadastrosDeNinja.Missao;

import br.dev.luizmachado.CadastrosDeNinja.Ninja.NinjaModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MissaoDTO {
    private Long id;
    private String name;
    private String nivel;
    private List<NinjaModel> ninjas;
}
