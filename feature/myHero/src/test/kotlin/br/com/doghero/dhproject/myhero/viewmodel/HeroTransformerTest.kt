package br.com.doghero.dhproject.myhero.viewmodel

import br.com.doghero.dhproject.myhero.service.entity.DogHeroUserDTO
import br.com.doghero.dhproject.myhero.service.entity.UserDTO
import org.junit.Assert.assertEquals
import org.junit.Test
import java.math.BigDecimal

class HeroTransformerTest {

    private val mock = prepareHeroDTOMock()

    private val transformer = HeroTransformer()

    private fun prepareHeroDTOMock(): DogHeroUserDTO {
        return DogHeroUserDTO(
            superHero = true,
            user = UserDTO(
                firstName = "Tiger",
                imageUrl = "http://google.com"
            ),
            address = "Rua dos tigres, n 163",
            price = BigDecimal("77")
        )
    }

    @Test
    fun givenDogHeroUser_whenConverted_shouldHaveCorrectSuperHeroParameter() {
        val result = transformer.map(mock)

        assertEquals(true, result.superHero)
    }

    @Test
    fun givenDogHeroUser_whenConverted_shouldHaveCorrectUserName() {
        val result = transformer.map(mock)

        assertEquals("Tiger", result.userName)
    }

    @Test
    fun givenDogHeroUser_whenConverted_shouldHaveCorrectUserImageUrl() {
        val result = transformer.map(mock)

        assertEquals("http://google.com", result.userImage)
    }

    @Test
    fun givenDogHeroUser_whenConverted_shouldHaveCorrectAddress() {
        val result = transformer.map(mock)

        assertEquals("Rua dos tigres, n 163", result.address)
    }

    @Test
    fun givenDogHeroUser_whenConverted_shouldHaveCorrectPrice() {
        val result = transformer.map(mock)

        assertEquals("77", result.price)
    }
}
