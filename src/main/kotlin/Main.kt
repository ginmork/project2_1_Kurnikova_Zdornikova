fun main(args: Array<String>) {
    while (true) {
        println("Введите номер задачи (1-5, 0 - выход): ")
        var choice = readln()
        when (choice) {
            "1" -> {
                task1()
            }

            "2" -> {
                task2()
            }

            "3" -> {
                task3()
            }

            "4" -> {
                task4()
            }

            "5" -> {
                task5()
            }

            "0" -> return
            else -> println("Введено неправильное значение")
        }
    }
}
private fun task1() {

        var rows: Int
        var cols: Int

        do {
            print("Введите кол-во строк: ")
            rows = readln().toIntOrNull()?: 0
            print("Введите кол-во столбцов: ")
            cols = readln().toIntOrNull()?: 0
            if (rows == null || cols == null || rows <= 0 || cols <= 0) {
                println("Ошибка, неверный ввод")
            }
        } while (rows == null || cols == null || rows <= 0 || cols <= 0)

            var array = Array(rows) { IntArray(cols) }

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
private fun task2() {
    val matrix = arrayOf(
        intArrayOf(5, 9, 6, 7, 2),
        intArrayOf(9, 8, 4, 5, 3),
        intArrayOf(6, 4, 3, 8, 7),
        intArrayOf(7, 5, 8, 4, 8),
        intArrayOf(2, 3, 7, 9, 1)
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
                check = false
                break
            }
            if (!check) break
        }
    }

        if (check) {
            println("Матрица является симметричной относительно главной диагонали")
        } else {
            println("Матрица НЕ является симметричной относительно главной диагонали")
        }
    }

private fun task3() {
        val alphabet = arrayOf('А', 'Б', 'В', 'Г', 'Д', 'Е', 'Ё', 'Ж', 'З', 'И', 'Й', 'К', 'Л', 'М', 'Н', 'О', 'П', 'Р', 'С', 'Т', 'У', 'Ф', 'Х', 'Ц', 'Ч', 'Ш', 'Щ', 'Ь', 'Ы', 'Ъ', 'Э', 'Ю', 'Я')
        val numbers = arrayOf(21, 13, 4, 20, 22, 1, 25, 12, 24, 14, 2, 28, 9, 23, 3, 29, 6, 16, 15, 11, 26, 5, 30, 27, 8, 18, 10, 33, 31, 32, 19, 7, 17)

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

    fun encrypt(text: String, key: String, alphabet: Array<Char>, numbers: Array<Int>): String {
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

    fun decrypt(text: String, key: String, alphabet: Array<Char>, numbers: Array<Int>): String {
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

    fun getNumberByChar(char: Char, alphabet: Array<Char>, numbers: Array<Int>): Int {
        for (i in alphabet.indices) {
            if (alphabet[i] == char) {
                return numbers[i]
            }
        }
        return 1
    }

    fun getCharByNumber(number: Int, alphabet: Array<Char>, numbers: Array<Int>): Char {
        for (i in numbers.indices) {
            if (numbers[i] == number) {
                return alphabet[i]
            }
        }
        return 'А'
    }

private fun task4() {
    println("Введите первый массив чисел через пробел ")
    val input1 = readLine()!!
    val arr1 = mutableListOf<Int>()
    for (numStr in input1.split(" ")) {
        if (numStr.isNotEmpty()) {
            arr1.add(numStr.toInt())
        }
    }

    println("Введите второй массив чисел через пробел ")
    val input2 = readLine()!!
    val arr2 = mutableListOf<Int>()
    for (numStr in input2.split(" ")) {
        if (numStr.isNotEmpty()) {
            arr2.add(numStr.toInt())
        }
    }

    val result = mutableListOf<Int>()
    val copy = arr2.toMutableList()

    for (num in arr1) {
        if (copy.contains(num)) {
            result.add(num)
            copy.remove(num)
        }
    }

    println("Пересечение: ${result.toIntArray().contentToString()}")

}

private fun task5() {
        println("Введите слова через пробел:")
        val input = readLine()!!

        val words = input.split(" ")

        val sortedWords = Array(words.size) { "" }

        for (i in words.indices) {
            val word = words[i]
            val letters = word.toCharArray()
            letters.sort()
            sortedWords[i] = String(letters)
        }

        val used = BooleanArray(words.size) { false }

        val groups = mutableListOf<Array<String>>()
        for (i in words.indices) {

            if (!used[i]) {

                val currentGroup = mutableListOf<String>()

                currentGroup.add(words[i])

                used[i] = true

                for (j in i + 1 until words.size) {

                    if (!used[j] && sortedWords[i] == sortedWords[j]) {

                        currentGroup.add(words[j])

                        used[j] = true
                    }
                }

                groups.add(currentGroup.toTypedArray())
            }
        }

        println("\nГруппы слов с одинаковыми буквами:")
        for (group in groups) {
            println(group.joinToString(", "))
        }
    }