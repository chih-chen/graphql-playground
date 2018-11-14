package application

import com.google.gson.Gson
import graphql.engine.GraphQLPlainEngine
import graphql.engine.GraphQLToolsEngine
import graphql.resources.Queries
import graphql.resources.SchemaRepo

fun main(args: Array<String>) {

    val schema = SchemaRepo.initialSchema

    val plainEngine = GraphQLPlainEngine(schema).engine

    val result1 = plainEngine.execute(Queries.cashFlowQuery).toSpecification()

    println(Gson().toJson(result1))
}