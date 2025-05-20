package br.com.fiap.postechfastfood.infrastructure.web.api.configs;

import br.com.fiap.postechfastfood.domain.ports.out.PessoaRepositoryPort;
import br.com.fiap.postechfastfood.domain.ports.out.ProdutoRepositoryPort;
import br.com.fiap.postechfastfood.domain.ports.out.PedidoRepositoryPort;
import br.com.fiap.postechfastfood.domain.services.PedidoService;
import br.com.fiap.postechfastfood.domain.services.PessoaService;
import br.com.fiap.postechfastfood.domain.services.ProdutoService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DomainConfig {

    @Bean
    public PessoaService pessoaService(PessoaRepositoryPort pessoaRepository) {
        return new PessoaService(pessoaRepository);
    }
    @Bean
    public PedidoService pedidosService(PedidoRepositoryPort pedidoRepositoryPort) {
        return new PedidoService(pedidoRepositoryPort);
    }


    @Bean
    public ProdutoService produtoService(ProdutoRepositoryPort produtoRepository) {
        return new ProdutoService(produtoRepository);
    }
}
