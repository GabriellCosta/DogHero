package br.com.doghero.dhproject

import android.app.Application
import br.com.doghero.dhproject.commons.di.commonsModule
import br.com.doghero.dhproject.myhero.di.myHeroModule
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware

internal class CustomApplication : Application(), KodeinAware {

    override val kodein = Kodein {

        import(myHeroModule)
        import(commonsModule)
    }
}
