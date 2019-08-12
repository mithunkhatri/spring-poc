package com.mithunkhatri.spring.mongodbcrud.small;

import com.mithunkhatri.spring.mongodbcrud.controllers.BookController;
import com.mithunkhatri.spring.mongodbcrud.models.Book;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.UUID;

import static java.util.Collections.singletonList;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.mockito.BDDMockito.given;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(BookController.class)
public class BookControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private BookController bookController;

    @Test
    public void givenBooksExist_whenGetBooks_thenReturnBooks() throws Exception {
        Book book = new Book();
        book.setId(UUID.randomUUID());
        book.setName("Test Name");

        given(bookController.getAll())
                .willReturn(singletonList(book));

        mvc.perform(get("/v1/books")
                    .contentType(APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$", hasSize(1)));
    }

    @Test
    public void givenNoBooksExist_whenGetBooks_thenReturnEmptyList() throws Exception{

        mvc.perform(get("/v1/books")
                .contentType(APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$", hasSize(0)));
    }

    @Test
    public void givenBookExist_whenGetBook_thenReturnBook() throws Exception {
        UUID bookId = UUID.randomUUID();
        Book book = new Book();
        book.setId(bookId);
        book.setName("Test Name");

        given(bookController.getBook(ArgumentMatchers.any()))
                .willReturn(ResponseEntity.ok(book));

        mvc.perform(get("/v1/books/" + UUID.randomUUID()).contentType(APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("id", is(bookId.toString())));
    }
}
