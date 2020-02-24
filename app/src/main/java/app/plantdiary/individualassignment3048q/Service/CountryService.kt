package app.plantdiary.individualassignment3048q.Service

import androidx.lifecycle.MutableLiveData
import app.plantdiary.individualassignment3048q.RetrofitClientInstance
import app.plantdiary.individualassignment3048q.dto.Country
import app.plantdiary.individualassignment3048q.dao.CountryDAO
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CountryService {
    fun fetchCountries() : MutableLiveData<ArrayList<Country>> {
        var _countries = MutableLiveData<ArrayList<Country>>()
        val service = RetrofitClientInstance.retrofitInstance?.create(CountryDAO::class.java)
        val call = service?.getAllCountries()
        call?.enqueue(object : Callback<ArrayList<Country>> {
            override fun onFailure(call: Call<ArrayList<Country>>, t: Throwable) {
                TODO("not implemented")
                val failure = " The url was unreachable"
            }
            override fun onResponse(
                call: Call<ArrayList<Country>>,
                response: Response<ArrayList<Country>>
            ) {
                _countries.value = response.body()
            }
        })
        return _countries
    }
}