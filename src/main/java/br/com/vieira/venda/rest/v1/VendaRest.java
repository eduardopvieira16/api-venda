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

import br.com.vieira.venda.model.Venda;
import br.com.vieira.venda.service.VendaServiceImpl;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/v1/venda")
public class VendaRest {

	@Autowired
	private VendaServiceImpl vendaService;

	@PostMapping("/new")
	public Venda inserir(@RequestBody Venda venda) throws Exception {
		try {
			return vendaService.adicionarVenda(venda);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@DeleteMapping("/remove/{cod}")
	public Number deletar(@PathVariable("cod") Long cod) throws Exception {
		try {
			return vendaService.deletarVenda(cod);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@PutMapping("/edit/{cod}")
	public Number editar(@RequestBody Venda venda, @PathVariable("cod") Long cod) throws Exception {
		try {
			return vendaService.editarVenda(venda);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@GetMapping("/all")
	public List<Venda> listarTudo() throws Exception {
		try {
			return vendaService.listarTodos();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@GetMapping("/cod/{cod}")
	public Venda listarPorCod(@PathVariable("cod") Long cod) throws Exception {
		try {
			return vendaService.buscarPorCod(cod);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@GetMapping("/name/{venda}")
	public List<Venda> listarPorVenda(@PathVariable("venda") String venda) throws Exception {
		try {
			return vendaService.listarPorVenda(venda);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
