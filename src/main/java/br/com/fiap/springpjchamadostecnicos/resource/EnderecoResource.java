package br.com.fiap.springpjchamadostecnicos.resource;

import br.com.fiap.springpjchamadostecnicos.entity.Endereco;
import br.com.fiap.springpjchamadostecnicos.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/endereco")
public class EnderecoResource {
    @Autowired
    private EnderecoRepository repo;

    @GetMapping
    public List<Endereco> findAll() {
        return repo.findAll();
    }

    @GetMapping(value = "/{id}")
    public Endereco findById(@PathVariable Long id) {
        return repo.findById(id).orElseThrow();
    }


}