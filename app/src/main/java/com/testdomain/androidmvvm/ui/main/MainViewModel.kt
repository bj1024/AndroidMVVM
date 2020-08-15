package com.testdomain.androidmvvm.ui.main

import android.os.Handler
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.util.*
import kotlin.concurrent.schedule

class MainViewModel : ViewModel() {

    companion object {

        private val TAG = MainViewModel::class.qualifiedName
    }

    private val _count: MutableLiveData<Int> = MutableLiveData()


    private var mTimer: Timer? = null
    private val mHandler = Handler()
    private val _date: MutableLiveData<Date> = MutableLiveData()

    private val _lastSearchDate: Date = Date(0)
    private var _lastSearchTime:Long = 0

    val count: LiveData<Int> get() = _count
    val date: LiveData<Date> get() = _date

    init {
        _count.postValue(0)
        _date.postValue(Date())
        setTimer()

    }

    fun setTimer(){
        Timer().schedule(0,10){
            Log.d(TAG,"on timer.")
            val curdate = Date()
            val time = System.currentTimeMillis()
            if(  time - _lastSearchTime > 1000) {
                _date.postValue(Date())
                _lastSearchTime = time
            }
        }
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