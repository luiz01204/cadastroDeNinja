package br.dev.luizmachado.CadastrosDeNinja.Ninja;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NinjaRepository extends JpaRepository<NinjaModel,Long> {
}
