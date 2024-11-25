package com.example.coleramsey_comp304lab3_ex

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.coleramsey_comp304lab3_ex.data.api.RetrofitClient
import com.example.coleramsey_comp304lab3_ex.repositories.WeatherRepository
import com.example.coleramsey_comp304lab3_ex.ui.WeatherApp
import com.example.coleramsey_comp304lab3_ex.ui.theme.ColeRamsey_COMP304Lab3_ExTheme
import com.example.coleramsey_comp304lab3_ex.viewmodels.WeatherViewModel


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val repository = WeatherRepository(apiService = RetrofitClient.apiService)
        val viewModel = WeatherViewModel(repository)

        setContent {
            ColeRamsey_COMP304Lab3_ExTheme {
                WeatherApp(viewModel)
            }
        }
    }
}
