import graphql.schema.DataFetchingEnvironment


class AccountFetcher {

    fun getData(): (environment: DataFetchingEnvironment) -> Map<String, String> {
        return {
            mapOf("name" to "chih",
                    "bank" to "Bradesco",
                    "password" to "123")
        }
    }

    private fun account(name: String) = Account("chih", "Bradesco", "123")
}

data class Account(val name: String, val bank: String, val password: String)
