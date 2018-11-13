package graphql.resolvers.plain

import graphql.schema.DataFetchingEnvironment
import graphql.types.Account
import graphql.types.Statement

class QueryTypeResolver : GraphQLResolver<Account> {

    override val typeName = "Query"

    override val fieldName = "account"

    override fun fieldDataFetcher(): (environment: DataFetchingEnvironment) -> Account = {
        Account(
                name = "chihPlain",
                bank = "BradescoPlain",
                password = "123",
                statement = Statement(name = "Statament@Test")
        )
    }
}