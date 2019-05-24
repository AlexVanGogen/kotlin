// FILE: 1.kt

inline fun f(g: (Int) -> Int) = g(2)

inline fun h() = 1

// FILE: 2.kt

fun box(): String {
    val result = f { it + h() }
    return if (result == 3) "OK" else "fail: $result"
}
