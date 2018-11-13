package application

import graphql.engine.GraphQLPlainEngine
import graphql.engine.GraphQLToolsEngine
import graphql.resources.Queries
import graphql.resources.SchemaRepo

fun main(args: Array<String>) {

    val schema = SchemaRepo.initialSchema

    val plainEngine = GraphQLPlainEngine(schema).engine
    val toolsEngine = GraphQLToolsEngine(schema).engine

//    val result1 = plainEngine.execute(Queries.saveManualAccountMutation)
//    val result2 = toolsEngine.execute(Queries.saveManualAccountMutation)

//    val result3 = toolsEngine.execute {
//        it.context("queryWithoutNestedObject")
//        it.query(Queries.queryWithoutNestedObject)
//    }

//    val result4 = toolsEngine.execute {
//        it.context("queryWithNestedObject")
//        it.query(Queries.queryWithNestedObject)
//    }

//    val result5 = toolsEngine.execute {
//        it.context("statementsQuery")
//        it.query(Queries.statementsQuery)
//    }

    val result6 = plainEngine.execute {
        it.context("statementsQuery - Plain engine")
        it.query(Queries.statementsQuery)
    }

//    println("saveManualAccountMutation 1: ${result1.toSpecification()}")
//    println("saveManualAccountMutation 2: ${result2.toSpecification()}")

//    println("queryWithoutNestedObject: ${result3.toSpecification()}")
//    println("queryWithNestedObject: ${result4.toSpecification()}")
//    println("statementsQuery: ${result5.toSpecification()}")
    println("statementsQuery: ${result6.toSpecification()}")
}
