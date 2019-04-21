package br.com.doghero.dhproject.myhero.viewmodel

import br.com.doghero.dhproject.myhero.service.entity.DogHeroUserDTO
import br.com.doghero.dhproject.myhero.ui.vo.HeroVO
import br.com.doghero.dhproject.myhero.util.CurrencyFormatter
import br.com.doghero.dhproject.network.ui.UiTransformer

internal class HeroTransformer : UiTransformer<DogHeroUserDTO, HeroVO> {

    private val currencyFormatter = CurrencyFormatter()

    override fun map(parameter: DogHeroUserDTO): HeroVO {

        return HeroVO(
            parameter.user.firstName,
            parameter.user.imageUrl,
            parameter.address,
            currencyFormatter.format(parameter.price),
            false,
            parameter.superHero
        )
    }
}
