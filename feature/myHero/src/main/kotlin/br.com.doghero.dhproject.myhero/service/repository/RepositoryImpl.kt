package br.com.doghero.dhproject.myhero.service.repository

import br.com.doghero.dhproject.myhero.service.entity.MyHeroResponseDTO
import br.com.doghero.dhproject.network.ui.UiStateLiveData
import br.com.doghero.dhproject.network.ui.UiSuccess
import com.google.gson.Gson

private const val MOCK_RESPONSE =
    "{\"recents\":[{\"is_superhero\":true,\"user\":{\"first_name\":\"Eduardo\"," +
        "\"image_url\":\"https://doghero-uploads.s3.amazonaws.com/uploads/photo/" +
        "1433381/sq135_DH_24012018123600937_98895.png\"},\"address_neighborhood\":" +
        "\"Parque Chacabuco\",\"price\":55},{\"id\":53012,\"is_superhero\":false,\"user\"" +
        ":{\"first_name\":\"Maria\",\"image_url\":\"https://doghero-uploads.s3.amazonaws.com/" +
        "uploads/photo/764186/sq135_20170404094603_345722_1491353162913.jpg\"},\"address_neighborh" +
        "ood\":\"Aclimação\",\"price\":60}],\"favorites\":[{\"is_superhero\":false,\"user\":{\"" +
        "first_name\":\"Cris\",\"image_url\":\"https://doghero-uploads.s3.amazonaws.com/uploads/" +
        "photo/1088842/sq135_20170926010555_270986_1506441955458.jpg\"},\"address_neighborhood\"" +
        ":\"Vila Gomes Cardim\",\"price\":70},{\"is_superhero\":false,\"user\":{\"first_name\":" +
        "\"Gustavo\",\"image_url\":\"https://doghero-uploads.s3.amazonaws.com/uploads/photo/" +
        "242781/sq135_Cris_SA-MI.jpg\"},\"address_neighborhood\":\"Vila Mariana\",\"price\":45}" +
        ",{\"is_superhero\":true,\"user\":{\"first_name\":\"Marina\",\"image_url\":\"https://" +
        "doghero-uploads.s3.amazonaws.com/uploads/photo/1398933/sq135_1516145372035_517808_IMG" +
        "0535JPG.jpeg\"},\"address_neighborhood\":\"Vila Mariana\",\"price\":65}]}"

internal class RepositoryImpl : Repository {

    private val gson = Gson()

    override fun fetchMyHeroes(): UiStateLiveData<MyHeroResponseDTO> {

        val response = UiStateLiveData<MyHeroResponseDTO>()
        response.postValue(UiSuccess(parseResponse()))

        return response
    }

    private fun parseResponse() =
        gson.fromJson<MyHeroResponseDTO>(MOCK_RESPONSE, MyHeroResponseDTO::class.java)
}
