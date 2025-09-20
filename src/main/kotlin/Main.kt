fun main(args: Array<String>) {
    print("Введите кол-во строк: ")
    val rows = readln().toInt()
    print("Введите кол-во столбцов: ")
    val cols = readln().toInt()

    if (rows % 1 != 0 || rows == null) {
        println("Ошибка")
        return
    }
    if (cols % 1 != 0 || cols == null) {
        println("Ошибка")
        return
    }

    if (rows <= 0 || cols <= 0) {
        println("Число строк и столбцов должно быть положительным")
        return
    }

    var array = Array(rows) {IntArray(cols)}

    println("Введите " + (cols * rows) + " трехзначных чисел: ")
    for (i in 0 until rows) {
        for (j in 0 until cols) {
            print("Элемент [$i] [$j]: ")
            val input = readln().toIntOrNull()
            if (input == null || input < 100 || input > 999) {
                println("Ошибка, введите трехзначное число")
                return
            }
            array[i][j] = input;
        }
    }

    var countUnicNum = mutableSetOf<Char>()
    for (i in 0 until rows) {
        for (j in 0 until cols) {
            var numbers = array[i][j].toString()
            for (number in numbers) {
                countUnicNum.add(number)
            }
        }
    }

    println("Двумерный массив")
    for (i in 0 until rows) {
        for (j in 0 until cols) {
            print("${array[i][j]} ")
        }
        println()
    }

    println("В массиве использовано ${countUnicNum.size} различных цифр")

}