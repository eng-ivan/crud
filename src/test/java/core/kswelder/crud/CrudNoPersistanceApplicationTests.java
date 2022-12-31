package core.kswelder.crud;

import core.kswelder.crud.model.Cliente;
import core.kswelder.crud.model.ClienteDTO;
import core.kswelder.crud.model.Endereco;
import core.kswelder.crud.utils.EnderecoRequest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class CrudNoPersistanceApplicationTests {

	@Autowired
	EnderecoRequest request;
	@Test
	void testCEP() {
		Endereco endereco = request.requestEndereco("13063240");
		Assertions.assertEquals("13063-240", endereco.getCep());
	}

	@Test
	void passedTestID() {
		ClienteDTO dto = new ClienteDTO();
		dto.setId(1L);
		System.out.println("Test PASSED! now again");
		Assertions.assertEquals(1L, dto.getId());
	}

	@Test
	void testName() {
		ClienteDTO dto = new ClienteDTO();
		dto.setNome("Ivan Santos");
		Assertions.assertEquals("Ivan Santos", dto.getNome());
	}
}
