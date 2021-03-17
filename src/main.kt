import java.util.*
import kotlin.math.sqrt

fun main() {

    println("аX^2+bX+c=0")
    println("To find X input a,b,c: ")

    val scanner = Scanner(System.`in`)
    val expression: Expression = Expression(scanner.nextDouble(), scanner.nextDouble(), scanner.nextDouble())
    if (!expression.zeroChecker(expression.a)) {
        val discriminant: Discriminant = Discriminant(expression.a, expression.b, expression.c)
        Calculation(expression.a, expression.b, discriminant.d)
    }
}

class Calculation(_a: Double, _b: Double, _d: Double) {
    private val a = _a
    private val b = _b
    private val d = _d

    init {
        if (d > 0) {
            val results: DisMoreThenZero = DisMoreThenZero(a, b, d)
            println("x1 = ${results.x1},x2 = ${results.x2}")
        } else if (d == 0.0) {
            DisZero(a, b)
            val result: DisZero = DisZero(a, b)
            println("x= ${result.x0}")
        }
    }


    class DisMoreThenZero(_a: Double, _b: Double, _d: Double) {
        private val a = _a
        private val b = _b
        private val d = _d
        var x1: Double = 0.0
        var x2: Double = 0.0

        init {
            x1 = (-b + sqrt(d)) / (2 * a)
            x2 = (-b - sqrt(d)) / (2 * a)
        }
    }

    class DisZero(_a: Double, _b: Double) {
        private val a = _a
        private val b = _b
        var x0: Double = 0.0

        init {
            x0 = (-b) / 2 * a
        }
    }
}


class Discriminant(_a: Double, _b: Double, _c: Double) {

    private val a = _a
    private val b = _b
    private val c = _c
    var d: Double = 0.0

    init {
        d = b * b - 4 * a * c
    }

}

class Expression(_a: Double, _b: Double, _c: Double) {

    val a = _a
    val b = _b
    val c = _c

    init {
        if (zeroChecker(a)) {
            println("a can't be 0")
        }
    }

    fun zeroChecker(_a: Double): Boolean {
        return _a == 0.0
    }
}

