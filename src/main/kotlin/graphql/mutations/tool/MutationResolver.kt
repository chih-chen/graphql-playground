package graphql.mutations.tool

import com.coxautodev.graphql.tools.GraphQLMutationResolver
import graphql.types.Account
import graphql.types.Statement

class MutationResolver : GraphQLMutationResolver {

    fun saveAccount(payload: AccountInput): Account {
        println("saving arguments 1 ... $payload")
        return Account(
                name = payload.name,
                bank = "updatedBank",
                password = "updatedPassword",
                statement = Statement("Statement@Test")
        )
    }

    fun saveAccount2(payload: AccountInput): Account {
        println("saving arguments 2 ... $payload")
        return Account(
                name = payload.name,
                bank = "updatedBank",
                password = "updatedPassword",
                statement = Statement("Statement@Test2")
        )
    }
}

data class AccountInput(val name: String)