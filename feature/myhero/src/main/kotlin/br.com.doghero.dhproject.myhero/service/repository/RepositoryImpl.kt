package br.com.doghero.dhproject.myhero.service.repository

import br.com.doghero.dhproject.myhero.service.Api

internal class RepositoryImpl(private val api: Api) : Repository {

    override fun fetchMyHeroes() =
        api.fetchHeroes()
}
