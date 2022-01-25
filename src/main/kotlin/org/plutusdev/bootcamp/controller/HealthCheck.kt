package org.plutusdev.bootcamp.controller

import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.GetMapping

@RestController
class HealthCheck {

    @GetMapping("/healthcheck")
    fun healthCheck() = "Healthy"

}