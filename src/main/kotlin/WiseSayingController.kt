class WiseSayingController {

    private val wiseSayingService = WiseSayingService();

    fun modify(id: Int) {

        val wise = wiseSayingService.get(id);
        if (wise == null) {
            println("${id}번 명언은 존재하지 않습니다.")
            return;
        }
        println("명언(기존) : ${wise.content}");
        print("명언 : ")
        val content = readln();

        println("작가(기존) : ${wise.author}");
        print("작가 : ")
        val author = readln();

        wiseSayingService.modify(wise, author, content);
    }

    fun add() {
        print("명언 : ")
        val content = readln();
        print("작가 : ")
        val author = readln();
        val wise = wiseSayingService.add(author, content);
        println("${wise.num}번 명언이 등록되었습니다.")
    }

    fun delete(id: Int) {
        if (!wiseSayingService.delete(id)) {
            println("${id}번 명언은 존재하지 않습니다.")
            return;
        }
        println("${id}번 명언이 삭제되었습니다.")
    }

    fun list() {
        println("번호 / 작가 / 명언");
        println("----------------------");

        for (wise in wiseSayingService.list()) {
            println("${wise.num} / ${wise.author} / ${wise.content} ");
        }

    }
}