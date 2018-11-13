package graphql.resolvers.tool

import com.coxautodev.graphql.tools.GraphQLResolver
import graphql.schema.DataFetchingEnvironment
import graphql.types.Account
import graphql.types.Statement

class StatementResolver : GraphQLResolver<Account> {

    private val manyStatements = listOf(
            Statement(name = "1"),
            Statement(name = "2"),
            Statement(name = "3"),
            Statement(name = "4"),
            Statement(name = "5")
    )

    fun statement(account: Account, statementId: Long, env: DataFetchingEnvironment): Statement {
        println(">>>>>>>>>>> LOG: StatementResolver for ${env.getContext<String>()}")
        return manyStatements[statementId.toInt().plus(1)]
    }
}