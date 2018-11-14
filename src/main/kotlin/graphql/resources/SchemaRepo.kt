package graphql.resources

object SchemaRepo {

    val initialSchema = """

        directive @restricted(role: String!) on FIELD_DEFINITION

        type User {
            username: String!
            accounts: [Account!]!
            userInfoCollector: UserInfoCollector
        }

        type UserInfoCollector {
            estimatedEconomy: String
            cashFlow: CashFlow
        }

        type CashFlow {
            income: Float!
            outcome: Float!
        }

        type Account {
            name: String!
            bank: String
            password: String! @restricted(role: "admin")
            statement(statementId: Long): Statement
            statements: [Statement!]!
        }

        type Statement {
            name: String!
            transaction(transactionId: Long): Transaction
            transactions: [Transaction!]!
        }

        type Transaction {
            value: Float
        }

        type Query {
            account: Account
            user(userId: Long): User!
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

