package com.example.WebApp;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
class WebAppApplicationTests {
	
	@Autowired
	private MockMvc mockMvc;
	
	@Test
	public void shouldReturnDefaultMessage() throws Exception {
		this.mockMvc.perform(get("/"))
					.andDo(print()).andExpect(status().isOk())
					.andExpect(content()
							.string(containsString("Hello, World!")));
	}
	
	@Test
	public void shouldReturnBrunoMessage() throws Exception {
		this.mockMvc.perform(get("/bruno"))
					.andDo(print()).andExpect(status().isOk())
					.andExpect(content()
							.string(containsString("Hello, Bruno!")));
	}
	
	@Test
	public void shouldReturnQueryParamMessage() throws Exception {
		this.mockMvc.perform(get("/greeting?param=meu-teste"))
					.andDo(print()).andExpect(status().isOk())
					.andExpect(content().string(containsString("Hello meu-teste!")));
	}
	
	@Test
	public void shouldReturnUrlParamMessage() throws Exception {
		this.mockMvc.perform(get("/greeting/teste"))
					.andDo(print()).andExpect(status().isOk())
					.andExpect(content().string(containsString("Hello teste!")));
	}
	
	@Test
	public void shouldReturnVscodeMessage() throws Exception {
		this.mockMvc.perform(get("/vscode"))
					.andDo(print()).andExpect(status().isOk())
					.andExpect(content().string(containsString("Hello World from Visual Studio Code!")));
	}
	
	@Test
	public void shouldReturnEclipseMessage() throws Exception {
		this.mockMvc.perform(get("/eclipse"))
					.andDo(print()).andExpect(status().isOk())
					.andExpect(content().string(containsString("Hello World from Eclipse!")));
	}
	
	@Test
	public void shouldReturnMainBranchMessage() throws Exception {
		this.mockMvc.perform(get("/main"))
					.andDo(print()).andExpect(status().isOk())
					.andExpect(content().string(containsString("Endpoint in 'main' branch!")));
	}

	@Test
	public void shouldReturnHotfixMessage() throws Exception {
		this.mockMvc.perform(get("/hotfix"))
					.andDo(print()).andExpect(status().isOk())
					.andExpect(content().string(containsString("Endpoint na branch 'hotfix (quebrado)'")));
	}
}