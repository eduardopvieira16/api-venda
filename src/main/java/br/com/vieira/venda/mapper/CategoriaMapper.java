package br.com.vieira.venda.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import br.com.vieira.venda.model.Categoria;

public class CategoriaMapper implements RowMapper<Categoria> {

	@Override
	public Categoria mapRow(ResultSet rs, int rowNum) throws SQLException {
		return new Categoria(rs.getLong("IDCATEGORIA"), rs.getString("CATEGORIA"));
	}

}
