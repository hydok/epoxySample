package io.hydok.epoxy

import android.view.View
import android.widget.TextView
import androidx.annotation.DrawableRes
import com.airbnb.epoxy.EpoxyAttribute
import com.airbnb.epoxy.EpoxyHolder
import com.airbnb.epoxy.EpoxyModelClass
import com.airbnb.epoxy.EpoxyModelWithHolder

@EpoxyModelClass(layout = R.layout.singlefood_header_layout)
abstract class SingleHeaderModel: EpoxyModelWithHolder<SingleHeaderModel.FoodHolder>() {

    @EpoxyAttribute
    var content:String? = ""

    override fun bind(holder: FoodHolder) {
        holder.contentView.text = content

    }


    inner class FoodHolder :EpoxyHolder() {
        lateinit var contentView: TextView


        override fun bindView(itemView: View) {
            contentView = itemView.findViewById(R.id.content)
        }

    }
}