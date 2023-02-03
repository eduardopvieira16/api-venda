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

import br.com.vieira.venda.model.Endereco;
import br.com.vieira.venda.service.EnderecoServiceImpl;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/v1/endereco")
public class EnderecoRest {

	@Autowired
	private EnderecoServiceImpl enderecoService;

	@PostMapping("/new")
	public Endereco inserir(@RequestBody Endereco endereco) throws Exception {
		return enderecoService.adicionarEndereco(endereco);
	}

	@DeleteMapping("/remove/{cod}")
	public Number deletar(@PathVariable("cod") Long cod) throws Exception {
		return enderecoService.deletarEndereco(cod);
	}

	@PutMapping("/edit/{cod}")
	public Number editar(@RequestBody Endereco endereco, @PathVariable("cod") Long cod) throws Exception {
		return enderecoService.editarEndereco(endereco);
	}

	@GetMapping("/all")
	public List<Endereco> listarTudo() throws Exception {
		return enderecoService.listarTodos();
	}

	@GetMapping("/cod/{cod}")
	public Endereco listarPorCod(@PathVariable("cod") Long cod) throws Exception {
		return enderecoService.buscarPorCod(cod);
	}

	@GetMapping("/name/{Endereco}")
	public List<Endereco> listarPorEndereco(@PathVariable("Endereco") String endereco) throws Exception {
		return enderecoService.listarPorEndereco(endereco);
	}

}
