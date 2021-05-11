package com.keshav.basictutorials.scope

class Person {
    var age: Int = 28
    var name: String = "ABC"
}

fun main() {
    runExample()
}

//    [context Object : this]  [return Type : lambda fun]
fun withExample() {
    val person = Person()
    val returnObject = with(person) {
        println(name)
        println(age)
        age + 5
    }
    println(returnObject)
}

//    [context Object : this]  [return Type : context object]
fun applyExample() {
    val person = Person().apply {
        age = 35
        name = "XYZ"
    }
    with(person) {
        println(name)
        println(age)
    }
}

//    [context Object : it]  [return Type : context object]
fun alsoExample() {
    val person = Person()
    with(person) {
        println(name)
        println(age)
    }
    val returnObject = person.also {
        if (it.age > 18) {
            println("Eligible")
        } else {
            println("Not-Eligible")
        }
        it.age + 5
    }
    println(returnObject)
}

//    [context Object : it]  [return Type : lambda fun]
fun letExample() {
    val person : Person? = Person()
    val returnObject = person?.let {
        it.age + 5
    }
    println(returnObject)
}

//    [context Object : this]  [return Type : lambda fun]
fun runExample() {
    val person : Person? = Person()
    val returnObject = person?.run {
        name = "XYZ"
        age = 30
        name.length + age
    }
    println(person?.name)
    println(returnObject)
}



