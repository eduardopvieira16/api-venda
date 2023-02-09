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

import br.com.vieira.venda.model.Pessoa;
import br.com.vieira.venda.service.PessoaServiceImpl;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/v1/pessoa")
public class PessoaRest {

	@Autowired
	private PessoaServiceImpl pessoaService;

	@PostMapping("/new")
	public Pessoa inserir(@RequestBody Pessoa pessoa) throws Exception {
		try {
			return pessoaService.adicionarPessoa(pessoa);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@DeleteMapping("/remove/{cod}")
	public Number deletar(@PathVariable("cod") Long cod) throws Exception {
		try {
			return pessoaService.deletarPessoa(cod);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@PutMapping("/edit/{cod}")
	public Number editar(@RequestBody Pessoa pessoa, @PathVariable("cod") Long cod) throws Exception {
		try {
			return pessoaService.editarPessoa(pessoa);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@GetMapping("/all")
	public List<Pessoa> listarTudo() throws Exception {
		try {
			return pessoaService.listarTodos();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@GetMapping("/cod/{cod}")
	public Pessoa listarPorCod(@PathVariable("cod") Long cod) throws Exception {
		try {
			return pessoaService.buscarPorCod(cod);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@GetMapping("/name/{Pessoa}")
	public List<Pessoa> listarPorPessoa(@PathVariable("Pessoa") String pessoa) throws Exception {
		try {
			return pessoaService.listarPorPessoa(pessoa);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
