package br.com.doghero.dhproject.myhero.viewmodel

import br.com.doghero.dhproject.myhero.service.entity.DogHeroUserDTO
import br.com.doghero.dhproject.myhero.ui.vo.HeroVO
import br.com.doghero.dhproject.network.ui.UiTransformer

internal class HeroTransformer : UiTransformer<DogHeroUserDTO, HeroVO> {

    override fun map(parameter: DogHeroUserDTO) =
        HeroVO(
            parameter.user.firstName,
            parameter.user.imageUrl,
            parameter.address,
            parameter.price.toString(),
            false,
            parameter.superHero
        )
}
