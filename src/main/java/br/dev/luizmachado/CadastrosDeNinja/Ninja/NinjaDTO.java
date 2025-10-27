package br.dev.luizmachado.CadastrosDeNinja.Ninja;

import br.dev.luizmachado.CadastrosDeNinja.Missao.MissaoDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NinjaDTO {
    private Long id;
    private String name;
    private String email;
    private int age;
    private String rank;

    // usado na criação/atualização
    private Long missaoId;

    // usado na resposta
    private MissaoDTO missao;
}
