package graphql.resolvers.plain

import graphql.schema.DataFetchingEnvironment
import graphql.types.Transaction

class TransactionsFieldResolver : GraphQLResolver<List<Transaction>> {

    override val typeName: String = "Statement"
    override val fieldName: String = "transactions"

    override fun fieldDataFetcher(): (environment: DataFetchingEnvironment) -> List<Transaction> = {
        println("[transactions]")
        listOf(Transaction(1.99), Transaction(5.5))
    }
}