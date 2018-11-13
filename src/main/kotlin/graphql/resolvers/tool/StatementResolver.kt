package graphql.resolvers.tool

import com.coxautodev.graphql.tools.GraphQLResolver
import graphql.schema.DataFetchingEnvironment
import graphql.types.Statement
import graphql.types.Transaction

class StatementResolver : GraphQLResolver<Statement> {

    fun transaction(statement: Statement, transactionId: Long, env: DataFetchingEnvironment): Transaction {
        println(">>>>>>>>>>> LOG: AccountResolver for ${env.getContext<String>()}")
        return Transaction(12.2)
    }

    fun transactions(statement: Statement, env: DataFetchingEnvironment): List<Transaction> {
        return listOf(Transaction(12.11), Transaction(11.11))
    }
}