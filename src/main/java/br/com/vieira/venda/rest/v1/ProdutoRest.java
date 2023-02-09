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

import br.com.vieira.venda.model.Produto;
import br.com.vieira.venda.service.ProdutoServiceImpl;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/v1/produto")
public class ProdutoRest {

	@Autowired
	private ProdutoServiceImpl produtoService;

	@PostMapping("/new")
	public Produto inserir(@RequestBody Produto produto) throws Exception {
		try {
			return produtoService.adicionarProduto(produto);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@DeleteMapping("/remove/{cod}")
	public Number deletar(@PathVariable("cod") Long cod) throws Exception {
		try {
			return produtoService.deletarProduto(cod);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@PutMapping("/edit/{cod}")
	public Number editar(@RequestBody Produto produto, @PathVariable("cod") Long cod) throws Exception {
		try {
			return produtoService.editarProduto(produto);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@GetMapping("/all")
	public List<Produto> listarTudo() throws Exception {
		try {
			return produtoService.listarTodos();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@GetMapping("/cod/{cod}")
	public Produto listarPorCod(@PathVariable("cod") Long cod) throws Exception {
		try {
			return produtoService.buscarPorCod(cod);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@GetMapping("/name/{produto}")
	public List<Produto> listarPorProduto(@PathVariable("produto") String produto) throws Exception {
		try {
			return produtoService.listarPorProduto(produto);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
