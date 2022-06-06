package me.victorenaud.cuzcohotel.domain

class Chambre private constructor(val numéro: String, val capacité: Int, val étage: String, val description: String) {
    fun peutAccueillir(invités: Int): Boolean {
        return invités <= capacité
    }

    companion object {
        fun restore(snapshot: Snapshot): Chambre {
            return Chambre(snapshot.numéro, snapshot.capacité, snapshot.étage, snapshot.description)
        }
    }

    data class Snapshot(
        val capacité: Int,
        val numéro: String,
        val étage: String,
        val description: String,
    )
}
