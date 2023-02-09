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

import br.com.vieira.venda.model.Categoria;
import br.com.vieira.venda.service.CategoriaServiceImpl;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/v1/categoria")
public class CategoriaRest {

	@Autowired
	private CategoriaServiceImpl categoriaService;

	@PostMapping("/new")
	public Categoria inserir(@RequestBody Categoria categoria) throws Exception {
		try {
			return categoriaService.adicionarCategoria(categoria);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@DeleteMapping("/remove/{cod}")
	public Number deletar(@PathVariable("cod") Long cod) throws Exception {
		try {
			return categoriaService.deletarCategoria(cod);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@PutMapping("/edit/{cod}")
	public Number editar(@RequestBody Categoria categoria, @PathVariable("cod") Long cod) throws Exception {
		try {
			return categoriaService.editarCategoria(categoria);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@GetMapping("/all")
	public List<Categoria> listarTudo() throws Exception {
		try {
			return categoriaService.listarTodos();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@GetMapping("/cod/{cod}")
	public Categoria listarPorCod(@PathVariable("cod") Long cod) throws Exception {
		try {
			return categoriaService.buscarPorCod(cod);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@GetMapping("/name/{Categoria}")
	public List<Categoria> listarPorCategoria(@PathVariable("categoria") String categoria) throws Exception {
		try {
			return categoriaService.listarPorCategoria(categoria);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
