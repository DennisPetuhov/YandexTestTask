package com.example.yandextesttask

import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.delay
import kotlinx.coroutines.joinAll
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

//fun findCommonSuperClass(class1: KClass<*>, class2: KClass<*>): KClass<*>? {
//    var currentClass1: KClass<*>? = class1
//    val superClasses1 = mutableSetOf<KClass<*>>()
//
//    while (currentClass1 != null && currentClass1 != Any::class) {
//        superClasses1.add(currentClass1)
//        currentClass1 = currentClass1.supertypes.firstOrNull()?.classifier as? KClass<*>
//    }
//
//    var currentClass2: KClass<*>? = class2
//
//    while (currentClass2 != null && currentClass2 != Any::class) {
//        if (superClasses1.contains(currentClass2)) {
//            return currentClass2
//        }
//        currentClass2 = currentClass2.supertypes.firstOrNull()?.classifier as? KClass<*>
//    }
//
//    return Any::class
//}
//
//open class Animal
//open class Mammal : Animal()
//open class Bird : Animal()
//class Dog : Mammal()
//class Cat : Mammal()
//class Sparrow : Bird()
//
//fun main() {
//    val commonSuperClass = findCommonSuperClass(Dog::class, Cat::class)
//    println("Common super class of Dog and Cat is: ${commonSuperClass?.simpleName}")
//
//    val commonSuperClass2 = findCommonSuperClass(Dog::class, Sparrow::class)
//    println("Common super class of Dog and Sparrow is: ${commonSuperClass2?.simpleName}")
//}


fun main() = runBlocking {
    val parentJob = SupervisorJob()
//    val parentJob = Job()
    val errorHandler =
        CoroutineExceptionHandler { _, exception -> println("Caught exception: ${exception.message}") }
    val scope = CoroutineScope(coroutineContext + parentJob)

    val job1 = scope.launch {
        println("Job 1 started")
        delay(1000)
        println("Job 1 completed")
    }

    val job2 = scope.launch(errorHandler) {
        println("Job 2 started")
        delay(500)

        throw RuntimeException("Job 2 failed")
    }
    job2.invokeOnCompletion { cause ->
        if (cause != null) println("Job 2 completed with cause: $cause") else println(
            "Job 2 completed successfully"
        )
    }

    val job3 = scope.launch {
        println("Job 3 started")
        delay(1500)
        println("Job 3 completed")
    }


    // Wait for the completion of all jobs
    joinAll(job1, job2, job3)
    println("All jobs are completed")
}