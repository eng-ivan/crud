package core.kswelder.crud;

import core.kswelder.crud.model.Cliente;
import core.kswelder.crud.model.ClienteDTO;
import core.kswelder.crud.model.ConnectTest;
import core.kswelder.crud.model.Endereco;
import core.kswelder.crud.utils.EnderecoRequest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Date;
import java.util.UUID;

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
	void testSave(){

		Cliente c1 = Cliente.builder()
				.id(1L)
				.nome("Person 1")
				.dataNascimento("31/12/1900")
				.dataCriacao("31/12/1900")
				.dataDeAtualizacao("31/12/1900")
				.status("ATIVO")
				.endereco("13063340")
				.build();

		Cliente c2 = Cliente.builder()
				.id(1L)
				.nome("Person 1")
				.dataNascimento("31/12/1900")
				.dataCriacao("31/12/1900")
				.dataDeAtualizacao("31/12/1900")
				.status("ATIVO")
				.endereco("13063340")
				.build();

		Assertions.assertNotEquals(c1, c2);
	}

	@Test
	void passedTestID() {
		ClienteDTO dto = new ClienteDTO();
		dto.setId(1L);
		Assertions.assertEquals(1L, dto.getId());
	}

	@Test
	void testIDNull() {
		ClienteDTO dto = new ClienteDTO();
		dto.setId(null);
		Assertions.assertEquals(null, dto.getId());
	}

	@Test
	void testName() {
		ClienteDTO dto = new ClienteDTO();
		dto.setNome("Ivan Santos");
		Assertions.assertEquals("Ivan Santos", dto.getNome());
	}

	@Test
	void testStatus() {
		ClienteDTO dto = new ClienteDTO();
		dto.setStatus("ATIVO");
		Assertions.assertEquals("ATIVO", dto.getStatus());
	}

	@Test
	void testStatusInativo() {
		ClienteDTO dto = new ClienteDTO();
		dto.setStatus("INATIVO");
		Assertions.assertEquals("INATIVO", dto.getStatus());
	}

	@Test
	void testConnect() throws UnknownHostException {
		String uuid = UUID.randomUUID().toString();
		ConnectTest test = ConnectTest.builder()
				.address(InetAddress.getLocalHost())
				.timestamp(new Date().toString())
				.keyConnection(uuid)
				.build();

		Assertions.assertNotEquals(new Object(), test);
	}
}
