package com.example.com_que_letracomeca_api.repository;
import com.example.com_que_letracomeca_api.document.NivelDocument;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface NivelRepository extends MongoRepository<NivelDocument,String> {
}
