package com.github.AGEM20.tqi_evolution_avaliacao.utils;

import org.springframework.web.bind.annotation.*;

/* Oracle
Pesquisa individual

@GetMapping(path = {"/{id}"})
public ResponseEntity findById(@PathVariable long id){
   return repository.findById(id)
           .map(record -> ResponseEntity.ok().body(record))
           .orElse(ResponseEntity.notFound().build());
}

Pesquisa todos
@GetMapping
public List findAll(){
   return repository.findAll();
}

Gravação
@PostMapping
public Contact create(@RequestBody Contact contact){
   return repository.save(contact);
}

Atualização
@PutMapping(value="/{id}")
public ResponseEntity update(@PathVariable("id") long id,
                                      @RequestBody Contact contact) {
   return repository.findById(id)
           .map(record -> {
               record.setName(contact.getName());
               record.setEmail(contact.getEmail());
               record.setPhone(contact.getPhone());
               Contact updated = repository.save(record);
               return ResponseEntity.ok().body(updated);
           }).orElse(ResponseEntity.notFound().build());
}

DELETE
@DeleteMapping(path ={"/{id}"})
public ResponseEntity <?> delete(@PathVariable long id) {
   return repository.findById(id)
           .map(record -> {
               repository.deleteById(id);
               return ResponseEntity.ok().build();
           }).orElse(ResponseEntity.notFound().build());
}

pesquisa com 2 atributos em tabela (login)
Teste findByTeste1AnoAndTeste1Id(Integer ano, Integer id);



*/
