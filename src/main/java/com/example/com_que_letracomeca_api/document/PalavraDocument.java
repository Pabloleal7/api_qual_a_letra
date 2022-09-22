package com.example.com_que_letracomeca_api.document;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;
@Data
@Document
public class PalavraDocument {

    @Id
    private String id;
    private String palavra;
    @DocumentReference
    private CategoriaDocument categoria;
    private String nivel;
    private String imagem;
}
