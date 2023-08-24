package project.developer.assesmentfour.Repository

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import project.developer.assesmentFour.model.BannerResponse
import project.developer.assesmentfour.Api.ApiClient
import project.developer.assesmentfour.Api.ApiInterface
import retrofit2.Response

class BannerRepository {
    //    make our api call
    val apiClient = ApiClient.buildApiClient(ApiInterface::class.java)

    suspend fun getBanners(): Response<BannerResponse> {
        return withContext(Dispatchers.IO){
            apiClient.getProducts()
        }
    }
}