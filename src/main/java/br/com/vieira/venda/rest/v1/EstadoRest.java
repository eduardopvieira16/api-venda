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
		try {
			return estadoService.adicionarEstado(estado);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@DeleteMapping("/remove/{cod}")
	public Number deletar(@PathVariable("cod") Long cod) throws Exception {
		try {
			return estadoService.deletarEstado(cod);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@PutMapping("/edit/{cod}")
	public Number editar(@RequestBody Estado estado, @PathVariable("cod") Long cod) throws Exception {
		try {
			return estadoService.editarEstado(estado);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@GetMapping("/all")
	public List<Estado> listarTudo() throws Exception {
		try {
			return estadoService.listarTodos();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@GetMapping("/cod/{cod}")
	public Estado listarPorCod(@PathVariable("cod") Long cod) throws Exception {
		try {
			return estadoService.buscarPorCod(cod);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@GetMapping("/name/{estado}")
	public List<Estado> listarPorEstado(@PathVariable("estado") String estado) throws Exception {
		try {
			return estadoService.listarPorEstado(estado);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
