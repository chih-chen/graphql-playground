package graphql.mutations

import graphql.Scalars
import graphql.schema.DataFetchingEnvironment
import graphql.schema.GraphQLArgument
import graphql.schema.GraphQLInputObjectType
import graphql.schema.GraphQLObjectType

class AccountMutation2 : GraphQLMutationResolver {

    override val outputType: GraphQLObjectType = GraphQLObjectType.newObject()
            .name("AccountOutput")
            .field {
                it.name("updated")
                it.type(Scalars.GraphQLBoolean)
            }
            .build()

    override val argumentType: GraphQLInputObjectType = GraphQLInputObjectType.newInputObject()
            .name("AccountInput")
            .field {
                it.name("name")
                it.type(Scalars.GraphQLString)
            }
            .build()

    override val argument: GraphQLArgument = GraphQLArgument.newArgument()
            .name("payload")
            .type(argumentType)
            .build()

    override val mutationResolver: (DataFetchingEnvironment) -> Any = {
        println("saving2...${it.arguments.entries}")
        mapOf("updated" to true)
    }

    override val mutationObject: GraphQLObjectType = GraphQLObjectType.newObject()
            .name("saveAccount2")
            .field {
                it.name("saveAccount2")
                it.type(outputType)
                it.argument(argument)
                it.dataFetcher(mutationResolver)
            }.build()
}