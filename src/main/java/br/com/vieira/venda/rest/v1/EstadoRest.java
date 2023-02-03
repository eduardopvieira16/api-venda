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

import br.com.vieira.venda.model.Estado;
import br.com.vieira.venda.service.EstadoServiceImpl;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/v1/estado")
public class EstadoRest {

	@Autowired
	private EstadoServiceImpl estadoService;

	@PostMapping("/new")
	public Estado inserir(@RequestBody Estado estado) throws Exception {
		return estadoService.adicionarEstado(estado);
	}

	@DeleteMapping("/remove/{cod}")
	public Number deletar(@PathVariable("cod") Long cod) throws Exception {
		return estadoService.deletarEstado(cod);
	}

	@PutMapping("/edit/{cod}")
	public Number editar(@RequestBody Estado estado, @PathVariable("cod") Long cod) throws Exception {
		return estadoService.editarEstado(estado);
	}

	@GetMapping("/all")
	public List<Estado> listarTudo() throws Exception {
		return estadoService.listarTodos();
	}

	@GetMapping("/cod/{cod}")
	public Estado listarPorCod(@PathVariable("cod") Long cod) throws Exception {
		return estadoService.buscarPorCod(cod);
	}

	@GetMapping("/name/{estado}")
	public List<Estado> listarPorEstado(@PathVariable("estado") String estado) throws Exception {
		return estadoService.listarPorEstado(estado);
	}

}
