package com.example.com_que_letracomeca_api.controller;
import com.example.com_que_letracomeca_api.document.NivelDocument;
import com.example.com_que_letracomeca_api.repository.NivelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/nivel")
@CrossOrigin()
public class NivelController {
    @Autowired
    NivelRepository repository;
    @GetMapping
    public ResponseEntity<List<NivelDocument>> findAll() {
        return ResponseEntity.ok(repository.findAll());
    }
    @GetMapping("/{id}")
    public ResponseEntity<NivelDocument> findById(@PathVariable String id){
        return ResponseEntity.ok(repository.findById(id).orElseThrow(() ->  new RuntimeException("Não Encontrado")));
    }
    @PostMapping
    public ResponseEntity<NivelDocument> save(@RequestBody NivelDocument document){
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
