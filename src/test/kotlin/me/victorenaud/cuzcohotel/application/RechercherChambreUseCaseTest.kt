package me.victorenaud.cuzcohotel.application

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class RechercherChambreUseCaseTest {
    @Test
    internal fun `renvoie toutes les chambres quand toutes sont disponibles`() {
        // Given
        val rechercherChambreUseCase = RechercherChambreUseCase()

        // When
        val chambresDisponibles = rechercherChambreUseCase.execute()

        // Then
        assertThat(chambresDisponibles).hasSize(12)
        assertThat(chambresDisponibles).extracting("numéro")
            .containsAll(listOf("101", "102", "103", "201", "202", "203", "204", "205", "301", "302", "303", "304"))
    }
}