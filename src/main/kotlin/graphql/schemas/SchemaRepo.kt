package graphql.schemas

object SchemaRepo {

    val initialSchema = """

        directive @restricted(role: String!) on FIELD_DEFINITION

        type Account {
            name: String!
            bank: String
            password: String! @restricted(role: "admin")
        }

        type Query {
            account: Account
        }

        input AccountInput {
            name: String
        }

        type Mutation {
            saveAccount(payload: AccountInput): Account
            saveAccount2(payload: AccountInput): Account
        }

        schema {
            query: Query
            mutation: Mutation
        }

    """.trimIndent()
}

