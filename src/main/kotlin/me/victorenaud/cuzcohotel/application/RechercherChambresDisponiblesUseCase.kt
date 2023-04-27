package me.victorenaud.cuzcohotel.application

import me.victorenaud.cuzcohotel.domain.Chambre
import me.victorenaud.cuzcohotel.domain.Chambres

open class RechercherChambresDisponiblesUseCase {
    open fun execute(commande: RechercherChambreCommande): List<Chambre> {
        val chambres = Chambres()
        return chambres.disponibles(commande.invités)
    }
}

data class RechercherChambreCommande(val invités:Int)
