package me.victorenaud.cuzcohotel.infrastructure.primaryAdapters

import me.victorenaud.cuzcohotel.application.RechercherChambreCommande
import me.victorenaud.cuzcohotel.application.RechercherChambresDisponiblesUseCase
import me.victorenaud.cuzcohotel.domain.Chambre
import me.victorenaud.cuzcohotel.infrastructure.primaryAdapters.api.RechercheApiController
import org.hamcrest.Matchers
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.Mock
import org.mockito.junit.jupiter.MockitoExtension
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers
import org.springframework.test.web.servlet.setup.MockMvcBuilders
import org.mockito.Mockito.`when` as When


@ExtendWith(MockitoExtension::class)
internal class RechercheApiControllerTest {
    private lateinit var mvc: MockMvc

    @Mock private lateinit var rechercherChambresDisponiblesUseCase: RechercherChambresDisponiblesUseCase

    @BeforeEach
    fun setUp() {
        mvc = MockMvcBuilders.standaloneSetup(
            RechercheApiController(
                rechercherChambresDisponiblesUseCase,
            )
        )
            .build()
    }

    @Test
    internal fun `Quand un recherche est faite renvoie 200 et la liste des chambres disponibles`() {
        // Given
        val nombreDInvités = 3
        val chambresAttendues = listOf(
            Chambre.restore(Chambre.Snapshot(4, "102", "1", "2 queen size beds - A/C - Wi-Fi - private bathroom - wheelchair accessible")),
            Chambre.restore(Chambre.Snapshot(3, "103", "1", "3 single beds - A/C - Wi-Fi - private bathroom - wheelchair accessible")),
        )
        When(rechercherChambresDisponiblesUseCase.execute(RechercherChambreCommande(nombreDInvités)))
            .thenReturn(chambresAttendues)

        // When
        mvc.perform(MockMvcRequestBuilders.get("/api/v0/recherche?invités=$nombreDInvités"))

            // Then
            .andExpect(MockMvcResultMatchers.status().isOk)
            .andExpect(MockMvcResultMatchers.jsonPath<List<Any>>("$", Matchers.hasSize(2)))
            .andExpect(MockMvcResultMatchers.jsonPath("$[0].étage", Matchers.`is`("1")))
            .andExpect(MockMvcResultMatchers.jsonPath("$[0].numéro", Matchers.`is`("102")))
            .andExpect(MockMvcResultMatchers.jsonPath("$[0].capacité", Matchers.`is`(4)))
            .andExpect(
                MockMvcResultMatchers.jsonPath(
                    "$[0].description",
                    Matchers.`is`("2 queen size beds - A/C - Wi-Fi - private bathroom - wheelchair accessible")
                )
            )
    }
}