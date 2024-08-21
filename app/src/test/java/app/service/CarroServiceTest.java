package app.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import app.entity.Carro;
import app.entity.Marca;
import app.entity.Proprietario;

@SpringBootTest // contexto do spring aq
public class CarroServiceTest {

	@Autowired
	CarroService carroService;

	@Test
	void cenario01() { //teste de integração (chamada dentro de chamada)
		Carro carro=new Carro();
		carro.setNome("nome carro test");
		carro.setAno(2000);
		Marca marca=new Marca();
		marca.setNome("nome marca test");
		marca.setCnpj("321321321");
		carro.setMarca(marca);
		Proprietario proprietario01=new Proprietario();
		proprietario01.setNome("nome proprietario test 01");
		proprietario01.setIdade(20);
		Proprietario proprietario02=new Proprietario();
		proprietario02.setNome("nome proprietario test 02");
		proprietario02.setIdade(25);
		List<Proprietario> proprietarios=new ArrayList<Proprietario>();
		proprietarios.add(proprietario01);
		proprietarios.add(proprietario02);
		carro.setProprietarios(proprietarios);
		
		String msgRetorno = carroService.save(carro);
		
		assertEquals("Carro salvo com sucesso", msgRetorno);
		//assertThrows(Exception.class, ()->{}); // lambda
	}

}
