package br.dev.luizmachado.CadastrosDeNinja.Missao;

import br.dev.luizmachado.CadastrosDeNinja.Ninja.NinjaModel;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

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

    @OneToMany(mappedBy = "missao")
    private List<NinjaModel> ninjas;
}
