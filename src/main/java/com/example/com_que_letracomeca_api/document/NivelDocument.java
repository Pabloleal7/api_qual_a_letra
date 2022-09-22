package com.example.com_que_letracomeca_api.document;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
@Data
@Document
public class NivelDocument {
    @Id
    private String id;
    private String nome;
}
