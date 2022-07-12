fun main() {
    val address1 = Address("Kazan", "Spartakovskaya", 2)
    val address2 = address1.copy()
    val (cityName, avenueName, houseNumber) = address1
    println(
        """
        address1: $address1,
        address2: $address2,
        address1 city: ${address1.cityName}, avenue: ${address1.avenueName}, house: ${address1.houseNumber}
        address2 city: ${address2.cityName}, avenue: ${address2.avenueName}, house: ${address2.houseNumber}
        address1 hashCode: ${address1.hashCode()}
        address2 hashCode: ${address2.hashCode()}
        equals: ${address1.equals(address2)}
    """.trimIndent()
    )
    println("$cityName $avenueName $houseNumber")
}

class Address(
    val cityName: String,
    val avenueName: String,
    val houseNumber: Int,
) {
    operator fun component1() = cityName
    operator fun component2() = avenueName
    operator fun component3() = houseNumber

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Address

        if (cityName != other.cityName) return false
        if (avenueName != other.avenueName) return false
        if (houseNumber != other.houseNumber) return false

        return true
    }

    override fun hashCode(): Int {
        var result = cityName.hashCode()
        result = 31 * result + avenueName.hashCode()
        result = 31 * result + houseNumber
        return result
    }

    fun copy(
        cityName:String = this.cityName,
        avenueName:String = this.avenueName,
        houseNumber:Int = this.houseNumber,
    ): Address {
        return Address(cityName, avenueName, houseNumber)
    }

    override fun toString(): String {
        return "Address(cityName='$cityName', avenueName='$avenueName', houseNumber=$houseNumber)"
    }
}
