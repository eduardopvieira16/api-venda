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

import br.com.vieira.venda.model.Unidade;
import br.com.vieira.venda.service.UnidadeServiceImpl;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/v1/unidade")
public class UnidadeRest {

	@Autowired
	private UnidadeServiceImpl unidadeService;

	@PostMapping("/new")
	public Unidade inserir(@RequestBody Unidade unidade) throws Exception {
		return unidadeService.adicionarUnidade(unidade);
	}

	@DeleteMapping("/remove/{cod}")
	public Number deletar(@PathVariable("cod") Long cod) throws Exception {
		return unidadeService.deletarUnidade(cod);
	}

	@PutMapping("/edit/{cod}")
	public Number editar(@RequestBody Unidade unidade, @PathVariable("cod") Long cod) throws Exception {
		return unidadeService.editarUnidade(unidade);
	}

	@GetMapping("/all")
	public List<Unidade> listarTudo() throws Exception {
		return unidadeService.listarTodos();
	}

	@GetMapping("/cod/{cod}")
	public Unidade listarPorCod(@PathVariable("cod") Long cod) throws Exception {
		return unidadeService.buscarPorCod(cod);
	}

	@GetMapping("/name/{Unidade}")
	public List<Unidade> listarPorUnidade(@PathVariable("unidade") String unidade) throws Exception {
		return unidadeService.listarPorUnidade(unidade);
	}

}
