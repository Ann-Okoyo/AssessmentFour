
package project.developer.assesmentFour.model

import project.developer.assesmentfour.Banner

data class BannerResponse(
    var products:List<Banner>,
    var total:Int,
    var skip:Int,
    var payment:Int,
)