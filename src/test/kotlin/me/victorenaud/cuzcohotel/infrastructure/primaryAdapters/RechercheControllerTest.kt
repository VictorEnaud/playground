package me.victorenaud.cuzcohotel.infrastructure.primaryAdapters

import org.hamcrest.Matchers.hasSize
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit.jupiter.SpringExtension
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath
import org.hamcrest.Matchers.`is` as Is

@ExtendWith(SpringExtension::class)
@AutoConfigureMockMvc
@SpringBootTest
internal class RechercheControllerTest {
    @Autowired
    private lateinit var mvc: MockMvc

    @Test
    fun `lors d'une recherche renvoie toutes les chambres disponibles`() {
        // When
        mvc.perform(MockMvcRequestBuilders.get("/api/v0/recherche"))

            // Then
            .andExpect(MockMvcResultMatchers.status().isOk)
            .andExpect(jsonPath<List<Any>>("$", hasSize(12)))
            .andExpect(jsonPath<String>("$[0].étage", Is("1")))
            .andExpect(jsonPath<String>("$[0].numéro", Is("101")))
            .andExpect(jsonPath<Int>("$[0].capacité", Is(2)))
            .andExpect(
                jsonPath<String>(
                    "$[0].description",
                    Is("1 king size bed - A/C - Wi-Fi - private bathroom - wheelchair accessible")
                )
            )
    }
}