package me.victorenaud.cuzcohotel.domain

class Chambres {
    private val chambres = listOf(
        Chambre.restore(Chambre.Snapshot(2, "101", "1", "1 king size bed - A/C - Wi-Fi - private bathroom - wheelchair accessible")),
        Chambre.restore(Chambre.Snapshot(4, "102", "1", "2 queen size beds - A/C - Wi-Fi - private bathroom - wheelchair accessible")),
        Chambre.restore(Chambre.Snapshot(3, "103", "1", "3 single beds - A/C - Wi-Fi - private bathroom - wheelchair accessible")),
        Chambre.restore(Chambre.Snapshot(2, "201", "2", "1 king size bed - A/C - Wi-Fi - private bathroom")),
        Chambre.restore(Chambre.Snapshot(2, "202", "2", "1 queen size bed - Wi-Fi - private bathroom")),
        Chambre.restore(Chambre.Snapshot(5, "203", "2", "1 king size bed + 3 single beds - A/C - Wi-Fi - private bathroom")),
        Chambre.restore(Chambre.Snapshot(1, "204", "2", "1 single bed - Wi-Fi - shared bathroom")),
        Chambre.restore(Chambre.Snapshot(2, "205", "2", "2 single beds - A/C - Wi-Fi - shared bathroom")),
        Chambre.restore(Chambre.Snapshot(2, "301", "3", "1 queen size bed - A/C - private bathroom")),
        Chambre.restore(Chambre.Snapshot(2, "302", "3", "2 single beds - A/C - private bathroom")),
        Chambre.restore(Chambre.Snapshot(3, "303", "3", "3 single beds - A/C - shared bathroom")),
        Chambre.restore(Chambre.Snapshot(2, "304", "3", "2 single beds - shared bathroom")),
    )

    fun disponibles(invités: Int): List<Chambre> {
        return chambres.filter { chambre -> chambre.peutAccueillir(invités) }
    }
}