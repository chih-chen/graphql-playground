package graphql.resolvers.plain

import graphql.schema.DataFetchingEnvironment
import graphql.types.Statement

class StatementsFieldResolver : GraphQLResolver<List<Statement>> {

    override val typeName: String = "Account"

    override val fieldName: String = "statements"

    private val manyStatements = listOf(
            Statement(name = "1"),
            Statement(name = "2"),
            Statement(name = "3"),
            Statement(name = "4"),
            Statement(name = "5")
    )

    override fun fieldDataFetcher(): (environment: DataFetchingEnvironment) -> List<Statement> = {
        println("[statements]")
        manyStatements
    }
}