package resolvers

import com.coxautodev.graphql.tools.GraphQLQueryResolver
import repositories.BookRepository

class QueryResolver(private val bookRepository: BookRepository) : GraphQLQueryResolver {

    fun allBooks() = bookRepository.findAll()

    fun book(title: String) = bookRepository.findByTitle(title)
}