package com.yuriykyus.walry.app

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer

sealed class ViewState<out T> {
    class Success<T>(val data: T, val paging: Paging = Paging.NONE) : ViewState<T>()

    class Error<T>(val isShowError: Boolean = true, val error: Throwable? = null) : ViewState<T>()

    class Progress<T>(val isShowProgress: Boolean = true) : ViewState<T>()

    inline fun onSuccess(block: (data: T) -> Unit) {
        if (this is Success) block(this.data)
    }

    inline fun onSuccess(block: (data: T, paging: Paging) -> Unit) {
        if (this is Success) block(this.data, this.paging)
    }

    inline fun onProgress(block: (isShowProgress: Boolean) -> Unit) {
        if (this is Progress) block(this.isShowProgress)
    }

    inline fun onError(block: (error: Throwable?, isShowError: Boolean) -> Unit) {
        if (this is Error) block(this.error, this.isShowError)
    }

    enum class Paging {
        NONE, START, END
    }
}

fun <T> LiveData<ViewState<T>>.observeViewState(viewLifecycleOwner: LifecycleOwner, block: ViewState<T>.() -> Unit) {
    observe(viewLifecycleOwner, Observer {
        block(it)
    })
}

fun <T> LiveData<ViewState<T>>.observeViewStateOnce(lifecycleOwner: LifecycleOwner, block: ViewState<T>.() -> Unit) {
    observe(lifecycleOwner, object : Observer<ViewState<T>> {
        override fun onChanged(t: ViewState<T>) {
            block(t)
            if (t !is ViewState.Progress) {
                removeObserver(this)
            }
        }
    })
}

fun <T> MutableLiveData<ViewState<T>>.setSuccess(value: T, paging: ViewState.Paging = ViewState.Paging.NONE) {
    this.value = ViewState.Success(value, paging)
}

fun <T> MutableLiveData<ViewState<T>>.setProgress(isShowProgress: Boolean = true) {
    this.value = ViewState.Progress(isShowProgress)
}

fun <T> MutableLiveData<ViewState<T>>.setError(error: Throwable? = null, isShowError: Boolean = true) {
    this.value = ViewState.Error(isShowError, error)
}

fun <T> MutableLiveData<ViewState<T>>.postSuccess(value: T, paging: ViewState.Paging = ViewState.Paging.NONE) {
    this.postValue(ViewState.Success(value, paging))
}

fun <T> MutableLiveData<ViewState<T>>.postProgress(isShowProgress: Boolean = true) {
    this.postValue(ViewState.Progress(isShowProgress))
}

fun <T> MutableLiveData<ViewState<T>>.postError(error: Throwable? = null, isShowError: Boolean = true) {
    this.postValue(ViewState.Error(isShowError, error))
}

fun <T> LiveData<ViewState<T>>.getSuccess(): T? {
    return (value as? ViewState.Success)?.data
}

internal fun <T> LiveData<T>.toMutable(): MutableLiveData<T> {
    if (this is MutableLiveData) {
        return this
    } else {
        error("This LiveData is not mutable")
    }
}

