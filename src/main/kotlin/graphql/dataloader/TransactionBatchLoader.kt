package graphql.dataloader

import org.dataloader.BatchLoader
import repository.TransactionRepository
import java.util.concurrent.CompletableFuture

object TransactionBatchLoader {

    private val repo = TransactionRepository()

    val transactionBatchLoader = BatchLoader<Int, Any> {
        CompletableFuture.supplyAsync { repo.findAllIn(it) }
    }
}