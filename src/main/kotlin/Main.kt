package com

import Command
import WiseSayingController

//TIP 코드를 <b>실행</b>하려면 <shortcut actionId="Run"/>을(를) 누르거나
// 에디터 여백에 있는 <icon src="AllIcons.Actions.Execute"/> 아이콘을 클릭하세요.
fun main() {
    println("== 명언 앱 ==");

    val wiseSayingController = WiseSayingController();

    while (true) {
        print("명령) ")

        val cmd = Command(readlnOrNull()?.trim() ?: "");

        if (cmd.getType() == "종료") break;
        if (cmd.getType() == "등록") {
            wiseSayingController.add()
            continue;
        }
        if (cmd.getType() == "목록") {
            wiseSayingController.list(
                cmd.getParam("keywordType"),
                cmd.getParam("keyword")
            )
            continue;
        }
        if (cmd.getType() == "수정") {
            wiseSayingController.modify(
                cmd.getParamToInt("id", 0));

            continue;
        }
        if (cmd.getType() == "수정")
        {
            wiseSayingController.delete(
                cmd.getParamToInt("id", 0));
            continue;
        }
        println("잘못된 명령어입니다.");

    }

}