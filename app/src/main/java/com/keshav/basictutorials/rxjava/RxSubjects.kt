package com.keshav.basictutorials.rxjava

import android.util.Log
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.subjects.AsyncSubject
import io.reactivex.rxjava3.subjects.BehaviorSubject
import io.reactivex.rxjava3.subjects.PublishSubject
import io.reactivex.rxjava3.subjects.ReplaySubject
import java.util.concurrent.TimeUnit

fun runSubject() {
    replaySubject()
}

//AsynSubject will emitt only last value of stream or error
private fun asyncSubject() {
    val observable = Observable.interval(1, TimeUnit.SECONDS).takeWhile { it <= 5 }
    val subject = AsyncSubject.create<Long>()
    observable.subscribe(subject)

    subject.subscribe({
        Log.d(TAG, "1 - OnNext:  $it")
    }, { error ->
        Log.d(TAG, "1 - OnError:  ${error.message}")
    }, {
        Log.d(TAG, "1 - OnComplete")
    })

    subject.subscribe({
        Log.d(TAG, "2 - OnNext:  $it")
    }, { error ->
        Log.d(TAG, "2 - OnError:  ${error.message}")
    }, {
        Log.d(TAG, "2 - OnComplete")
    })
}

//PublishSubject will emitt from after its point of subscription
//RxExample: 1 - OnNext:  2
//RxExample: 1 - OnNext:  3
//RxExample: 1 - OnNext:  4
//RxExample: 2 - OnNext:  4
//RxExample: 1 - OnNext:  5
//RxExample: 2 - OnNext:  5
private fun publishSubject() {
    val subject = PublishSubject.create<Long>()
    subject.onNext(1)

    subject.subscribe({
        Log.d(TAG, "1 - OnNext:  $it")
    }, { error ->
        Log.d(TAG, "1 - OnError:  ${error.message}")
    }, {
        Log.d(TAG, "1 - OnComplete")
    })
    subject.onNext(2)
    subject.onNext(3)

    subject.subscribe({
        Log.d(TAG, "2 - OnNext:  $it")
    }, { error ->
        Log.d(TAG, "2 - OnError:  ${error.message}")
    }, {
        Log.d(TAG, "2 - OnComplete")
    })
    subject.onNext(4)
    subject.onNext(5)
}

//BehaviorSubject will emitt from most recent item till its completion
//RxExample: 1 - OnNext:  1
//RxExample: 1 - OnNext:  2
//RxExample: 1 - OnNext:  3
//RxExample: 2 - OnNext:  3
//RxExample: 1 - OnNext:  4
//RxExample: 2 - OnNext:  4
//RxExample: 1 - OnNext:  5
//RxExample: 2 - OnNext:  5
private fun behaviorSubject() {
    val subject = BehaviorSubject.create<Long>()
    subject.onNext(1)

    subject.subscribe({
        Log.d(TAG, "1 - OnNext:  $it")
    }, { error ->
        Log.d(TAG, "1 - OnError:  ${error.message}")
    }, {
        Log.d(TAG, "1 - OnComplete")
    })
    subject.onNext(2)
    subject.onNext(3)

    subject.subscribe({
        Log.d(TAG, "2 - OnNext:  $it")
    }, { error ->
        Log.d(TAG, "2 - OnError:  ${error.message}")
    }, {
        Log.d(TAG, "2 - OnComplete")
    })
    subject.onNext(4)
    subject.onNext(5)
}

//ReplaySubject will emitt all the items
//RxExample: 1 - OnNext:  1
//RxExample: 1 - OnNext:  2
//RxExample: 1 - OnNext:  3
//RxExample: 2 - OnNext:  1
//RxExample: 2 - OnNext:  2
//RxExample: 2 - OnNext:  3
//RxExample: 1 - OnNext:  4
//RxExample: 2 - OnNext:  4
//RxExample: 1 - OnNext:  5
//RxExample: 2 - OnNext:  5
private fun replaySubject(){
    val subject = ReplaySubject.create<Long>()
    subject.onNext(1)

    subject.subscribe({
        Log.d(TAG, "1 - OnNext:  $it")
    }, { error ->
        Log.d(TAG, "1 - OnError:  ${error.message}")
    }, {
        Log.d(TAG, "1 - OnComplete")
    })
    subject.onNext(2)
    subject.onNext(3)

    subject.subscribe({
        Log.d(TAG, "2 - OnNext:  $it")
    }, { error ->
        Log.d(TAG, "2 - OnError:  ${error.message}")
    }, {
        Log.d(TAG, "2 - OnComplete")
    })
    subject.onNext(4)
    subject.onNext(5)
}