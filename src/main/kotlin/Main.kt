package com

class Wise(val num: Int, var author: String, var content: String) {

}

class Command {
    private var _type: String;
    private val _param = mutableMapOf<String, String>();

    constructor(command: String) {
        val commandSplit = command.split("?");
        _type = commandSplit[0];
        if (commandSplit.size < 2) return;
        val paramSplit = commandSplit[1].split("=");
        _param[paramSplit[0]] = paramSplit[1]
    }

    fun getType() = _type;
    fun getParam(paramKey: String) = _param.get(paramKey);

}

//TIP 코드를 <b>실행</b>하려면 <shortcut actionId="Run"/>을(를) 누르거나
// 에디터 여백에 있는 <icon src="AllIcons.Actions.Execute"/> 아이콘을 클릭하세요.
fun main() {
    println("== 명언 앱 ==");

    var wiseCnt = 0;
    val wises = mutableListOf<Wise>();

    while (true) {
        print("명령) ")

        val cmd = Command(readlnOrNull()?.trim() ?: "");

        if (cmd.getType() == "종료") break;
        if (cmd.getType() == "등록") {
            print("명언 : ")
            val wise = readln();
            print("작가 : ")
            val author = readln();
            wises.add(Wise(++wiseCnt, author, wise))
            println("${wiseCnt}번 명언이 등록되었습니다.")
            continue;
        }
        if (cmd.getType() == "목록") {
            println("번호 / 작가 / 명언");
            println("----------------------");

            for (wise in wises.asReversed()) {
                println("${wise.num} / ${wise.author} / ${wise.content} ");
            }
            continue;
        }
        if (cmd.getType() == "수정") {

            val editTargetId = cmd.getParam("id")?.toInt() ?: 0;

            if (editTargetId == 0) {
                continue;
            }

            val wise = wises.firstOrNull { wise -> wise.num == editTargetId }
            if (wise == null) {
                println("${editTargetId}번 명언은 존재하지 않습니다.")
                continue;
            }
            println("명언(기존) : ${wise.content}");
            print("명언 : ")
            wise.content  = readln();
            println("작가(기존) : ${wise.author}");
            print("명언 : ")
            wise.author = readln();

            continue;
        }

        val deleteTargetId = cmd.getParam("id")?.toInt() ?: 0;

        if (deleteTargetId == 0) {
            continue;
        }
        val deleteTargetIdx = wises.indexOfFirst { wise -> wise.num == deleteTargetId }
        if (deleteTargetIdx < 0) {
            println("${deleteTargetId}번 명언은 존재하지 않습니다.")
            continue;
        }
        wiseCnt--
        wises.removeAt(deleteTargetIdx);
        println("${deleteTargetId}번 명언이 삭제되었습니다.")

    }

}