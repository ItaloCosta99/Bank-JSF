package com.esig.bank.controller;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.esig.bank.service.PessoaService;

@ExtendWith(MockitoExtension.class)
public class PessoaSalarioConsolidadoBeanTest {
	@Mock
	private PessoaService pessoaService;

	@InjectMocks
	private PessoaSalarioConsolidadoBean pscBean;

	@Test
	@DisplayName("Deve cadastrar uma pessoa")
	public void DeveCadastrarPessoa() {
		Assertions.assertNull(pscBean.getPessoa());
		pscBean.prepararNovaPessoa();
		Assertions.assertNotNull(pscBean.getPessoa());
	}
}
