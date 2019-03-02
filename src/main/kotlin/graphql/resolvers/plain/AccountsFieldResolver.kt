package graphql.resolvers.plain

import graphql.schema.DataFetchingEnvironment
import graphql.types.Account
import repository.AccountRepository

class AccountsFieldResolver(
    private val accountRepository: AccountRepository
) : GraphQLResolver<List<Account>> {

    override val typeName: String = "User"

    override val fieldName: String = "accounts"

    override fun fieldDataFetcher(): DataFetchingEnvironment.() -> List<Account> = {
        println("[accounts]")
        accountRepository.all()
    }
}