package com.pabloapk.acme.ui.login

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.pabloapk.acme.data.model.UserEntity
import com.pabloapk.acme.data.repository.IsucorpRepository
import com.pabloapk.acme.utils.Resource
import kotlinx.coroutines.launch

class LoginViewModel(private val repository: IsucorpRepository) : ViewModel() {
    private val _getUserLoginDataStatus = MutableLiveData<Resource<UserEntity>>()

    val getUserLoginDataStatus: MutableLiveData<Resource<UserEntity>> = _getUserLoginDataStatus

    fun getUserLoginDataStatus(username:String, password:String) {
        viewModelScope.launch {
            _getUserLoginDataStatus.postValue(Resource.loading(null))
            try {
                val data = repository.verifyLoginUser(username, password)
                _getUserLoginDataStatus.postValue(Resource.success(data, 0))
            } catch (exception: Exception) {
                _getUserLoginDataStatus.postValue(Resource.error(null, exception.message!!))
            }
        }
    }

    class LoginViewModelFactory(private val loginRepository: IsucorpRepository)
        : ViewModelProvider.Factory{
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(LoginViewModel::class.java)){
                @Suppress("UNCHECKED_CAST")
                return LoginViewModel(loginRepository) as T
            }
            throw IllegalArgumentException("Unknown VieModel Class")
        }
    }

}