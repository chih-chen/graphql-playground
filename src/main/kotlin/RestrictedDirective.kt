import graphql.schema.DataFetcher
import graphql.schema.GraphQLFieldDefinition
import graphql.schema.idl.SchemaDirectiveWiring
import graphql.schema.idl.SchemaDirectiveWiringEnvironment

class RestrictedDirective : SchemaDirectiveWiring {

    override fun onField(environment: SchemaDirectiveWiringEnvironment<GraphQLFieldDefinition>): GraphQLFieldDefinition {
        val targetRole = environment.directive.getArgument("role").value

        val field = environment.element
        val originalFetcher = field.dataFetcher

        val restrictedFetcher = DataFetcher {

            if(targetRole == "admin")
                originalFetcher.get(it)
            else

        }

        return field.transform { builder ->
            builder.dataFetcher(restrictedFetcher)
        }
    }


}