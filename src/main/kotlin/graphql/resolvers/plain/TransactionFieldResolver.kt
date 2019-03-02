package graphql.resolvers.plain

import graphql.schema.DataFetchingEnvironment
import graphql.types.Transaction
import repository.TransactionRepository

class TransactionFieldResolver(
    private val transactionRepository: TransactionRepository
) : GraphQLResolver<Transaction> {

    override val typeName: String = "Statement"

    override val fieldName: String = "transaction"

    override fun fieldDataFetcher(): DataFetchingEnvironment.() -> Transaction = {
        println("[transaction]")
        transactionRepository.first()
    }
}