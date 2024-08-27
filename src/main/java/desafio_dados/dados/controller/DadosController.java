package desafio_dados.dados.controller;

import desafio_dados.dados.dto.DadosDto;
import desafio_dados.dados.service.DadosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/dados")
public class DadosController {

    @Autowired
    private DadosService dadosService;

    @PostMapping("/lançar")
    public ResponseEntity<Map<String, Object>> lancarDados(@RequestBody DadosDto dadosDto) {
        Map<String, Object> resultado = dadosService.gerarResultado(dadosDto);

        if (resultado.containsKey("erro")) {
            return new ResponseEntity<>(resultado, HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(resultado, HttpStatus.OK);
    }
}
