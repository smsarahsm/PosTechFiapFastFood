package br.com.fiap.postechfasfood.apis;

import java.net.URI;

import br.com.fiap.postechfasfood.interfaces.PessoaRepositoryInterface;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.postechfasfood.apis.requests.PessoaWebHandlerRequest;
import br.com.fiap.postechfasfood.apis.responses.PessoaWebHandlerResponse;
import br.com.fiap.postechfasfood.controllers.PessoaController;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@Service
@RestController
@RequestMapping("/api")
@Tag(name = "Pessoas", description = "end-point para gerenciar os clientes e funcionarios")
public class PessoaWebHandler {
    private final PessoaRepositoryInterface pessoaRepository;
//    private final DbConnection dbConnection;

    public PessoaWebHandler(PessoaRepositoryInterface pessoaRepository) {
        this.pessoaRepository = pessoaRepository;
    }

//    public PessoaWebHandler(DbConnection dbConnection) {
//        this.dbConnection = dbConnection;
//    }
    

    @PostMapping("/v1/pessoa")
    @Operation(summary = "Cadastra pessoas", description = "Cadastra os clientes e funcionarios")
    public ResponseEntity<PessoaWebHandlerResponse> cadastrarPessoa(@Valid @RequestBody PessoaWebHandlerRequest pessoaWebHandlerRequest) {
        final PessoaController pessoaController = new PessoaController();
        var response = pessoaController.criarPessoa(pessoaRepository, pessoaWebHandlerRequest);
        return ResponseEntity.created(URI.create("/api/v1/pessoa/" + response.cdDocPessoa()))
                .body(response);
    }

    @GetMapping("/v1/pessoa/{cdDocPessoa}")
    @Operation(summary = "Busca pessoa", description = "Busca o cliente ou funcionario por documento")
    public ResponseEntity<PessoaWebHandlerResponse> buscarPessoaPorCpf(@PathVariable String cdDocPessoa) {
        final PessoaController pessoaController = new PessoaController();
        var response = pessoaController.buscarPessoaPorCpf(pessoaRepository, cdDocPessoa);
        return ResponseEntity.ok(response);
    }
}