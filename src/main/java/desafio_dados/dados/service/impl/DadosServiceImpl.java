package desafio_dados.dados.service.impl;

import desafio_dados.dados.dto.DadosDto;
import desafio_dados.dados.service.DadosService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@Service
public class DadosServiceImpl implements DadosService {

	private static final Random random = new Random();

	@Override
	public Map<String, Object> gerarResultado(DadosDto dadosDto) {
		int quantidadeDados = dadosDto.getQuantidadeDados();
		double valorAposta = dadosDto.getValorAposta();

		Map<String, Object> resposta = new HashMap<>();

		if (quantidadeDados < 1 || quantidadeDados > 4) {
			resposta.put("erro", "Quantidade de dados deve estar entre 1 e 4.");
			return resposta;
		}
		if (valorAposta < quantidadeDados || valorAposta > 6 * quantidadeDados) {
			resposta.put("erro",
					"Valor da aposta deve estar entre " + quantidadeDados + " e " + 6 * quantidadeDados + ".");
			return resposta;
		}

		int[] valoresDados = new int[quantidadeDados];
		int somaTotal = 0;
		for (int i = 0; i < quantidadeDados; i++) {
			valoresDados[i] = random.nextInt(6) + 1;
			somaTotal += valoresDados[i];
		}

		double percentualAposta = (valorAposta / somaTotal) * 100;

		resposta.put("valoresDados", valoresDados);
		resposta.put("somaTotal", somaTotal);
		resposta.put("percentualAposta", percentualAposta);

		return resposta;
	}
}
