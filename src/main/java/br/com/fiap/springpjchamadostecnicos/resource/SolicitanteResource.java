package br.com.fiap.springpjchamadostecnicos.resource;

import br.com.fiap.springpjchamadostecnicos.entity.Endereco;
import br.com.fiap.springpjchamadostecnicos.entity.Solicitante;
import br.com.fiap.springpjchamadostecnicos.entity.Telefone;
import br.com.fiap.springpjchamadostecnicos.repository.EnderecoRepository;
import br.com.fiap.springpjchamadostecnicos.repository.SolicitanteRepository;
import br.com.fiap.springpjchamadostecnicos.repository.TelefoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/solicitante")
public class SolicitanteResource {

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Autowired
    private TelefoneRepository telefoneRepository;

    private final SolicitanteRepository solicitanteRepository;

    @Autowired
    public SolicitanteResource(SolicitanteRepository solicitanteRepository) {
        this.solicitanteRepository = solicitanteRepository;
    }

    @Autowired
    private SolicitanteRepository repo;

    @GetMapping
    public List<Solicitante> findAll() {
        return repo.findAll();
    }

    @GetMapping(value = "/{id}")
    public Solicitante findById(@PathVariable Long id) {
        return repo.findById(id).orElseThrow();
    }

    @Transactional
    @PostMapping
    public Solicitante save(@RequestBody Solicitante solicitante) {
        return repo.save(solicitante);
    }
    @GetMapping(value = "/{id}/endereco")
    public List<Endereco> getEnderecosBySolicitanteId(@PathVariable Long id) {
        return solicitanteRepository.findEnderecosBySolicitanteId(id);
    }

    @GetMapping(value = "/{id}/telefone")
    public List<Telefone> getTelefonesBySolicitanteId(@PathVariable Long id) {
        return solicitanteRepository.findTelefonesBySolicitanteId(id);
    }
    @Transactional
    @PostMapping(value = "/{id}/endereco")
    public Endereco addEnderecoToSolicitante(@PathVariable Long id, @RequestBody Endereco endereco) {
        Solicitante solicitante = repo.findById(id).orElseThrow();
        endereco.setSolicitante(solicitante);
        return enderecoRepository.save(endereco);
    }

    @Transactional
    @PostMapping(value = "/{id}/telefone")
    public Telefone addTelefoneToSolicitante(@PathVariable Long id, @RequestBody Telefone telefone) {
        Solicitante solicitante = repo.findById(id).orElseThrow();
        telefone.setSolicitante(solicitante);
        return telefoneRepository.save(telefone);
    }
}
