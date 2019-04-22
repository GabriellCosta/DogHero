package br.com.doghero.dhproject.myhero.service.repository

import br.com.doghero.dhproject.myhero.service.Api
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import org.junit.Test

class RepositoryImplTest {

    private val api = mock<Api>()

    private var repository = RepositoryImpl(api)

    @Test
    fun givenMyHeroesFetch_whenSuccess_ShouldCallApi() {
        repository.fetchMyHeroes()

        verify(api).fetchHeroes()
    }
}
