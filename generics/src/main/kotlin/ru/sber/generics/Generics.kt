package ru.sber.generics

// 1.
fun <K, V> compare(p1: Pair<K, V>, p2: Pair<K, V>): Boolean = p1.first == p2.first &&  p1.second == p2.second

// 2.
fun <T: Comparable<T>> countGreaterThan(anArray: Array<T>, elem: T): Int = anArray.count { it > elem }

// 3.
class Sorter<T: Comparable<T>> {
    val list: MutableList<T> = mutableListOf()

    fun add(value: T) {
        list.add(value)
        list.sort()
    }
}

// 4.
class Stack<T> {

    private val elems: MutableList<T> = mutableListOf()

    fun push(v: T) = elems.add(v)

    fun pop(): T = elems.removeLast()

    fun isEmpty(): Boolean = elems.isEmpty()

    fun peek(): T = elems.last()

    fun size(): Int = elems.size

}