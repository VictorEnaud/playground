package me.victorenaud.cuzcohotel

import me.victorenaud.cuzcohotel.application.RechercherChambreUseCase
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class ApplicationConfiguration {
    @Bean
    fun createRechercherChambreUseCase(): RechercherChambreUseCase = RechercherChambreUseCase()
}