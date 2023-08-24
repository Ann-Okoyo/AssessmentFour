package project.developer.assesmentfour.Api



import project.developer.assesmentFour.model.BannerResponse
import project.developer.assesmentfour.Banner
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiInterface {
    @GET("/banner")
    suspend fun getProducts():Response<BannerResponse>
    @GET("/banner/{id}")
    suspend fun getProductById(@Path("id")productId:Int):Response<Banner>


}