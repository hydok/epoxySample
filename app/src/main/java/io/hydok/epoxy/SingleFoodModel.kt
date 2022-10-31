package io.hydok.epoxy

import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.DrawableRes
import com.airbnb.epoxy.EpoxyAttribute
import com.airbnb.epoxy.EpoxyHolder
import com.airbnb.epoxy.EpoxyModelClass
import com.airbnb.epoxy.EpoxyModelWithHolder
import io.hydok.epoxy.databinding.SinglefoodLayoutBinding
import kotlin.coroutines.coroutineContext

@EpoxyModelClass(layout = R.layout.singlefood_layout)
abstract class SingleFoodModel: EpoxyModelWithHolder<SingleFoodModel.FoodHolder>() {

    @EpoxyAttribute
    var clickListener: ((String) -> Unit)? = null

    @EpoxyAttribute
    var titleStr:String? = ""

    @EpoxyAttribute
    var descStr:String? = ""

    override fun bind(holder: FoodHolder) {
        with(holder.binding){
            title.text = titleStr
            des.text = descStr

            root.setOnClickListener{
                clickListener?.let { it("$titleStr -> $descStr") }
            }
        }
    }


    inner class FoodHolder :EpoxyHolder() {
        lateinit var binding : SinglefoodLayoutBinding

        override fun bindView(itemView: View) {
            binding = SinglefoodLayoutBinding.bind(itemView)
        }

    }
}