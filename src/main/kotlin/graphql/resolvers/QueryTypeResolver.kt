package graphql.resolvers

import graphql.schema.DataFetchingEnvironment
import graphql.types.Account

class QueryTypeResolver : GraphQLResolver<Account> {
    override val typeName = "Query"

    override val fieldName = "account"

    override fun fieldDataFetcher(): (environment: DataFetchingEnvironment) -> Account = {
        Account("chih", "Bradesco", "123")
    }
}