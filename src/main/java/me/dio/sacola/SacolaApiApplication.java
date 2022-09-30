package me.dio.sacola;

import me.dio.sacola.enums.FormaPagamento;
import me.dio.sacola.model.*;
import me.dio.sacola.repositories.ClienteRepository;
import me.dio.sacola.repositories.ProdutoRepository;
import me.dio.sacola.repositories.RestauranteRepository;
import me.dio.sacola.repositories.SacolaRepository;
import org.hibernate.type.BigIntegerType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class SacolaApiApplication implements CommandLineRunner {

	@Autowired
	private RestauranteRepository restauranteRepository;

	@Autowired
	private ClienteRepository clienteRepository;

	@Autowired
	private ProdutoRepository produtoRepository;

	@Autowired
	private SacolaRepository sacolaRepository;

	public static void main(String[] args) {
		SpringApplication.run(SacolaApiApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Restaurante r1 = new Restaurante();
		r1.setId(1L);
		r1.setNome("Restaurante 1");
		r1.setEndereco(new Endereco("0000001", "Complemento Endereco Restaurante 1"));

		Restaurante r2 = new Restaurante();
		r2.setId(2L);
		r2.setNome("Restaurante 2");
		r2.setEndereco(new Endereco("0000002", "Complemento Endereco Restaurante 2"));

		restauranteRepository.saveAll(List.of(r1,r2));

		Cliente c1 = new Cliente();
		c1.setNome("Cliente 1");
		c1.setEndereco(new Endereco("0000001", "Complemento Endereco 1"));

		clienteRepository.save(c1);

		Sacola sa = new Sacola();
		sa.setCliente(c1);
		sa.setFormaPagamento(FormaPagamento.DINHEIRO);
		sa.setFechada(false);
		sa.setValorTotal(0d);

		sacolaRepository.save(sa);

		Produto p1 =  new Produto();
		p1.setId(1L);
		p1.setNome("Produto 1");
		p1.setValorUnitario(5.0);
		p1.setRestaurante(r1);

		Produto p2 = new Produto();
		p2.setId(2L);
		p2.setNome("Produto 2");
		p2.setValorUnitario(6.0);
		p2.setRestaurante(r1);

		Produto p3 = new Produto();
		p3.setId(3L);
		p3.setNome("Produto 3");
		p3.setValorUnitario(7.0);
		p3.setRestaurante(r2);

		produtoRepository.saveAll(List.of(p1,p2,p3));


	}
}
