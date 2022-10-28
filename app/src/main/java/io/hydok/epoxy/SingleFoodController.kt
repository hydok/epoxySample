package io.hydok.epoxy

import com.airbnb.epoxy.AsyncEpoxyController
import com.airbnb.epoxy.Carousel
import com.airbnb.epoxy.carousel


class SingleFoodController: AsyncEpoxyController() {

    var foodItems :List<Food> = FoodDataFactory.getFoodItems(4)

    override fun buildModels() {
        var i:Long =0



        singleHeader {
            id(0)
            content("헤더1~!")
        }

        foodItems.forEach {
            singleFood {
                id(i++)
                title(it.title)
                desc(it.description)
            }
        }

        singleHeader {
            id(0)
            content("헤더2~!")
        }

        foodItems.forEach {
            singleFood {
                id(i++)
                title(it.title)
                desc(it.description)
            }
        }

        val models = foodItems.map{
            SingleFoodModel_()
                .id(i++)
                .title(it.title)
                .desc(it.description)
        }

        carousel {
            id("carousel")
            padding(Carousel.Padding.dp(0, 4, 0, 16, 8))
            models(models)
        }

    }

}