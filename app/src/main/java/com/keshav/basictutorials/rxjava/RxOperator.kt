package com.keshav.basictutorials.rxjava

import android.util.Log
import io.reactivex.rxjava3.core.Observable

val TAG = "RxExample"

//    Every observer able to read data irrespective when they subscribed
fun coldObservable() {
    val observable: Observable<Int> = Observable.just(1, 2, 3, 4, 5)
    observable.subscribe({
        Log.d(TAG, "[Observable1] OnNext:  $it")
    }, { error ->
        Log.d(TAG, "[Observable1] OnError:  ${error.message}")
    }, {
        Log.d(TAG, "[Observable1] OnComplete:")
    })

    observable.subscribe({
        Log.d(TAG, "[Observable2] OnNext:  $it")
    }, { error ->
        Log.d(TAG, "[Observable2] OnError:  ${error.message}")
    }, {
        Log.d(TAG, "[Observable2] OnComplete:")
    })
}

//    Only observer who subscribe before connect will be able to read data
fun hotObservable() {
    val observable = Observable.just(1, 2, 3, 4, 5).publish()
    observable.subscribe({
        Log.d(TAG, "[Observable1] OnNext:  $it")
    }, { error ->
        Log.d(TAG, "[Observable1] OnError:  ${error.message}")
    }, {
        Log.d(TAG, "[Observable1] OnComplete:")
    })
    observable.connect()
    observable.subscribe({
        Log.d(TAG, "[Observable2] OnNext:  $it")
    }, { error ->
        Log.d(TAG, "[Observable2] OnError:  ${error.message}")
    }, {
        Log.d(TAG, "[Observable2] OnComplete:")
    })
}

fun distinctOperator() {
    getUserListObservable().distinct { it.name }
        .subscribe({
            Log.d(TAG, "[Observable] OnNext:  $it")
        }, { error ->
            Log.d(TAG, "[Observable] OnError:  ${error.message}")
        }, {
            Log.d(TAG, "[Observable] OnComplete:")
        })
}

//    Emit items in small groups
fun bufferOperator() {
    getUserListObservable().buffer(3)
        .subscribe({
            Log.d(TAG, "[Observable] OnNext:  $it")
        }, { error ->
            Log.d(TAG, "[Observable] OnError:  ${error.message}")
        }, {
            Log.d(TAG, "[Observable] OnComplete:")
        })
}

fun mapOperator() {
    getUserListObservable().map {
        it.age * 3
    }.subscribe({
        Log.d(TAG, "[Observable] OnNext:  $it")
    }, { error ->
        Log.d(TAG, "[Observable] OnError:  ${error.message}")
    }, {
        Log.d(TAG, "[Observable] OnComplete:")
    })
}

fun flatMapOperator() {
    getIdListObservable().flatMap {
        getUserObservable(it)
    }.subscribe({
        Log.d(TAG, "[Observable] OnNext:  $it")
    }, { error ->
        Log.d(TAG, "[Observable] OnError:  ${error.message}")
    }, {
        Log.d(TAG, "[Observable] OnComplete:")
    })
}

//merge happen only it collects item from all observables
fun mergeOperator() {
    mergeObservable().subscribe({
        Log.d(TAG, "[Observable] OnNext:  $it")
    }, { error ->
        Log.d(TAG, "[Observable] OnError:  ${error.message}")
    }, {
        Log.d(TAG, "[Observable] OnComplete:")
    })
}