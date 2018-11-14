package graphql.resolvers.plain

import graphql.schema.DataFetchingEnvironment
import graphql.types.Account
import graphql.types.Statement

class AccountsFieldResolver : GraphQLResolver<List<Account>> {

    override val typeName: String = "User"

    override val fieldName: String = "accounts"

    private val manyAccounts = listOf(
            Account(name = "1", bank = "a", password = "1a"),
            Account(name = "2", bank = "b", password = "2b"),
            Account(name = "3", bank = "c", password = "3c"),
            Account(name = "4", bank = "d", password = "4d"),
            Account(name = "5", bank = "e", password = "5e")
    )

    override fun fieldDataFetcher(): (environment: DataFetchingEnvironment) -> List<Account> = {
        println("[accounts]")
        manyAccounts
    }
}