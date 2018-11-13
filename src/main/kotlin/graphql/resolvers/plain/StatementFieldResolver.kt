package graphql.resolvers.plain

import graphql.schema.DataFetchingEnvironment
import graphql.types.Statement

class StatementFieldResolver : GraphQLResolver<Statement> {

    override val typeName: String = "Account"

    override val fieldName: String = "statement"

    private val manyStatements = listOf(
            Statement(name = "1"),
            Statement(name = "2"),
            Statement(name = "3"),
            Statement(name = "4"),
            Statement(name = "5")
    )

    override fun fieldDataFetcher(): (environment: DataFetchingEnvironment) -> Statement = {
        val x = it.getArgument<Long>("statementId")
        manyStatements[x.toInt()]
    }
}