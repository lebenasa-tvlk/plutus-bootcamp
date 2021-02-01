package org.plutusdev.bootcamp

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

import org.plutusdev.bootcamp.controller.HealthCheck

@SpringBootApplication
class BootcampApplication

fun main(args: Array<String>) {
	runApplication<BootcampApplication>(*args)
}
