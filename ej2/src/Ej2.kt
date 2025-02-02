class persona(peso: Double, altura: Double, var nombre: String? = null) {

    var peso: Double = peso
        private set

    var altura: Double = altura
        private set

    val imc: Double
        get() = peso / (altura * altura)

    init {
        require(peso > 0) { "El peso debe ser mayor a 0." }
        require(altura > 0) { "La altura debe ser mayor a 0." }
    }

    override fun toString(): String {
        return "Persona(nombre=$nombre, peso=$peso, altura=$altura, imc=${"%.2f".format(imc)})"
    }
}

fun main() {
    val persona1 = persona(70.5, 1.75)
    var persona2 = persona(80.0, 1.78, "Juan")
    var persona3 = persona(65.0, 1.65, "Ana")

    println(persona1)
    println(persona2)
    println(persona3)

    print("Ingrese el nombre para la persona1: ")
    val nuevoNombre = readln().trim()
    if (nuevoNombre.isNotEmpty()) {
        persona1.nombre = nuevoNombre
    }
    println("Nombre: ${persona1.nombre}, Peso: ${persona1.peso}, Altura: ${persona1.altura}")

    persona3 = persona(persona3.peso, 1.80, persona3.nombre)
    println("Peso: ${persona3.peso}, Altura: ${persona3.altura}, IMC: ${"%.2f".format(persona3.imc)}")

    persona2 = persona(persona2.peso, persona3.altura, persona2.nombre)
    println(persona2)
    println(persona3)
}
