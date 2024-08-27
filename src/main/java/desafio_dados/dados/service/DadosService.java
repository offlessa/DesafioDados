package desafio_dados.dados.service;

import desafio_dados.dados.dto.DadosDto;

import java.util.Map;

public interface DadosService {
    Map<String, Object> gerarResultado(DadosDto dadosDto);
}
