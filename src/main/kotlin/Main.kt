import graphql.GraphQL
import graphql.directives
import graphql.directives.RestrictedDirective
import graphql.mutations
import graphql.mutations.AccountMutation
import graphql.mutations.AccountMutation2
import graphql.resolvers
import graphql.resolvers.QueryTypeResolver
import graphql.schema.GraphQLSchema
import graphql.schema.idl.RuntimeWiring
import graphql.schema.idl.SchemaGenerator
import graphql.schema.idl.SchemaParser
import graphql.schemas.SchemaRepo

fun main(args: Array<String>) {

    val schema = SchemaRepo.initialSchema

    val runtimeWiring = RuntimeWiring.newRuntimeWiring()
            .directives(RestrictedDirective())
            .resolvers(QueryTypeResolver())
            .build()

    val typeDefinitionRegistry = SchemaParser()
            .parse(schema)

    val graphQlSchema = SchemaGenerator().makeExecutableSchema(typeDefinitionRegistry, runtimeWiring)

    val graphQLFullSchema = GraphQLSchema
            .newSchema(graphQlSchema)
            .mutations(AccountMutation(), AccountMutation2())
            .build()

    val buildSchema = GraphQL.newGraphQL(graphQLFullSchema).build()

    val result = buildSchema.execute("""

        mutation SaveAccountMutation {
            a: saveAccount(payload: {name: "Chih"} ) {
                updated
            }
            b: saveAccount(payload: {name: "Chen"} ) {
                updated
            }
        }
    """.trimIndent())
    println(result.toSpecification())
}
