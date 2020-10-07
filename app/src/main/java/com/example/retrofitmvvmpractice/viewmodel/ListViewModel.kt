package com.example.retrofitmvvmpractice.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.retrofitmvvmpractice.model.Placeholder
import com.example.retrofitmvvmpractice.model.PlaceholderService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers

class ListViewModel : ViewModel() {

    private val placeholderService=PlaceholderService()//the Placeholder Swevice contains the Retrofit call in the init block
    private val disposable=CompositeDisposable()//says that the viewmodel is using rxjava

    val placeholders = MutableLiveData<List<Placeholder>>()
    val placeholderLoadError = MutableLiveData<Boolean>()
    val loading = MutableLiveData<Boolean>()

    fun refresh() {
        fetchPlaceholders()
    }

    private fun fetchPlaceholders() {
        loading.value=true

        disposable.add(
            placeholderService.getPlaceholders()//we created this in the placeholderService class to get data and return
                .subscribeOn(Schedulers.newThread())//process being done on this thread
                .observeOn(AndroidSchedulers.mainThread())//seeing the output on the Main thread
                .subscribeWith(object :DisposableSingleObserver<List<Placeholder>>(){//what we are gonna do with the info

                    override fun onSuccess(t: List<Placeholder>) {
                       placeholders.value=t
                        placeholderLoadError.value=false
                        loading.value=false
                    }


                    override fun onError(e: Throwable) {
                        placeholderLoadError.value=true
                        loading.value=false
                    }


                })
        )
    }

   override fun onCleared() {
        super.onCleared()
       disposable.clear()

    }
}