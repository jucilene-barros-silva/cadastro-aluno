package br.com.fiap.cadastroaluno.configuration;

import br.com.fiap.cadastroaluno.validation.AlunoValidator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfiguration {

    @Bean
    public AlunoValidator AlunoValidator(){
        return new AlunoValidator();
    }
}
