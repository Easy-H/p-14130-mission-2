object WiseSayingController {

    fun modify(id: Int) {

        val wise = WiseSayingService.get(id);
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

        WiseSayingService.modify(wise, author, content);
    }

    fun add() {
        print("명언 : ")
        val content = readln();
        print("작가 : ")
        val author = readln();
        val wise = WiseSayingService.add(author, content);
        println("${wise.num}번 명언이 등록되었습니다.")
    }

    fun delete(id: Int) {
        if (!WiseSayingService.delete(id)) {
            println("${id}번 명언은 존재하지 않습니다.")
            return;
        }
        println("${id}번 명언이 삭제되었습니다.")
    }

    fun printKeywordInfo(keywordType: String, keyword: String) {
        println("----------------------");
        println("검색타입 : $keywordType");
        println("검색어 : $keyword");
        println("----------------------");

    }

    fun getList(keywordType: String?, keyword: String?, page: Int, size: Int) : Page<WiseSaying> {

        if (keywordType != null && keyword != null) {
            if (keywordType == "author") {
                printKeywordInfo("author", keyword)
                return WiseSayingService.listByAuthor(keyword, page, size);
            }
            if (keywordType == "content") {
                printKeywordInfo("content", keyword)
                return WiseSayingService.listByContent(keyword, page, size);
            }

        }

        return WiseSayingService.list(page, size);
    }

    fun getPageMarker(idx: Int, page: Int) : String {
        return if (idx == page) "[$idx]" else "$idx"
    }

    fun list(keywordType: String?, keyword: String?, page: Int, size: Int) {
        val wisePage = getList(keywordType, keyword, page, size);
        println("번호 / 작가 / 명언");
        println("----------------------");

        for (wise in wisePage.element) {
            println("${wise.num} / ${wise.author} / ${wise.content} ");
        }

        println("----------------------");
        print("페이지 : ${getPageMarker(1, page)}")

        for (i in 2..(wisePage.totalCnt / size)) {
            print(" / ${getPageMarker(i, page)}")
        }
        println();


    }
}