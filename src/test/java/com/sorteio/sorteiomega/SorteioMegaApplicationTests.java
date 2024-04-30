package com.sorteio.sorteiomega;

import com.sorteio.mega.sorteioService.SorteioService;
import org.junit.jupiter.api.Test;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SorteioMegaAppicationTests {

	@Test
	public void testGerarNumeroDaSorteio() {
		SorteioService sorteioService = new SorteioService();

		sorteioService.gerarNumeroDaSorteio("20,30,40,50,60,70");

		}
	}

