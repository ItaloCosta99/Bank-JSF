package com.esig.bank.service;

import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.esig.bank.enums.TipoVencimento;
import com.esig.bank.model.Vencimento;
import com.esig.bank.repository.Vencimentos;

@ExtendWith(MockitoExtension.class)
public class VencimentoServiceTest {

	@Mock
	private Vencimentos vencimentosRepo;

	@Mock
	private EntityManager em;

	@InjectMocks
	private VencimentoService vencimentoService;

	@Test
	@DisplayName("Deve retornar todos os vencimentos")
	public void retornarTodosVencimentos() {
		Vencimento vencimento = new Vencimento();
		vencimento.setId(1L);
		vencimento.setValor(new BigDecimal(10));
		vencimento.setDescricao("descricao");
		vencimento.setTipo(TipoVencimento.CREDITO);

		List<Vencimento> listaVencimentosEsperada = Arrays.asList(new Vencimento());
		when(vencimentosRepo.gelAll()).thenReturn(listaVencimentosEsperada);

		// Ação
		List<Vencimento> listaVencimentosEncontrada = vencimentoService.getAll();

		// Verificação
		Assertions.assertEquals(listaVencimentosEsperada, listaVencimentosEncontrada);

	}

}
