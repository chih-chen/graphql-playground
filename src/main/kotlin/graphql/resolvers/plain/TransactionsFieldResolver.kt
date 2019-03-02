package graphql.resolvers.plain

import graphql.schema.DataFetchingEnvironment
import graphql.types.Transaction
import repository.TransactionRepository

class TransactionsFieldResolver(
    private val transactionRepository: TransactionRepository
) : GraphQLResolver<List<Transaction>> {

    override val typeName: String = "Statement"

    override val fieldName: String = "transactions"

    override fun fieldDataFetcher(): DataFetchingEnvironment.() -> List<Transaction> = {
        println("[transactions]")
        transactionRepository.all()
    }
}