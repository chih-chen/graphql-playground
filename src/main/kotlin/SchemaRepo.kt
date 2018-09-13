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

        schema {
            query: Query
        }

    """.trimIndent()
}

