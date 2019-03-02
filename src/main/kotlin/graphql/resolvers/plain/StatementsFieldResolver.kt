package graphql.resolvers.plain

import graphql.schema.DataFetchingEnvironment
import graphql.types.Statement
import repository.StatementRepository

class StatementsFieldResolver(
    private val statementRepository: StatementRepository
) : GraphQLResolver<List<Statement>> {

    override val typeName: String = "Account"

    override val fieldName: String = "statements"

    override fun fieldDataFetcher(): (environment: DataFetchingEnvironment) -> List<Statement> = {
        println("[statements]")
        statementRepository.all()
    }
}