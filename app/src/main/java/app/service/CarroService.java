package app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.entity.Carro;
import app.entity.Marca;
import app.repository.CarroRepository;

@Service
public class CarroService {

	@Autowired
	private CarroRepository carroRepository;

	public String save(Carro carro) {
		this.carroRepository.save(carro);
		return "Carro salvo com sucesso";
	}

	public String update(Carro carro, Long id) {
		carro.setId(id);
		this.carroRepository.save(carro);
		return "Carro atualizado com sucesso";
	}

	public String delete(Long id) {
		this.carroRepository.deleteById(id);
		return "Carro deletado com sucesso";
	}

	public List<Carro> findAll() {
		return this.carroRepository.findAll();
	}

	public Carro findById(Long id) {
		return this.carroRepository.findById(id).get();
	}

	public List<Carro> findByNome(String nome) {
		return this.carroRepository.findByNome(nome);
	}

	public List<Carro> findByMarca(Long idMarca) {
		Marca marca=new Marca();
		marca.setId(idMarca);
		return this.carroRepository.findByMarca(marca);
	}

	public List<Carro> findAcimaAno(int ano) {
		return this.carroRepository.findAcimaAno(ano);
	}
	
}
