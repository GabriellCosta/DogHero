package br.com.doghero.dhproject.myhero.di

import br.com.doghero.dhproject.myhero.service.Api
import br.com.doghero.dhproject.myhero.service.repository.RepositoryImpl
import br.com.doghero.dhproject.myhero.viewmodel.MyHeroesViewModel
import br.com.doghero.dhproject.network.NetworkClient
import org.kodein.di.Kodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider
import org.kodein.di.generic.singleton

val myHeroModule = Kodein.Module("myHeroModule") {

    bind() from singleton {
        NetworkClient.getApi(Api::class.java)
    }

    bind() from provider {
        RepositoryImpl(instance())
    }

    bind() from provider {
        MyHeroesViewModel(instance())
    }

}
