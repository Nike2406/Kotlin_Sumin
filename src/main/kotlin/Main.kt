fun main() {
    val car: Transport = Car()
    val bicycle: Transport = Bicycle()
    if (car is Car) {
        car.name = "Машина2"
    }
    // Анониманый класс
    travel(object : Transport("Автобус") {
        override fun drive() {
            println("Автобус едет")
        }
    })
}

fun travel(transport: Transport) {
    transport.drive()
}

abstract class Transport(open val name: String) {

    abstract fun drive()
}

// Возможно переопределять не только методы, но и поля
// для этого в родительстком классе определяем поле через open,
// в дочернем добавить модификатор override, и произвести
// проверку приведения типов через is
class Car(override var name: String = "Машина") : Transport(name) {
    fun startEngine(): Boolean {
        println("Запускаю двигатель...")
        return true
    }

    override fun drive() {
        println("Машина едет...")
    }
}

class Bicycle : Transport("Велосипед") {
    override fun drive() {
        println("Велосипед едет...")
    }
}