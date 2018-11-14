package graphql.engine

import graphql.GraphQL
import graphql.directives.RestrictedDirective
import graphql.mutations.plain.AccountMutation
import graphql.mutations.plain.AccountMutation2
import graphql.resolvers.plain.AccountQueryResolver
import graphql.resolvers.plain.AccountsFieldResolver
import graphql.resolvers.plain.CashFlowFieldResolver
import graphql.resolvers.plain.StatementFieldResolver
import graphql.resolvers.plain.StatementsFieldResolver
import graphql.resolvers.plain.TransactionFieldResolver
import graphql.resolvers.plain.TransactionsFieldResolver
import graphql.resolvers.plain.UserInfoCollectorFieldResolver
import graphql.resolvers.plain.UserQueryResolver
import graphql.schema.idl.RuntimeWiring
import graphql.schema.idl.SchemaGenerator
import graphql.schema.idl.SchemaParser
import graphql.utils.directives
import graphql.utils.mutations
import graphql.utils.resolvers

class GraphQLPlainEngine(schema: String) {

    private val runtimeWiring = RuntimeWiring.newRuntimeWiring()
            .directives(RestrictedDirective())
            .resolvers(
                    AccountQueryResolver(),
                    UserQueryResolver(),
                    AccountsFieldResolver(),
                    UserInfoCollectorFieldResolver(),
                    CashFlowFieldResolver(),
                    StatementFieldResolver(),
                    StatementsFieldResolver(),
                    TransactionFieldResolver(),
                    TransactionsFieldResolver()
            )
            .mutations(AccountMutation(), AccountMutation2())
            .build()!!

    private val typeDefinitionRegistry = SchemaParser().parse(schema)

    private val graphQlSchema = SchemaGenerator().makeExecutableSchema(typeDefinitionRegistry, runtimeWiring)!!

    val engine = GraphQL.newGraphQL(graphQlSchema).build()!!
}