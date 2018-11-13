package application

import graphql.engine.GraphQLPlainEngine
import graphql.engine.GraphQLToolsEngine
import graphql.resources.Queries
import graphql.resources.SchemaRepo

fun main(args: Array<String>) {

    val schema = SchemaRepo.initialSchema

    val plainEngine = GraphQLPlainEngine(schema).engine
    val toolsEngine = GraphQLToolsEngine(schema).engine

    val result1 = plainEngine.execute(Queries.statementAndTransactionsQuery)
    val result2 = toolsEngine.execute(Queries.statementAndTransactionsQuery)

    println(result1)
    println(result2)
}
