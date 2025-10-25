package br.dev.luizmachado.CadastrosDeNinja.Missao;

import br.dev.luizmachado.CadastrosDeNinja.Ninja.NinjaModel;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tb_missoes")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class MissaoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "Nome_missao")
    private String name;

    @Column(name = "nivel_missao")
    private String nivel;

    @Column(name = "ninja_encarregado")
    @OneToMany(mappedBy = "missao_ativa")
    private NinjaModel ninja;
}
