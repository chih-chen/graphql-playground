package application

import graphql.GraphQL
import graphql.utils.directives
import graphql.directives.RestrictedDirective
import graphql.utils.mutations
import graphql.mutations.AccountMutation
import graphql.mutations.AccountMutation2
import graphql.utils.resolvers
import graphql.resolvers.QueryTypeResolver
import graphql.schema.idl.RuntimeWiring
import graphql.schema.idl.SchemaGenerator
import graphql.schema.idl.SchemaParser
import graphql.schemas.SchemaRepo

fun main(args: Array<String>) {

    val schema = SchemaRepo.initialSchema

    val runtimeWiring = RuntimeWiring.newRuntimeWiring()
            .directives(RestrictedDirective())
            .resolvers(QueryTypeResolver())
            .mutations(AccountMutation(), AccountMutation2())
            .build()

    val typeDefinitionRegistry = SchemaParser().parse(schema)

    val graphQlSchema = SchemaGenerator().makeExecutableSchema(typeDefinitionRegistry, runtimeWiring)

    val buildSchema = GraphQL.newGraphQL(graphQlSchema).build()

    val result = buildSchema.execute("""

        mutation SaveAccountMutation {
            a: saveAccount(payload: {name: "Jony"} ) {
                name
            }
            b: saveAccount(payload: {name: "Terry"} ) {
                name
                bank
                password
            }
            c: saveAccount2(payload: {name: "Jaina"}) {
                name
                bank
            }
        }

    """.trimIndent())
    println(result.toSpecification())
}
