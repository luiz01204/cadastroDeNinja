package br.dev.luizmachado.CadastrosDeNinja.Missao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/mission")
public class MissaoController {

    @Autowired
    private MissaoService missaoService;

    @GetMapping("/all")
    public ResponseEntity<List<MissaoDTO>> getAll() {
        List<MissaoDTO> missions = missaoService.getAll();
        return ResponseEntity.ok(missions);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MissaoDTO> getById(@PathVariable long id) {
        MissaoDTO mission = missaoService.getById(id);
        return ResponseEntity.ok(mission);
    }

    @PostMapping("/create")
    public ResponseEntity<MissaoDTO> create(@RequestBody MissaoDTO missaoDTO) {
        MissaoDTO created = missaoService.create(missaoDTO);
        return ResponseEntity.ok(created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MissaoDTO> updateById(@PathVariable long id, @RequestBody MissaoDTO missaoDTO) {
        MissaoDTO updated = missaoService.updateById(id, missaoDTO);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable long id) {
        missaoService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
