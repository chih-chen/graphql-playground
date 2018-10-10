import graphql.GraphQL
import graphql.directives
import graphql.directives.RestrictedDirective
import graphql.mutations
import graphql.mutations.AccountMutation
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
            .mutations(AccountMutation())
            .build()

    val buildSchema = GraphQL.newGraphQL(graphQLFullSchema).build()

    val result = buildSchema.execute("""
        query {
            account {
                name
                bank
                password
            }
        }
    """.trimIndent())
    println(result.toSpecification())
}
