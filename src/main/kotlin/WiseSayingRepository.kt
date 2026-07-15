class WiseSayingRepository {

    val wises = mutableListOf<WiseSaying>();
    var wiseCnt = 0;

    fun modify(wise: WiseSaying, author: String, content: String) {
        wise.author = author;
        wise.content = content;
    }

    fun getByIdx(idx: Int) : WiseSaying {
        return wises[idx];
    }

    fun getAll() : List<WiseSaying> {
        return wises;
    }

    fun getIdx(id: Int) : Int {
        return wises.indexOfFirst {
            wise -> wise.num == id };
    }

    fun add(author: String, content: String) : WiseSaying {
        val newWise = WiseSaying(
            ++wiseCnt, author, content);

        wises.add(newWise)
        return newWise

    }

    fun delete(id: Int) : Boolean {
        val idx = getIdx(id);
        if (idx < 0) return false;
        wises.removeAt(idx);
        wiseCnt--;
        return true;
    }

}