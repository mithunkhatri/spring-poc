package com.mithunkhatri.spring.mongodbcrud.models;

import com.mithunkhatri.spring.mongodbcrud.models.common.Language;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Document(value = "book")
public class Book {

    @Id
    private UUID id = UUID.randomUUID();

    @NotNull
    private String name;
    private String isbn;
    private String author;
    private int readingLevel;
    private int paperback;
    private String publisher;
    private Language language;
}