package graphql.resolvers.plain

import graphql.schema.DataFetchingEnvironment
import graphql.types.Transaction
import repository.TransactionRepository
import java.util.concurrent.CompletableFuture

class TransactionFieldResolver(
    private val transactionRepository: TransactionRepository
) : GraphQLResolver<CompletableFuture<Transaction>> {

    override val typeName: String = "Statement"

    override val fieldName: String = "transaction"

    override fun fieldDataFetcher(): DataFetchingEnvironment.() -> CompletableFuture<Transaction> = {
        println("[transaction]")
        val transactionId = getArgument<Int>("transactionId")
        val dataloader = getDataLoader<Int, Transaction>("transactions")
        dataloader.load(transactionId)
    }
}