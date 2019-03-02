package repository

import graphql.types.Statement

class StatementRepository {

    private val statements = listOf(
        Statement(name = "statement1"),
        Statement(name = "statement2"),
        Statement(name = "statement3"),
        Statement(name = "statement4"),
        Statement(name = "statement5"),
        Statement(name = "statement6"),
        Statement(name = "statement7")
    )

    fun findById(id: Int) = statements[id]

    fun first() = statements.first()

    fun all() = statements
}