package com.esig.bank.repository;

import static org.mockito.Mockito.when;

import javax.persistence.EntityManager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.esig.bank.model.Cargo;
import com.esig.bank.model.Pessoa;
import com.esig.bank.service.PessoaService;

@ExtendWith(MockitoExtension.class)
public class PessoasTest {
	@Mock
	private EntityManager em;
	
	@Mock
	private PessoaService pessoaService;

	@InjectMocks
	private Pessoas pessoas;

	@Test
	@DisplayName("Deve retornar pessoa pelo ID")
	public void deveRetornarPessoaPeloId() {
		Pessoa testPessoa = new Pessoa();
		testPessoa.setId(1L);
		testPessoa.setNome("teste");
		testPessoa.setCidade("cidade");
		testPessoa.setCep("cep");
		testPessoa.setEmail("email");
		testPessoa.setEndereco("endereco");
		testPessoa.setPais("pais");
		testPessoa.setCargoId(new Cargo());
		testPessoa.setTelefone("99999-9999");
		testPessoa.setUsuario("usuario");

		when(em.find(Pessoa.class, 1L)).thenReturn(testPessoa);

		Pessoa pessoaFinded = pessoas.getById(1L);

		Assertions.assertNotNull(pessoaFinded);
		Assertions.assertEquals(testPessoa, pessoaFinded);
	}
}
