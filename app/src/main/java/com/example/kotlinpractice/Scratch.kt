package com.example.kotlinpractice


fun main(){
    val name = ("Joselito")
    var Age = (22)
    Age = Age + 1
    var nickname: String? = null
    println(nickname?.length)

    nickname = ("Jose")
    println(nickname?.length)

    print(greetUser(name))

    for (i in 1..5){
        println(i)
    }
}

fun greetUser(name: String): String{
    return ("Welcome, " + name)
}

data class User(val username: String, var score: Int)
val collection = listOf(
    User("User1",89),
    User("User2",87),
    User("User3",90)
)

for(i in 0..2){
    println(collection[i].username + collection[i].score)
}