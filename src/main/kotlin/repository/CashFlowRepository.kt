package repository

import graphql.types.CashFlow

class CashFlowRepository {

    private val cashFlows = listOf(
        CashFlow(1.0, 2.0),
        CashFlow(2.0, 4.0),
        CashFlow(3.0, 6.0),
        CashFlow(4.0, 8.0),
        CashFlow(5.0, 10.0),
        CashFlow(6.0, 12.0),
        CashFlow(7.0, 14.0)
    )

    fun first() = cashFlows.first()

    fun all() = cashFlows
}