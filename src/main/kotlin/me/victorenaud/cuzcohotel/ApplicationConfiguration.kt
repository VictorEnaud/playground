package me.victorenaud.cuzcohotel

import me.victorenaud.cuzcohotel.application.RechercherChambresDisponiblesUseCase
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class ApplicationConfiguration {
    @Bean
    fun createRechercherChambreUseCase(): RechercherChambresDisponiblesUseCase = RechercherChambresDisponiblesUseCase()
}