package graphql.resolvers.plain

import graphql.schema.DataFetchingEnvironment
import graphql.types.User
import repository.UserRepository

class UserQueryResolver(
    private val userRepository: UserRepository
) : GraphQLResolver<User> {

    override val typeName = "Query"

    override val fieldName = "user"

    override fun fieldDataFetcher(): DataFetchingEnvironment.() -> User = {
        println("[user]")
        userRepository.first()
    }
}