package br.com.fiap.postechfasfood.apis;

import br.com.fiap.postechfasfood.apis.requests.PessoaWebHandlerRequest;
import br.com.fiap.postechfasfood.interfaces.DbConnection;
import br.com.fiap.postechfastfood_old.domain.ports.in.PessoaServicePort;
import br.com.fiap.postechfastfood_old.infrastructure.web.api.controllers.PessoaController;
import br.com.fiap.postechfastfood_old.infrastructure.web.api.dtos.PessoaResponseDto;
import br.com.fiap.postechfastfood_old.infrastructure.web.api.dtos.PessoaRestDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
@RequestMapping("/api")
@Tag(name = "Pessoas", description = "end-point para gerenciar os clientes e funcionarios")
public class PessoaWebHandler {

    private final DbConnection dbConnection;

    public PessoaWebHandler(DbConnection dbConnection) {
        this.dbConnection = dbConnection;
    }

    @PostMapping("/v1/pessoa")
    @Operation(summary = "Cadastra pessoas", description = "Cadastra os clientes e funcionarios")
    public ResponseEntity<?> cadastrarPessoa(@Valid @RequestBody PessoaWebHandlerRequest pessoaWebHandlerRequest) {

        return ResponseEntity.created(URI.create("/api/v1/pessoa/")).build();
    }
}
