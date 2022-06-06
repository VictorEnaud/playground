package me.victorenaud.cuzcohotel.infrastructure.primaryAdapters

import me.victorenaud.cuzcohotel.application.RechercherChambreUseCase
import me.victorenaud.cuzcohotel.domain.Chambre
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(value = ["/api/v0/recherche"])
class RechercheController(val rechercherChambreUseCase: RechercherChambreUseCase) {
    @GetMapping(produces = [MediaType.APPLICATION_JSON_VALUE])
    fun recherche(): List<Chambre> {
        return rechercherChambreUseCase.execute()
    }
}