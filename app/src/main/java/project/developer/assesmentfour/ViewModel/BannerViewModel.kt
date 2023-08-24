package project.developer.assesmentfour.ViewModel

import project.developer.assesmentfour.Banner
import project.developer.assesmentfour.Repository.BannerRepository


import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class BannerViewModel:ViewModel() {
    val bannerRepository = BannerRepository()
    val bannersLiveData= MutableLiveData<List<Banner>>()
    val errLiveData = MutableLiveData<String>()


    fun fetchBanner(){
        viewModelScope.launch {
            val response = bannerRepository.getBanners()
            if (response.isSuccessful){
                bannersLiveData.postValue(response.body()?.products)
            }
            else{
                errLiveData.postValue(response.errorBody()?.string())
            }
        }

    }


}