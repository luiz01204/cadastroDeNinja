package br.dev.luizmachado.CadastrosDeNinja.Ninja;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/ninja")
public class NinjaController {

    @Autowired
    private NinjaService ninjaService;

    @GetMapping("/all")
    public ResponseEntity<List<NinjaDTO>> getAll(){
        List<NinjaDTO> ninjas = ninjaService.getAll();

        if (ninjas.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(ninjas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<NinjaDTO> getById(@PathVariable long id){
        NinjaDTO ninja = ninjaService.getById(id);
        return ResponseEntity.ok(ninja);
    }

    @PostMapping("/create")
    public  ResponseEntity<NinjaDTO> create(@RequestBody NinjaDTO ninjaDTO) throws URISyntaxException {
        NinjaDTO ninja = ninjaService.create(ninjaDTO);
        return ResponseEntity.created(new URI("localhost:8080/ninja/"+ ninja.getId())).build();
    }


    @PutMapping("/{id}")
    public ResponseEntity<NinjaDTO> updateById(@PathVariable long id, @RequestBody NinjaDTO ninjaDTO){
        NinjaDTO ninja = ninjaService.updateById(id, ninjaDTO);
        return ResponseEntity.ok(ninja);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable long id){
        ninjaService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
