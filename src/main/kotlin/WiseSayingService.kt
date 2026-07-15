class WiseSayingService {

    private val wiseSayingRepository = WiseSayingRepository()

    fun get(id: Int) : WiseSaying? {
        return wiseSayingRepository.findById(id);
    }

    fun modify(wise: WiseSaying, author: String, content: String) {
        wise.author = author;
        wise.content = content;
    }

    fun add(author: String, content: String) : WiseSaying {
        return wiseSayingRepository.save(author, content);
    }

    fun delete(id: Int) : Boolean {
        return wiseSayingRepository.deleteById(id);
    }

    fun listByAuthor(keyword: String) : List<WiseSaying> {
        return wiseSayingRepository.findAllByAuthorLike(keyword).reversed();
    }

    fun listByContent(keyword: String) : List<WiseSaying> {
        return wiseSayingRepository.findAllByContentLike(keyword).reversed();
    }

    fun list() : List<WiseSaying> {
        return wiseSayingRepository.findAll().reversed();
    }

}