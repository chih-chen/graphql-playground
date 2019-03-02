package repository

import graphql.types.Transaction

class TransactionRepository {

    private val transactions = listOf(
        Transaction(1.0),
        Transaction(2.0),
        Transaction(3.0),
        Transaction(4.0),
        Transaction(5.0),
        Transaction(6.0),
        Transaction(7.0)
    )

    fun first() = transactions.first()

    fun all() = transactions
}