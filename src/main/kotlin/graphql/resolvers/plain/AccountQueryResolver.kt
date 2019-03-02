package graphql.resolvers.plain

import graphql.schema.DataFetchingEnvironment
import graphql.types.Account
import repository.AccountRepository

class AccountQueryResolver(
    private val accountRepository: AccountRepository
) : GraphQLResolver<Account> {

    override val typeName = "Query"

    override val fieldName = "account"

    override fun fieldDataFetcher(): DataFetchingEnvironment.() -> Account = {
        println("[account]")
        accountRepository.first()
    }
}