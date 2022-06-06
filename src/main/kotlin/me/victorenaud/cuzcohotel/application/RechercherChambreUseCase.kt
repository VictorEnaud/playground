package me.victorenaud.cuzcohotel.application

import me.victorenaud.cuzcohotel.domain.Chambre
import me.victorenaud.cuzcohotel.domain.Chambres

class RechercherChambreUseCase {
    fun execute(): List<Chambre> {
        val chambres = Chambres()
        return chambres.disponibles()
    }
}