package br.com.vieira.venda.rest.v1;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.vieira.venda.model.Cidade;
import br.com.vieira.venda.service.CidadeServiceImpl;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/v1/cidade")
public class CidadeRest {

	@Autowired
	private CidadeServiceImpl cidadeService;

	@PostMapping("/new")
	public Cidade inserir(@RequestBody Cidade cidade) throws Exception {
		try {
			return cidadeService.adicionarCidade(cidade);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@DeleteMapping("/remove/{cod}")
	public Number deletar(@PathVariable("cod") Long cod) throws Exception {
		try {
			return cidadeService.deletarCidade(cod);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@PutMapping("/edit/{cod}")
	public Number editar(@RequestBody Cidade Cidade, @PathVariable("cod") Long cod) throws Exception {
		try {
			return cidadeService.editarCidade(Cidade);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@GetMapping("/all")
	public List<Cidade> listarTudo() throws Exception {
		try {
			return cidadeService.listarTodos();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@GetMapping("/cod/{cod}")
	public Cidade listarPorCod(@PathVariable("cod") Long cod) throws Exception {
		try {
			return cidadeService.buscarPorCod(cod);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@GetMapping("/name/{Cidade}")
	public List<Cidade> listarPorCidade(@PathVariable("Cidade") String Cidade) throws Exception {
		try {
			return cidadeService.listarPorCidade(Cidade);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
