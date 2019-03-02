package graphql.resolvers.plain

import graphql.schema.DataFetchingEnvironment
import graphql.types.Statement
import repository.StatementRepository

class StatementFieldResolver(
    private val statementRepository: StatementRepository
) : GraphQLResolver<Statement> {

    override val typeName: String = "Account"

    override val fieldName: String = "statement"

    override fun fieldDataFetcher(): DataFetchingEnvironment.() -> Statement = {
        println("[statement]")
        val statementId = getArgument<Int>("statementId")
        statementRepository.findById(statementId)
    }
}