package graphql.resolvers.tool

import com.coxautodev.graphql.tools.GraphQLQueryResolver
import graphql.schema.DataFetchingEnvironment
import graphql.types.Account

class QueryResolver : GraphQLQueryResolver {

    fun account(env: DataFetchingEnvironment): Account {
        println(">>>>>>>>>>> LOG: QueryResolver [account] for ${env.getContext<String>()}")
        return Account(
                name = "chihQueryResolver",
                bank = "BradescoQueryResolver",
                password = "123QueryResolver",
                statement = null
        )
    }
}