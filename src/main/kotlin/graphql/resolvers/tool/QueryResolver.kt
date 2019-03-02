package graphql.resolvers.tool

import graphql.schema.DataFetchingEnvironment
import graphql.types.Account

class QueryResolver : GraphQLQueryResolver {

    fun account(env: DataFetchingEnvironment): Account {
        return Account(
            name = "chihQueryResolver",
            bank = "BradescoQueryResolver",
            password = "123QueryResolver"
        )
    }
}