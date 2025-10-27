package br.dev.luizmachado.CadastrosDeNinja.Ninja;

import br.dev.luizmachado.CadastrosDeNinja.Missao.MissaoModel;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tb_cadastro")
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString()
public class NinjaModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome_ninja")
    private String name;

    @Column(name = "email_ninja", unique = true)
    private String email;

    @Column(name = "idade_ninja")
    private int age;

    @Column(name = "rank_ninja")
    private String rank;

    @ManyToOne
    @JoinColumn(name = "missao_id")
    private MissaoModel missao;
}
