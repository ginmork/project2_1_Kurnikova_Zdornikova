fun main(args: Array<Int>) {
   /* print("Введите кол-во строк: ")
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
    */

    /* val matrix = arrayOf(
        intArrayOf(5, 9, 6, 7, 2),
        intArrayOf(9, 8, 4, 5, 3),
        intArrayOf(6, 4, 3, 8, 7),
        intArrayOf(7, 5, 8, 4, 8),
        intArrayOf(2, 3, 7, 8, 1)
    )

    println("Матрица:")
    for (i in matrix.indices) {
        for (j in matrix[i].indices) {
            print("${matrix[i][j]}\t")
        }
        println()
    }

    val n = matrix.size
    var check = true;
    for (i in 0 until n) {
        for (j in i + 1 until n) {
            if (matrix[i][j] != matrix[j][i]) {
                check = false;
            } else {
                check = true;
            }
        }
    }

    if (check) {
        println("Матрица является симметричной относительно главной диагонали")
    } else {
        println("Матрица НЕ является симметричной относительно главной диагонали")
    }

    val alphabet = listOf('А', 'Б', 'В', 'Г', 'Д', 'Е', 'Ё', 'Ж', 'З', 'И', 'Й', 'К', 'Л', 'М', 'Н', 'О', 'П', 'Р', 'С', 'Т', 'У', 'Ф', 'Х', 'Ц', 'Ч', 'Ш', 'Щ', 'Ь', 'Ы', 'Ъ', 'Э', 'Ю', 'Я')
    val numbers = listOf(21, 13, 4, 20, 22, 1, 25, 12, 24, 14, 2, 28, 9, 23, 3, 29, 6, 16, 15, 11, 26, 5, 30, 27, 8, 18, 10, 33, 31, 32, 19, 7, 17)

    println("Программа шифрования/дешифрования")
    println("Выберите действие:")
    println("1 - Зашифровать текст")
    println("2 - Расшифровать текст")

    when (readLine()?.toIntOrNull()) {
        1 -> {
            print("Введите текст для шифрования: ")
            val text = readLine()?.uppercase() ?: ""
            print("Введите ключевое слово: ")
            val key = readLine()?.uppercase() ?: ""

            val encrypted = encrypt(text, key, alphabet, numbers)
            println("Зашифрованный текст: $encrypted")
        }
        2 -> {
            print("Введите текст для дешифрования: ")
            val text = readLine()?.uppercase() ?: ""
            print("Введите ключевое слово: ")
            val key = readLine()?.uppercase() ?: ""

            val decrypted = decrypt(text, key, alphabet, numbers)
            println("Расшифрованный текст: $decrypted")
        }
        else -> println("Неверный выбор")
    }
}
fun encrypt(text: String, key: String, alphabet: List<Char>, numbers: List<Int>): String {
    val result = StringBuilder()
    val keyLength = key.length

    for ((index, char) in text.withIndex()) {
        if (char == ' ') {
            result.append(' ')
            continue
        }

        val keyChar = key[index % keyLength]
        val shift = getNumberByChar(keyChar, alphabet, numbers)

        val currentNumber = getNumberByChar(char, alphabet, numbers)
        val newNumber = ((currentNumber + shift - 1) % 33) + 1

        result.append(getCharByNumber(newNumber, alphabet, numbers))
    }

    return result.toString()
}

fun decrypt(text: String, key: String, alphabet: List<Char>, numbers: List<Int>): String {
    val result = StringBuilder()
    val keyLength = key.length

    for ((index, char) in text.withIndex()) {
        if (char == ' ') {
            result.append(' ')
            continue
        }

        val keyChar = key[index % keyLength]
        val shift = getNumberByChar(keyChar, alphabet, numbers)

        val currentNumber = getNumberByChar(char, alphabet, numbers)
        val newNumber = ((currentNumber - shift - 1 + 33) % 33) + 1

        result.append(getCharByNumber(newNumber, alphabet, numbers))
    }

    return result.toString()
}

fun getNumberByChar(char: Char, alphabet: List<Char>, numbers: List<Int>): Int {
    for (i in alphabet.indices) {
        if (alphabet[i] == char) {
            return numbers[i]
        }
    }
    return 1
}
fun getCharByNumber(number: Int, alphabet: List<Char>, numbers: List<Int>): Char {
    for (i in numbers.indices) {
        if (numbers[i] == number) {
            return alphabet[i]
        }
    }
    return 'А'
    */
    println("Введите первый массив чисел через пробел ")
    val arr1 = readLine()!!.split(" ").map {it.toInt()}

    println("Введите второй массив чисел через пробел ")
    val arr2 = readLine()!!.split(" ").map {it.toInt()}

    val result = mutableListOf<Int>()
    val copy = arr2.toMutableList()

    for (num in arr1){
        if (num in copy){
            result.add(num)
            copy.remove(num)
        }
    }
}