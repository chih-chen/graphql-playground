package graphql.resolvers.plain

import graphql.schema.DataFetchingEnvironment
import graphql.types.UserInfoCollector

class UserInfoCollectorFieldResolver : GraphQLResolver<UserInfoCollector> {

    override val typeName: String = "User"
    override val fieldName: String = "userInfoCollector"

    override fun fieldDataFetcher(): (environment: DataFetchingEnvironment) -> UserInfoCollector = {
        println("[userInfoCollector]")
        UserInfoCollector("CALCULATING...")
    }
}