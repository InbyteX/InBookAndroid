package com.inbyte.inbook.view.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.inbyte.inbook.data.Post
import com.inbyte.inbook.repo.MainRepository
import com.inbyte.inbook.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val mainRepository: MainRepository
) : ViewModel() {

    private val _res = MutableLiveData<Resource<Response<List<Post>>>>()

    val res: LiveData<Resource<Response<List<Post>>>>
        get() = _res

    init {
        getPosts()
    }

    fun getPosts() = viewModelScope.launch {
        _res.postValue(Resource.loading(null))
        try {
            mainRepository.getPosts().let {
                if (it.isSuccessful) {
                    _res.postValue(Resource.success(it))
                } else {
                    _res.postValue(Resource.error("", null))
                }
            }
        } catch(e: Exception){
            _res.postValue(Resource.error("", null))
        }

    }
}