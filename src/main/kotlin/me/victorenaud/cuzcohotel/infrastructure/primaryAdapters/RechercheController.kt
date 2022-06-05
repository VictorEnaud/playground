package me.victorenaud.cuzcohotel.infrastructure.primaryAdapters

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(value = ["/api/v0/recherche"])
class RechercheController {
    @GetMapping
    fun recherche():String {
        return "Bonjour le monde !"
    }
}