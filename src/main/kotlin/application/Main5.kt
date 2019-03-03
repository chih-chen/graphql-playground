package application

import graphql.dataloader.TransactionBatchLoader
import graphql.engine.GraphQLPlainEngine
import graphql.resources.Queries
import graphql.resources.SchemaRepo
import graphql.utils.JsonProvider.gson
import org.dataloader.DataLoader
import org.dataloader.DataLoaderRegistry
import repository.AccountRepository
import repository.CashFlowRepository
import repository.StatementRepository
import repository.TransactionRepository
import repository.UserRepository

fun main(args: Array<String>) {

    val schema = SchemaRepo.initialSchema
    val userRepository = UserRepository()
    val accountRepository = AccountRepository()
    val statementRepository = StatementRepository()
    val transactionRepository = TransactionRepository()
    val cashFlowRepository = CashFlowRepository()

    val plainEngine = GraphQLPlainEngine(
        schema = schema,
        userRepository = userRepository,
        accountRepository = accountRepository,
        cashFlowRepository = cashFlowRepository,
        statementRepository = statementRepository,
        transactionRepository = transactionRepository
    ).engine

    val transactionDataLoader = DataLoader
        .newDataLoader(TransactionBatchLoader.transactionBatchLoader)

    val dataLoaderRegistry = DataLoaderRegistry().apply {
        register("transactions", transactionDataLoader)
    }

    val result1 = plainEngine.execute {
        it.query(Queries.statementAndTransactionsQuery)
        it.dataLoaderRegistry(dataLoaderRegistry)
    }.toSpecification()

    println(gson.toJson(result1))
}
