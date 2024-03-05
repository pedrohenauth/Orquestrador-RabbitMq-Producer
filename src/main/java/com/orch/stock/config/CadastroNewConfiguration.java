package com.orch.stock.config;

import com.orch.stock.camel.router.CadastroRouter;
import com.orch.stock.domain.Cadastro;
import com.orch.stock.infrastructure.repository.CadastroRepository;
import com.orch.stock.service.CadastroService;
import org.apache.camel.CamelContext;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.impl.DefaultCamelContext;
import org.jdbi.v3.core.Jdbi;
import org.jdbi.v3.core.mapper.RowMapper;
import org.jdbi.v3.core.spi.JdbiPlugin;
import org.jdbi.v3.sqlobject.SqlObjectPlugin;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.TransactionAwareDataSourceProxy;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;

import javax.sql.DataSource;
import java.util.List;

@EnableWebMvc
@Configuration
public class CadastroNewConfiguration implements WebMvcConfigurer {


    @Bean
    public RestTemplate restTemplate(){ return new RestTemplate();}

    @Bean
    public CadastroRouter cadastroRouter(CadastroRepository cadastroRepository){
        return new CadastroRouter(cadastroRepository);
    }

    @Bean
    public Jdbi jdbi(DataSource dataSource, List<JdbiPlugin> plugins, List<RowMapper<?>> rowMappers){
        Jdbi jdbi = Jdbi.create(new TransactionAwareDataSourceProxy(dataSource));
        plugins.forEach(jdbi::installPlugin);
        rowMappers.forEach(jdbi::registerRowMapper);
        return jdbi;
    }

    @Bean
    public JdbiPlugin sqlObjectPlugin(){
        return new SqlObjectPlugin();
    }

    @Bean
    public ProducerTemplate producerTemplate(CamelContext camelContext) {
        return camelContext.createProducerTemplate();
    }

    @Bean
    public RequestMappingHandlerAdapter handlerAdapter() {
        return new RequestMappingHandlerAdapter();
    }



}
