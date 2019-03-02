package graphql.directives

import graphql.schema.DataFetcher
import graphql.schema.GraphQLFieldDefinition
import graphql.schema.idl.SchemaDirectiveWiringEnvironment

class RestrictedDirective : DirectiveWiring {

    override val directiveName: String = "restricted"

    override fun onField(environment: SchemaDirectiveWiringEnvironment<GraphQLFieldDefinition>): GraphQLFieldDefinition {
        val targetRole = environment.directive.getArgument("role").value

        val field = environment.element
        val originalFetcher = field.dataFetcher

        val restrictedFetcher = DataFetcher {

            if (targetRole == "admin")
                originalFetcher.get(it)
            else
                "null"
        }

        return field.transform { builder ->
            builder.dataFetcher(restrictedFetcher)
        }
    }
}