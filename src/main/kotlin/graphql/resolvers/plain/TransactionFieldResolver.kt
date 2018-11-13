package graphql.resolvers.plain

import graphql.schema.DataFetchingEnvironment
import graphql.types.Transaction

class TransactionFieldResolver : GraphQLResolver<Transaction> {

    override val typeName: String = "Statement"

    override val fieldName: String = "transaction"

    override fun fieldDataFetcher(): (environment: DataFetchingEnvironment) -> Transaction {
        TODO()
    }
}