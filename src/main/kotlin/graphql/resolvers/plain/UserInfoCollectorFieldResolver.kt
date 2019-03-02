package graphql.resolvers.plain

import graphql.schema.DataFetchingEnvironment

class UserInfoCollectorFieldResolver : GraphQLResolver<Unit> {

    override val typeName: String = "User"

    override val fieldName: String = "userInfoCollector"

    override fun fieldDataFetcher(): DataFetchingEnvironment.() -> Unit = {
        println("[userInfoCollector]")
    }
}