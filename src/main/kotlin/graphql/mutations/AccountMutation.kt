package graphql.mutations

import graphql.Scalars
import graphql.schema.DataFetchingEnvironment
import graphql.schema.GraphQLArgument
import graphql.schema.GraphQLArgument.newArgument
import graphql.schema.GraphQLInputObjectType
import graphql.schema.GraphQLInputObjectType.newInputObject
import graphql.schema.GraphQLObjectType
import graphql.schema.GraphQLObjectType.newObject

class AccountMutation : GraphQLMutationResolver {

    override val outputType: GraphQLObjectType = newObject()
            .name("AccountOutput")
            .field {
                it.name("updated")
                it.type(Scalars.GraphQLBoolean)
            }
            .build()

    override val argumentType: GraphQLInputObjectType = newInputObject()
            .name("AccountInput")
            .field {
                it.name("name")
                it.type(Scalars.GraphQLString)
            }
            .build()

    override val argument: GraphQLArgument = newArgument()
            .name("payload")
            .type(argumentType)
            .build()

    override val mutationResolver: (DataFetchingEnvironment) -> Any = {
        println("saving...${it.arguments.entries}")
    }

    override val mutationObject: GraphQLObjectType = newObject()
            .name("saveAccount")
            .field {
                it.name("saveAccount")
                it.type(outputType)
                it.argument(argument)
                it.dataFetcher(mutationResolver)
            }.build()
}