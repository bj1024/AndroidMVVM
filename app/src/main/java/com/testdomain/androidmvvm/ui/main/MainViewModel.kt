package com.testdomain.androidmvvm.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    // TODO: Implement the ViewModel

    private val _count: MutableLiveData<Int> = MutableLiveData()


    val count: LiveData<Int> get() = _count

    init {
        _count.postValue(0)
    }


    fun countUp(){
        _count.postValue(_count.value?.plus(1))
    }
}
//
//// UserProfileViewModel
//class UserProfileViewModel(
//    savedStateHandle: SavedStateHandle
//) : ViewModel() {
//    val userId : String = savedStateHandle["uid"] ?:
//    throw IllegalArgumentException("missing user id")
//    val user : User = TODO()
//}
//
//// UserProfileFragment
//private val viewModel: UserProfileViewModel by viewModels(
//    factoryProducer = { SavedStateVMFactory(this) }
//    ...
//)
//