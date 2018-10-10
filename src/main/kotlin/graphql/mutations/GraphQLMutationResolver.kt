package graphql.mutations

import graphql.schema.DataFetchingEnvironment
import graphql.schema.GraphQLArgument
import graphql.schema.GraphQLInputObjectType
import graphql.schema.GraphQLObjectType

interface GraphQLMutationResolver {

    val outputType: GraphQLObjectType

    val mutationObject: GraphQLObjectType

    val argumentType: GraphQLInputObjectType

    val argument: GraphQLArgument

    val mutationResolver: (DataFetchingEnvironment) -> Any
}