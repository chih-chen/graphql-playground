package graphql.mutations

import graphql.schema.DataFetchingEnvironment
import graphql.types.Account

class AccountMutation2 : GraphQLMutationResolver<Account> {


    override val typeName = "Mutation"

    override val fieldName = "saveAccount2"

    override fun fieldDataFetcher(): (DataFetchingEnvironment) -> Account = {
        println("saving arguments2... ${it.getArgument<Map<String, String>>("payload")}")
        Account("${it.getArgument<Map<String, String>>("payload")["name"]}2", "updatedBank2", "updatedPassword2")
    }

//    override val outputType: GraphQLObjectType = GraphQLObjectType.newObject()
//            .name("AccountOutput")
//            .field {
//                it.name("updated")
//                it.type(Scalars.GraphQLBoolean)
//            }
//            .build()
//
//    override val argumentType: GraphQLInputObjectType = GraphQLInputObjectType.newInputObject()
//            .name("AccountInput")
//            .field {
//                it.name("name")
//                it.type(Scalars.GraphQLString)
//            }
//            .build()
//
//    override val argument: GraphQLArgument = GraphQLArgument.newArgument()
//            .name("payload")
//            .type(argumentType)
//            .build()
//
//    override val mutationResolver: (DataFetchingEnvironment) -> Any = {
//        println("saving2...${it.arguments.entries}")
//        mapOf("updated" to true)
//    }
//
//    override val mutationObject: GraphQLObjectType = GraphQLObjectType.newObject()
//            .name("saveAccount2")
//            .field {
//                it.name("saveAccount2")
//                it.type(outputType)
//                it.argument(argument)
//                it.dataFetcher(mutationResolver)
//            }.build()
}