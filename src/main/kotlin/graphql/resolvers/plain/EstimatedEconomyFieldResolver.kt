package graphql.resolvers.plain

import graphql.schema.DataFetchingEnvironment

class EstimatedEconomyFieldResolver : GraphQLResolver<String> {

    override val typeName: String = "UserInfoCollector"
    override val fieldName: String = "estimatedEconomy"

    override fun fieldDataFetcher(): (environment: DataFetchingEnvironment) -> String = {
        println("[estimatedEconomy]")
        "CALCULATING..."
    }
}