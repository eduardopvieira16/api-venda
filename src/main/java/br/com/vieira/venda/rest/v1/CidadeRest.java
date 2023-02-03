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
		return cidadeService.adicionarCidade(cidade);
	}

	@DeleteMapping("/remove/{cod}")
	public Number deletar(@PathVariable("cod") Long cod) throws Exception {
		return cidadeService.deletarCidade(cod);
	}

	@PutMapping("/edit/{cod}")
	public Number editar(@RequestBody Cidade cidade, @PathVariable("cod") Long cod) throws Exception {
		return cidadeService.editarCidade(cidade);
	}

	@GetMapping("/all")
	public List<Cidade> listarTudo() throws Exception {
		return cidadeService.listarTodos();
	}

	@GetMapping("/cod/{cod}")
	public Cidade listarPorCod(@PathVariable("cod") Long cod) throws Exception {
		return cidadeService.buscarPorCod(cod);
	}

	@GetMapping("/name/{cidade}")
	public List<Cidade> listarPorcidade(@PathVariable("cidade") String cidade) throws Exception {
		return cidadeService.listarPorCidade(cidade);
	}

}
