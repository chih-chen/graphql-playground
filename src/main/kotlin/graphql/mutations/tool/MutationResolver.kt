package graphql.mutations.tool

import graphql.types.Account

class MutationResolver : GraphQLMutationResolver {

    fun saveAccount(payload: AccountInput): Account {
        println("saving arguments 1 ... $payload")
        return Account(
            name = payload.name,
            bank = "updatedBank",
            password = "updatedPassword"
        )
    }

    fun saveAccount2(payload: AccountInput): Account {
        println("saving arguments 2 ... $payload")
        return Account(
            name = payload.name,
            bank = "updatedBank",
            password = "updatedPassword"
        )
    }
}

data class AccountInput(val name: String)