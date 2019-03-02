package graphql.resolvers.plain

import graphql.schema.DataFetchingEnvironment
import graphql.types.Account

class AccountQueryResolver : GraphQLResolver<Account> {

    override val typeName = "Query"

    override val fieldName = "account"

    override fun fieldDataFetcher(): (environment: DataFetchingEnvironment) -> Account = {
        println("[account]")
        Account(
            name = "chihPlain",
            bank = "BradescoPlain",
            password = "123"
        )
    }
}