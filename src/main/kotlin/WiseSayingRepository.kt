class WiseSayingRepository {

    val wises = mutableListOf<WiseSaying>();
    var wiseCnt = 0;

    fun getIdx(id: Int) : Int {
        return wises.indexOfFirst {
                wise -> wise.num == id };
    }

    fun findById(id: Int) : WiseSaying? {
        val idx = getIdx(id);
        return wises[idx];
    }

    fun findAll() : List<WiseSaying> {
        return wises;
    }

    fun findAllByAuthorLike(author: String): List<WiseSaying> {
        return wises.filter { wise -> wise.author.contains(author) }
    }

    fun findAllByContentLike(content: String): List<WiseSaying> {
        return wises.filter { wise -> wise.content.contains(content) }
    }

    fun save(author: String, content: String) : WiseSaying {
        val newWise = WiseSaying(
            ++wiseCnt, author, content);

        wises.add(newWise)
        return newWise

    }

    fun deleteById(id: Int) : Boolean {
        val idx = getIdx(id);
        if (idx < 0) return false;
        wises.removeAt(idx);
        wiseCnt--;
        return true;
    }

}