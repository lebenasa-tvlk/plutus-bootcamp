package org.plutusdev.bootcamp.controller

import org.assertj.core.api.Assertions.assertThat

import org.junit.jupiter.api.Test

import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get

@SpringBootTest
class SmokeTest(@Autowired val controller: HealthCheck) {
    @Test
    fun contextLoads() {
        assertThat(controller).isNotNull
    }
}

@WebMvcTest(controllers = [HealthCheck::class])
class ControllerTest(@Autowired val mockMvc: MockMvc) {
    @Test
    fun shouldReturnResponse() {
        mockMvc
            .perform(
                get("/healthcheck")
                    .contentType(MediaType.TEXT_PLAIN)
            )
            .andExpect {
                assertThat(it.response.status).isEqualTo(200)
            }
            .andExpect {
                assertThat(it.response.contentAsString).isEqualTo("Healthy")
            }
    }
}