package com.example.com_que_letracomeca_api.controller;
import com.example.com_que_letracomeca_api.document.PalavraDocument;
import com.example.com_que_letracomeca_api.repository.PalavraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/palavra")
@CrossOrigin("*")
public class PalavraController {
    @Autowired
    PalavraRepository repository;
    @GetMapping
    public ResponseEntity<List<PalavraDocument>> findAll() {
        System.out.println("aqui");return ResponseEntity.ok(repository.findAll());
    }
    @GetMapping("/{id}")
    public ResponseEntity<PalavraDocument> findById(@PathVariable String id) {
        return ResponseEntity.ok(repository.findById(id).orElseThrow(() -> new RuntimeException("Não Encontrado")));
    }
    @PostMapping
    public ResponseEntity<PalavraDocument> save(@RequestBody PalavraDocument document) {
        return ResponseEntity.ok(repository.save(document));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable String id) {
        try {
            repository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new RuntimeException("Não Encontrado");
        }
        return ResponseEntity.noContent().build();
    }
}
