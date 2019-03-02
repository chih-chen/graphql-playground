package graphql.mutations.plain

import graphql.schema.DataFetchingEnvironment
import graphql.types.Account

class AccountMutation : GraphQLMutationResolver<Account> {

    override val typeName = "Mutation"

    override val fieldName = "saveAccount"

    override fun fieldDataFetcher(): (DataFetchingEnvironment) -> Account = {
        println("saving arguments... ${it.getArgument<Map<String, String>>("payload")}")
        Account(
            name = "${it.getArgument<Map<String, String>>("payload")["name"]}",
            bank = "updatedBank",
            password = "updatedPassword"
        )
    }


//
//    override val outputType: GraphQLObjectType = newObject()
//            .name("AccountOutput")
//            .field {
//                it.name("updated")
//                   it.type(Scalars.GraphQLBoolean)
//            }
//            .build()
//
//    override val argumentType: GraphQLInputObjectType = newInputObject()
//            .name("AccountInput")
//            .field {
//                it.name("name")
//                it.type(Scalars.GraphQLString)
//            }
//            .build()
//
//    override val argument: GraphQLArgument = newArgument()
//            .name("payload")
//            .type(argumentType)
//            .build()
//
//    override val mutationResolver: (DataFetchingEnvironment) -> Any = {
//        println("saving2...${it.arguments.entries}")
//        mapOf("updated" to false)
//    }
//
//    override val mutationObject: GraphQLObjectType = newObject()
//            .name("saveAccount")
//            .field {
//                it.name("saveAccount")
//                it.type(outputType)
//                it.argument(argument)
//                it.dataFetcher(mutationResolver)
//            }.build()
}