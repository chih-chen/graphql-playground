package graphql.engine

import com.coxautodev.graphql.tools.SchemaParser
import graphql.GraphQL
import graphql.mutations.tool.MutationResolver
import graphql.resolvers.tool.QueryResolver
import graphql.resolvers.tool.StatementResolver

class GraphQLToolsEngine(schema: String) {

    private val schemaParser = SchemaParser
            .newParser()
            .schemaString(schema)
            .resolvers(QueryResolver(), MutationResolver(), StatementResolver())
            .build()
            .makeExecutableSchema()

    val engine = GraphQL.newGraphQL(schemaParser).build()!!

}