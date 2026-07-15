import kotlin.math.min

class Page<T>(val element: List<T>, val totalCnt: Int) { }

object WiseSayingRepository {

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

    fun makePage(wiseList: List<WiseSaying>, page: Int, size: Int) : Page<WiseSaying> {
        return Page(wiseList.slice(
            min((page - 1) * size, wiseList.size)..<min(page * size, wiseList.size)
        ), wiseList.size)
    }

    fun findAll(page: Int, size: Int) : Page<WiseSaying> {
        return makePage(wises.reversed(), page, size);
    }

    fun findAllByAuthorLike(author: String, page: Int, size: Int): Page<WiseSaying> {
        val retval = wises.filter { wise -> wise.author.contains(author) }
        return makePage(retval.reversed(), page, size);
    }

    fun findAllByContentLike(content: String, page: Int, size: Int): Page<WiseSaying> {
        val retval = wises.filter { wise -> wise.content.contains(content) }
        return makePage(retval.reversed(), page, size);
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