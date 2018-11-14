package graphql.resolvers.plain

import graphql.schema.DataFetchingEnvironment
import graphql.types.CashFlow

class CashFlowFieldResolver : GraphQLResolver<CashFlow> {

    override val typeName: String = "UserInfoCollector"
    override val fieldName: String = "cashFlow"

    override fun fieldDataFetcher(): (environment: DataFetchingEnvironment) -> CashFlow = {
        CashFlow(99.9, 11.1)
    }
}