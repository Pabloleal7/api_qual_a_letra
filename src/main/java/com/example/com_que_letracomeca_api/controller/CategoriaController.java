package com.example.com_que_letracomeca_api.controller;
import com.example.com_que_letracomeca_api.document.CategoriaDocument;
import com.example.com_que_letracomeca_api.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping(value = "/categoria")
@CrossOrigin()
public class CategoriaController {
    @Autowired
    CategoriaRepository repository;
    @GetMapping
    public ResponseEntity<List<CategoriaDocument>> findAll() {
        return ResponseEntity.ok(repository.findAll());
    }
    @GetMapping("/{id}")
    public ResponseEntity<CategoriaDocument> findById(@PathVariable String id){
        return ResponseEntity.ok(repository.findById(id).orElseThrow(() ->  new RuntimeException("Não Encontrado")));
    }
    @PostMapping
    public ResponseEntity<CategoriaDocument> save(@RequestBody CategoriaDocument document){
        return ResponseEntity.ok(repository.save(document));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable String id){
        try {
            repository.deleteById(id);
        }catch (EmptyResultDataAccessException e){
            throw new RuntimeException("Não Encontrado");
        }
        return ResponseEntity.noContent().build();
    }
}
