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
		return categoriaService.adicionarCategoria(categoria);
	}

	@DeleteMapping("/remove/{cod}")
	public Number deletar(@PathVariable("cod") Long cod) throws Exception {
		return categoriaService.deletarCategoria(cod);
	}

	@PutMapping("/edit/{cod}")
	public Number editar(@RequestBody Categoria categoria, @PathVariable("cod") Long cod) throws Exception {
		return categoriaService.editarCategoria(categoria);
	}

	@GetMapping("/all")
	public List<Categoria> listarTudo() throws Exception {
		return categoriaService.listarTodos();
	}

	@GetMapping("/cod/{cod}")
	public Categoria listarPorCod(@PathVariable("cod") Long cod) throws Exception {
		return categoriaService.buscarPorCod(cod);
	}

	@GetMapping("/name/{Categoria}")
	public List<Categoria> listarPorCategoria(@PathVariable("categoria") String categoria) throws Exception {
		return categoriaService.listarPorCategoria(categoria);
	}

}
