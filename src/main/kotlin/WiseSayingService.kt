object WiseSayingService {

    fun get(id: Int) : WiseSaying? {
        return WiseSayingRepository.findById(id);
    }

    fun modify(wise: WiseSaying, author: String, content: String) {
        wise.author = author;
        wise.content = content;
    }

    fun add(author: String, content: String) : WiseSaying {
        return WiseSayingRepository.save(author, content);
    }

    fun delete(id: Int) : Boolean {
        return WiseSayingRepository.deleteById(id);
    }

    fun listByAuthor(keyword: String, page: Int, size: Int) : Page<WiseSaying> {
        return WiseSayingRepository.findAllByAuthorLike(keyword, page, size);
    }

    fun listByContent(keyword: String, page: Int, size: Int) : Page<WiseSaying> {
        return WiseSayingRepository.findAllByContentLike(keyword, page, size);
    }

    fun list(page: Int, size: Int) : Page<WiseSaying> {
        return WiseSayingRepository.findAll(page, size);
    }

}