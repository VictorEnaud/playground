package me.victorenaud.cuzcohotel.application

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class RechercherChambreUseCaseTest {
    @Test
    internal fun `renvoie toutes les chambres quand toutes sont disponibles`() {
        // Given
        val rechercherChambreUseCase = RechercherChambreUseCase()

        // When
        val chambresDisponibles = rechercherChambreUseCase.execute(RechercherChambreCommande(1))

        // Then
        assertThat(chambresDisponibles).hasSize(12)
        assertThat(chambresDisponibles).extracting("numéro")
            .containsExactly("101", "102", "103", "201", "202", "203", "204", "205", "301", "302", "303", "304")
    }

    @Test
    internal fun `renvoie uniquement les chambres qui ont assez de capacité d'accueil`() {
        // Given
        val rechercherChambreUseCase = RechercherChambreUseCase()
        val rechercherChambreCommande = RechercherChambreCommande(3)

        // When
        val chambresDisponibles = rechercherChambreUseCase.execute(rechercherChambreCommande)

        // Then
        assertThat(chambresDisponibles).extracting("numéro")
            .containsExactly("102", "103", "203", "303")
    }
}