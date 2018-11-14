package graphql.resolvers.plain

import graphql.schema.DataFetchingEnvironment
import graphql.types.User

class UserQueryResolver : GraphQLResolver<User> {

    override val typeName = "Query"

    override val fieldName = "user"

    override fun fieldDataFetcher(): (environment: DataFetchingEnvironment) -> User = {
        println("[user]")
        User("Chih")
    }
}