package br.com.doghero.dhproject.network.ui

interface UiTransformer<in PARAMETER, out RESPONSE> {

    fun map(parameter: PARAMETER): RESPONSE
}
