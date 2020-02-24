package app.plantdiary.individualassignment3048q.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import app.plantdiary.individualassignment3048q.dto.Country
import app.plantdiary.individualassignment3048q.Service.CountryService

class MainViewModel : ViewModel() {
    private var countryList: MutableLiveData<ArrayList<Country>> = MutableLiveData()
    private var countryService: CountryService = CountryService()

    val countries: MutableLiveData<List<Country>> by lazy {
        MutableLiveData<List<Country>>().also {
            fetchCountries()
        }
    }

    fun fetchCountries() {
        countryList = countryService.fetchCountries()
    }
}