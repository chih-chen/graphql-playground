import graphql.GraphQL

import graphql.schema.idl.RuntimeWiring
import graphql.schema.idl.SchemaGenerator
import graphql.schema.idl.SchemaParser

fun main(args: Array<String>) {

    val schema = SchemaRepo.initialSchema

    val runtimeWiring = RuntimeWiring.newRuntimeWiring()
            .directive("restricted", RestrictedDirective())
            .type("Query") {
                it.dataFetcher("account", AccountFetcher().getData())
            }
            .build()

    val typeDefinitionRegistry = SchemaParser().parse(schema)
    val graphQlSchema = SchemaGenerator().makeExecutableSchema(typeDefinitionRegistry, runtimeWiring)
    val buildSchema = GraphQL.newGraphQL(graphQlSchema).build()

    val result = buildSchema.execute("""
        query {
            account {
                name
                bank
                password
            }
        }
    """.trimIndent())
    println(result.getData<String>())
}
