import directives.RestrictedDirective
import graphql.GraphQL

import graphql.schema.idl.RuntimeWiring
import graphql.schema.idl.SchemaGenerator
import graphql.schema.idl.SchemaParser
import resolvers.QueryTypeResolver
import schemas.SchemaRepo

fun main(args: Array<String>) {

    val schema = SchemaRepo.initialSchema

    val runtimeWiring = RuntimeWiring.newRuntimeWiring()
            .directives(RestrictedDirective())
            .resolvers(QueryTypeResolver())
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
