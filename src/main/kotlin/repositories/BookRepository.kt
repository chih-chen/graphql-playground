package repositories

import models.Book

class BookRepository {

    private val bookList = listOf(
            Book("book1", listOf("author1", "author2")),
            Book("book2", listOf("author3", "author4")),
            Book("book3", listOf("author5", "author6")),
            Book("book4", listOf("author7", "author8")),
            Book("book5", listOf("author9", "author0"))
    )

    fun findAll() = bookList

    fun findByTitle(title: String) = bookList.firstOrNull {  it.title == title }
}