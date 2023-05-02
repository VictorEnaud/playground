package me.victorenaud.cuzcohotel.infrastructure.primaryAdapters.web

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping(value = ["/accueil"])
class AccueilWebController {
    @GetMapping
    fun recherche(): String {
        return "accueil.html"
    }
}