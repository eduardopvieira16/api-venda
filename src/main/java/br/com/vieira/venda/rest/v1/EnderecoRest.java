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
		try {
			return enderecoService.adicionarEndereco(endereco);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@DeleteMapping("/remove/{cod}")
	public Number deletar(@PathVariable("cod") Long cod) throws Exception {
		try {
			return enderecoService.deletarEndereco(cod);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@PutMapping("/edit/{cod}")
	public Number editar(@RequestBody Endereco endereco, @PathVariable("cod") Long cod) throws Exception {
		try {
			return enderecoService.editarEndereco(endereco);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@GetMapping("/all")
	public List<Endereco> listarTudo() throws Exception {
		try {
			return enderecoService.listarTodos();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@GetMapping("/cod/{cod}")
	public Endereco listarPorCod(@PathVariable("cod") Long cod) throws Exception {
		try {
			return enderecoService.buscarPorCod(cod);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@GetMapping("/name/{Endereco}")
	public List<Endereco> listarPorEndereco(@PathVariable("Endereco") String endereco) throws Exception {
		try {
			return enderecoService.listarPorEndereco(endereco);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
