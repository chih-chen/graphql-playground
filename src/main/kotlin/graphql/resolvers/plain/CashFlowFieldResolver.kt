package graphql.resolvers.plain

import graphql.schema.DataFetchingEnvironment
import graphql.types.CashFlow
import repository.CashFlowRepository

class CashFlowFieldResolver(
    private val cashFlowRepository: CashFlowRepository
) : GraphQLResolver<CashFlow> {

    override val typeName: String = "UserInfoCollector"

    override val fieldName: String = "cashFlow"

    override fun fieldDataFetcher(): DataFetchingEnvironment.() -> CashFlow = {
        cashFlowRepository.first()
    }
}