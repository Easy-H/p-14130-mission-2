class WiseSayingService {

    private val wiseSayingRepository = WiseSayingRepository()

    fun get(id: Int) : WiseSaying? {
        val idx = wiseSayingRepository.getIdx(id);
        if (idx < 0) return null;
        return wiseSayingRepository.getByIdx(idx);
    }

    fun modify(wise: WiseSaying, author: String, content: String) {
        wiseSayingRepository.modify(wise, author, content);
    }

    fun add(author: String, content: String) : WiseSaying {
        return wiseSayingRepository.add(author, content);
    }

    fun delete(id: Int) : Boolean {
        return wiseSayingRepository.delete(id);
    }

    fun list() : List<WiseSaying> {
        return wiseSayingRepository.getAll().reversed();
    }

}