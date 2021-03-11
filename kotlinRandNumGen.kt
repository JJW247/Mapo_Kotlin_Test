fun GenNum(): Array<Int> {
    val unpicknum = (1..45).toMutableSet()
    val rtrandnums = arrayOfNulls<Int>(7)
    for(item in 0..6){
        rtrandnums[item] = unpicknum.random()
    }
    return rtrandnums
}

fun main(args:Array<String>){
    // 초기 객체, 컬렉션, 변수 정의
    val scn: Scanner = Scanner(System.`in`)
    val maprandnum: MutableMap<Int,Array<Int>>
    // 종료 플래그
    var flaglogic = true
    // 전체 플로우
    while(flaglogic) {
        // 소개
        println("로또 번호 생성기")
        println("본 프로그램은 1부터 45까지의 숫자 중")
        println("일반 숫자 6개, 보너스 숫자 1개를 임의로 선택하여")
        println("선택하신 조합만큼의 로또 번호 조합을 제공합니다")
        println("한 조합에는 7개의 로또 번호가 포함됩니다")
        println("1조합부터 5조합까지 생성을 원하는 조합 수를 입력해주세요")
        when (val scnnum: Int = scn.nextInt()) {
            in 1..5 -> {
                for(item in 1..scnnum){
                    maprandnum.put(item,GenNum())
                }
                println("생성된 숫자는 다음과 같습니다")
                for(item in 1..scnnum){
                    println("${item}조합")
                    println("  일반 숫자 : ${maprandnum.get(0)}, ${maprandnum.get(1)}," +
                            "${maprandnum.get(2)}, ${maprandnum.get(3)}," +
                            "${maprandnum.get(4)}, ${maprandnum.get(5)}")
                    println("  보너스 숫자 : ${maprandnum.get(6)}")
                }
                println("초기화면으로 돌아가시겠습니까? (1:초기화면 / Else:종료)")
                println("----------------------------")
                when (scn.nextInt()) {
                    1 -> {
                        maprandnum.clear()
                    }
                    else -> flagLogic = false
                }
            }
            else -> {
                println("잘못된 입력입니다")
                println("1부터 5까지의 숫자를 입력해주세요")
                println("----------------------------")
            }
        }
    }
}