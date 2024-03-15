package com.pragma.arquetipobootcamp2024.configuration;

import com.pragma.arquetipobootcamp2024.adapters.driven.jpa.mysql.adapter.TecnologiaAdapter;
import com.pragma.arquetipobootcamp2024.adapters.driven.jpa.mysql.mapper.ITecnologiaEntityMapper;
import com.pragma.arquetipobootcamp2024.adapters.driven.jpa.mysql.repository.ITecnologiaRepository;
import com.pragma.arquetipobootcamp2024.domain.api.ITecnologiaServicePort;
import com.pragma.arquetipobootcamp2024.domain.api.usecase.TecnologiaUseCase;
import com.pragma.arquetipobootcamp2024.domain.spi.ITecnologiaPersistencePort;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class BeanConfiguration {

    private final ITecnologiaEntityMapper tecnologiaEntityMapper;
    private final ITecnologiaRepository tecnologiaRepository;



    @Bean
    public ITecnologiaPersistencePort tecnologiaPersistencePort() {
        return new TecnologiaAdapter(tecnologiaRepository, tecnologiaEntityMapper);
    }

    @Bean
    public ITecnologiaServicePort tecnologiaServicePort() {
        return new TecnologiaUseCase(tecnologiaPersistencePort());
    }
}
