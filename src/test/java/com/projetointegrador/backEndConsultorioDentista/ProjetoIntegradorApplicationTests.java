package com.projetointegrador.backEndConsultorioDentista;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.projetointegrador.backEndConsultorioDentista.domain.service.ClinicaOdontologicaService;
import com.projetointegrador.backEndConsultorioDentista.domain.service.PacienteService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@AutoConfigureMockMvc
@SpringBootTest
class ProjetoIntegradorApplicationTests {

	@Autowired
	private MockMvc mvc;
	@Autowired
	private ObjectMapper mapper;
	@MockBean
	private PacienteService pacienteService;
	private ClinicaOdontologicaService clinicaOdontologicaService;

	@Test
	void contextLoads() {
		Assertions.assertNotNull(mvc);
	}

	@Test
	public void cadastrarPacienteTest() throws Exception {
		String json = "{\n" +
				"  \"nome\": \"Teste Paciente\",\n" +
				"  \"dataNascimento\": \"2000-01-01\",\n" +
				"  \"sexo\": \"F\",\n" +
				"  \"contatoId\": 1,\n" +
				"  \"enderecoId\": 2\n" +
				"}";


		this.mvc.perform(MockMvcRequestBuilders.post("/v1/pacientes")
						.contentType(MediaType.APPLICATION_JSON)
						.content(json))
				.andExpect(status().isCreated());
	}

	@Test
	public void buscarTodosPacientesTest() throws Exception {
		this.mvc.perform(MockMvcRequestBuilders.get("/v1/pacientes"))
				.andExpect(status().isOk());
	}


	@Test
	public void cadastrarClinicaTest() throws Exception {
		String json = "{\n" +
				"  \"nome\": \"Clínica Dois\",\n" +
				"  \"cpnj\": \"44.167.376/0001-60\",\n" +
				"  \"razaoSocial\": \"Nome da Empresa\",\n" +
				"  \"descricao\": \"Descrição da Clínica\",\n" +
				"  \"endereco\": {\n" +
				"    \"rua\": \"Rua da Clínica\",\n" +
				"    \"bairro\": \"Bairro do Douglas\",\n" +
				"    \"cidade\": \"Cidade\",\n" +
				"    \"estado\": \"Estado\",\n" +
				"    \"cep\": \"12345\"\n" +
				"  },\n" +
				"  \"contato\": {\n" +
				"    \"email\": \"contato@clinica.com\",\n" +
				"    \"telefone\": \"+1234567890\"\n" +
				"  }\n" +
				"}";

		this.mvc.perform(MockMvcRequestBuilders.post("/v1/clinicas")
						.contentType(MediaType.APPLICATION_JSON)
						.content(json))
				.andExpect(status().isCreated());
	}

	@Test
	public void buscarTodasClinicasTest() throws Exception {
		this.mvc.perform(MockMvcRequestBuilders.get("/v1/clinicas"))
				.andExpect(status().isOk());
	}

}
