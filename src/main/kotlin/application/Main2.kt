package application

import graphql.engine.GraphQLPlainEngine
import graphql.resources.Queries
import graphql.resources.SchemaRepo
import graphql.utils.JsonProvider.gson
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

    val result1 = plainEngine.execute(Queries.statementAndTransactionsQuery).toSpecification()

    println(gson.toJson(result1))
}
