import directives.DirectiveWiring
import graphql.schema.idl.RuntimeWiring.Builder
import resolvers.GraphQLResolver


fun Builder.directives(vararg directives: DirectiveWiring): Builder {
    directives.forEach { directive ->
        this.directive(directive.directiveName, directive)
    }
    return this
}

fun Builder.resolvers(vararg resolvers: GraphQLResolver<*>): Builder {
    resolvers.forEach { resolver ->
        this.type(resolver.typeName) {
            it.dataFetcher(resolver.fieldName, resolver.fieldDataFetcher())
        }
    }
    return this
}