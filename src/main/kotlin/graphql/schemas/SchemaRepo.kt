package graphql.schemas

object SchemaRepo {

    val initialSchema = """

        directive @restricted(role: String!) on FIELD_DEFINITION

        type Account {
            name: String!
            bank: String
            password: String! @restricted(role: "X")
        }

        type Query {
            account: Account
        }

        input AccountInput {
            name: String
        }

        type AccountOutput {
            updated: Boolean
        }

        type Mutation {
            saveAccount(payload: AccountInput): AccountOutput
        }

        schema {
            query: Query
            mutation: Mutation
        }

    """.trimIndent()
}

