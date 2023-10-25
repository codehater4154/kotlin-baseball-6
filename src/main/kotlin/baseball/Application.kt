import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

fun main() {
    Console.println("숫자 야구 게임을 시작합니다.")
    val computerNumber = generateRandomNumber()

    var isGameOver = false

    while (!isGameOver) {
        val userInput = Console.readLine("숫자를 입력해주세요: ")

        if (userInput.length != 3 || !userInput.all { it.isDigit() } || userInput.toSet().size != 3) {
            Console.println("잘못된 입력입니다. 3자리 서로 다른 숫자를 입력하세요.")
            continue
        }

        val result = checkGuess(userInput, computerNumber)

        if (result == "3스트라이크") {
            Console.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료")
            isGameOver = true
        } else {
            Console.println(result)
        }
    }

    val restartOrExit = Console.readLine("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요: ")

    if (restartOrExit == "2") {
        Console.println("애플리케이션을 종료합니다.")
    }
}

fun generateRandomNumber(): String {
    val numbers = Randoms.pickNumberInRange(1, 9, 3)
    return numbers.joinToString("")
}

fun checkGuess(userInput: String, computerNumber: String): String {
    var strikes = 0
    var balls = 0

    for (i in userInput.indices) {
        if (userInput[i] == computerNumber[i]) {
            strikes++
        } else if (userInput[i] in computerNumber) {
            balls++
        }
    }

    if (strikes == 3) {
        return "3스트라이크"


    val strikesMessage = if (strikes > 0) "$strikes스트라이크" else ""
    val ballsMessage = if (balls > 0) "$balls볼" else ""
    val nothingMessage = if (strikes == 0 && balls == 0) "낫싱" else ""

    return "$strikesMessage $ballsMessage $nothingMessage"
}

};
//done
