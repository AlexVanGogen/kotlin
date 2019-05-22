package sample

actual class A1 {
    actual val x = 0f as Number
}

val <T> T.x2 get() = 0 <!UNCHECKED_CAST("Int", "T")!>as T<!>

actual class A2<K> {
    actual var x = (0 <!UNCHECKED_CAST("Int", "K")!>as K<!>).x2
}

actual class A3<K> : Iterable<K> {
    actual override fun iterator() = TODO()
    actual protected val y = null <!UNCHECKED_CAST("Nothing?", "K")!>as K<!>
}

actual enum class A4 {
    ;
    actual val x = 10
}

actual enum class A5(actual val x: Int)

actual enum class A6 <!ACTUAL_WITHOUT_EXPECT("Actual constructor of 'A6'", "")!>actual constructor(actual val x: Int)<!>

actual sealed class A7 {
    actual <!INAPPLICABLE_LATEINIT_MODIFIER("is not allowed on properties with initializer")!>lateinit<!> var x: Any = 10
}

actual sealed class A8 {
    <!ACTUAL_WITHOUT_EXPECT("Actual property 'x'", " The following declaration is incompatible because modifiers are different (const, lateinit):     public expect final var x: Any ")!>actual <!INAPPLICABLE_LATEINIT_MODIFIER("is not allowed on properties with initializer")!>lateinit<!><!> var x: Any = 10
}

actual open class <!ACTUAL_WITHOUT_EXPECT("Actual class 'A9'", "")!>A9<!><T> where T : Comparable<T> {

}

actual object <!NO_ACTUAL_CLASS_MEMBER_FOR_EXPECTED_CLASS("A12", "      public open expect fun compareTo(other: Int): [ERROR : Error function type]      The following declaration is incompatible because return type is different:         public open actual fun compareTo(other: Int): Nothing ")!>A12<!> : Comparable<Int> {
    actual override fun <!ACTUAL_WITHOUT_EXPECT("Actual function 'compareTo'", " The following declaration is incompatible because return type is different:     public open expect fun compareTo(other: Int): [ERROR : Error function type] ")!>compareTo<!>(other: Int) = TODO()
    actual const val x = 10
}
