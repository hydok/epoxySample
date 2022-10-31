package io.hydok.epoxy

import com.airbnb.epoxy.AsyncEpoxyController
import com.airbnb.epoxy.Carousel
import com.airbnb.epoxy.carousel


class SingleFoodController: AsyncEpoxyController() {

    private var foodItems :List<Food> = FoodDataFactory.getFoodItems(4)
    private var foodItems2 :List<Food> = FoodDataFactory.getFoodItems(3)
    private var foodItems3 :List<Food> = FoodDataFactory.getFoodItems(7)

    override fun buildModels() {
        var i:Long =0


        singleHeader {
            id(i)
            title("Header1")
        }

        foodItems.forEach {
            singleFood {
                id(i++)
                titleStr(it.title)
                descStr(it.description)
            }
        }

        singleHeader {
            id(i)
            title("Header2")
        }

        foodItems2.forEach {
            singleFood {
                id(i++)
                titleStr(it.title)
                descStr(it.description)
            }
        }

        val models = foodItems3.map{
            SingleFoodModel_()
                .id(i++)
                .titleStr(it.title)
                .descStr(it.description)
        }

        carousel {
            id("carousel")
            padding(Carousel.Padding.dp(0, 4, 0, 16, 8))
            models(models)
        }

    }

}