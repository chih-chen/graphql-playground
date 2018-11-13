package graphql.types

data class Account(
        val name: String,
        val bank: String,
        val password: String,
        val statement: Statement?,
        val statements: List<Statement> = emptyList()
)
