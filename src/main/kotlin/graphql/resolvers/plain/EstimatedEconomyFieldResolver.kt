package graphql.resolvers.plain

import graphql.schema.DataFetchingEnvironment
import repository.CashFlowRepository

class EstimatedEconomyFieldResolver(
    private val cashFlowRepository: CashFlowRepository
) : GraphQLResolver<Double> {

    override val typeName: String = "UserInfoCollector"

    override val fieldName: String = "estimatedEconomy"

    override fun fieldDataFetcher(): DataFetchingEnvironment.() -> Double = {
        println("[estimatedEconomy]")
        val allExpenses = cashFlowRepository.all()
        val allIncome = allExpenses.sumByDouble { it.income }
        val allOutcome = allExpenses.sumByDouble { it.outcome }
        allIncome - allOutcome
    }
}