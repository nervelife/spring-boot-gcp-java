package com.nervelife.springbootgcpjava;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nervelife.springbootgcpjava.domain.entities.Book;
import com.nervelife.springbootgcpjava.domain.repositores.BooksRepository;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;

//import org.junit.Test;
//import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Optional;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
class SpringBootGcpJavaApplicationTests {

	@Autowired
	private WebApplicationContext webApplicationContext;

	ObjectMapper mapper = new ObjectMapper();

	private MockMvc mock;

	@org.junit.jupiter.api.BeforeEach
	public void setup() {
		mock = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}

	@Autowired
	BooksRepository bookRepo;

	@Test
	public void contextLoads() throws Exception {

		Book book = new Book();
		book.setTitle("Test Title");
		book.setCategory("Test Category");

		mock.perform(post("/save-book/NerveLife").contentType(MediaType.APPLICATION_JSON)
			.content(mapper.writeValueAsString(book).getBytes()))
			.andExpect(status().isOk())
			.andExpect(content().string("OK"))
			.andReturn();

		assertNotNull(book);
	}

}
