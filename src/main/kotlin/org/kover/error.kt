package org.kover

import kotlin.reflect.KProperty1

data class FooData(val name: String, val age: Int)

class Foo {
    fun run(): Int {
        val filter = mapOf<KProperty1<FooData, *>, Set<*>>(
            FooData::name to setOf("Tom", "Roger"),
            FooData::age to setOf(1, 2, 3)
        )

        return doSomething(filter)
    }
}

private fun doSomething(map: Map<KProperty1<FooData, *>, Set<*>>): Int {
    map.forEach { (k, v) ->
        println(k.name)
        println(v)
    }

    return 1
}