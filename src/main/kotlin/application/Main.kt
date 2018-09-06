package application

import com.coxautodev.graphql.tools.SchemaParser
import graphql.GraphQL
import repositories.BookRepository
import resolvers.QueryResolver

fun main(args: Array<String>) {

    val bookRepo = BookRepository()
    val queryResolver = QueryResolver(bookRepo)

    val schemaGenerator = SchemaParser
            .newParser()
            .file("book.graphqls")
            .resolvers(queryResolver)
            .build()
            .makeExecutableSchema()

    val graphQL = GraphQL.newGraphQL(schemaGenerator).build()

    val result = graphQL.execute("""
        query {
            allBooks {
                title
                author
            }
        }
    """.trimIndent())

    println(result.getData<String>())
}
