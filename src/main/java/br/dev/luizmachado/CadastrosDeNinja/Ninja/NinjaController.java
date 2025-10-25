package br.dev.luizmachado.CadastrosDeNinja.Ninja;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NinjaController {

    @GetMapping("/welcome")
    public String welcome(){
        return "Bem vindo a API de ninjas!";
    }
}
