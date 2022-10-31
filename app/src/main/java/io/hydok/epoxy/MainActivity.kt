package io.hydok.epoxy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import io.hydok.epoxy.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {


    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    private val singleFoodController: SingleFoodController by lazy {
        SingleFoodController(foodClick)
    }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.rv.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            setHasFixedSize(true)
            adapter = singleFoodController.adapter
        }

        singleFoodController.requestModelBuild()
    }

    var foodClick: (String) -> Unit = {
        Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
    }


}