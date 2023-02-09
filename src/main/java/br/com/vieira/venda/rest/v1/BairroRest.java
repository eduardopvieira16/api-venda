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

import br.com.vieira.venda.model.Bairro;
import br.com.vieira.venda.service.BairroServiceImpl;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/v1/bairro")
public class BairroRest {

	@Autowired
	private BairroServiceImpl bairroService;

	@PostMapping("/new")
	public Bairro inserir(@RequestBody Bairro bairro) throws Exception {
		try {
			return bairroService.adicionarBairro(bairro);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@DeleteMapping("/remove/{cod}")
	public Number deletar(@PathVariable("cod") Long cod) throws Exception {
		try {
			return bairroService.deletarBairro(cod);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@PutMapping("/edit/{cod}")
	public Number editar(@RequestBody Bairro bairro, @PathVariable("cod") Long cod) throws Exception {
		try {
			return bairroService.editarBairro(bairro);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@GetMapping("/all")
	public List<Bairro> listarTudo() throws Exception {
		try {
			return bairroService.listarTodos();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@GetMapping("/cod/{cod}")
	public Bairro listarPorCod(@PathVariable("cod") Long cod) throws Exception {
		try {
			return bairroService.buscarPorCod(cod);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@GetMapping("/name/{bairro}")
	public List<Bairro> listarPorBairro(@PathVariable("bairro") String bairro) throws Exception {
		try {
			return bairroService.listarPorBairro(bairro);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
