package com.example.flickrdemo.features.photos.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.room.EmptyResultSetException
import com.example.flickrdemo.features.photos.data.model.PhotosListServerResponse
import com.example.flickrdemo.features.photos.data.repository.PhotosListRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import java.io.IOException

class PhotosListViewModel(private val photosListRepository: PhotosListRepository) : ViewModel() {

    var progressBarLoading: MutableLiveData<Boolean> = MutableLiveData()
    val errorMessage: MutableLiveData<String> = MutableLiveData()
    var currentPage: Int = 1


    private val compositeDisposable: CompositeDisposable = CompositeDisposable()

    init {
        progressBarLoading.value = true
    }

    fun getPhotosList(page: Int) {
        compositeDisposable.add(
            photosListRepository.getPhotosList(page)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe { photosListServerResponse: PhotosListServerResponse?, throwable: Throwable? ->
                    progressBarLoading.value = false
                    photosListServerResponse?.let {
                        currentPage = it.pageNumber + 1
                    }
                    throwable?.let {
                        handleExceptions(it)
                    }
                }
        )
    }

    private fun handleExceptions(throwable: Throwable) {
        when (throwable) {
            is IOException -> errorMessage.value = "Network Error"
            is EmptyResultSetException -> errorMessage.value = "No Cached Results"
        }
    }

    override fun onCleared() {
        compositeDisposable.clear()
    }

}