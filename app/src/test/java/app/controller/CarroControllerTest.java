package app.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import app.entity.Carro;
import app.repository.CarroRepository;

@SpringBootTest
public class CarroControllerTest {

	@Autowired
	CarroController carroController;

	@MockBean // ta indicando que o obj vai ter config de mock
	CarroRepository carroRepository;

	@BeforeEach // executado antes de cada teste
	void setup() { // convençao usar nome setup
		// ta consultando banco, ai precisa mocar o repository.., mas nem todo teste de integracao precisa de mock
		// quem ta consultando o banco? a classe repository, mocar ela entao
		List<Carro> carros = new ArrayList<Carro>();
		carros.add(new Carro());
		carros.add(new Carro());
		carros.add(new Carro());
		
		// quando esse metodo for chamado n vai no banco e retorna essa lista
		when(carroRepository.findAll()).thenReturn(carros);
		//usar mais mocks aqui conforme necessidade pra capturar
	}

	@Test
	void cenario01() { // teste de integração; conversa entre metodos/classes
		ResponseEntity<List<Carro>> retorno = carroController.findAll();
		assertEquals(HttpStatus.OK, retorno.getStatusCode());
	}

	@Test
	void cenario02() {
		ResponseEntity<List<Carro>> retorno = carroController.findAll();
		assertEquals(3, retorno.getBody().size());
	}

}
