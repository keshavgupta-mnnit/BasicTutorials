package com.keshav.basictutorials.rxjava

import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.functions.BiFunction


data class User(val id: Int, val name: String, val age: Int)

val userList = mutableListOf(
    User(1, "A", 20),
    User(2, "B", 22),
    User(3, "C", 24),
    User(4, "D", 22),
    User(5, "A", 26),
    User(6, "F", 20),
    User(7, "G", 23)
)

val idList = mutableListOf(1, 2, 3, 4, 5)

fun getUserListObservable(): Observable<User> {
    return Observable.fromIterable(userList)
}

fun getUserObservable(id: Int): Observable<User> {
    return Observable.just(userList.find { it.id == id })
}

fun getIdListObservable(): Observable<Int> {
    return Observable.fromIterable(idList)
}

fun mergeObservable(): Observable<String> {
    return Observable.zip(getUserListObservable(), getIdListObservable(), BiFunction { t1, t2 ->  return@BiFunction "${t1.name} $t2"})
}