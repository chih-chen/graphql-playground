package graphql

import graphql.directives.DirectiveWiring
import graphql.mutations.GraphQLMutationResolver
import graphql.schema.idl.RuntimeWiring.Builder
import graphql.resolvers.GraphQLResolver
import graphql.schema.GraphQLSchema

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

fun GraphQLSchema.Builder.mutations(vararg mutations: GraphQLMutationResolver): GraphQLSchema.Builder {
    mutations.forEach { mutation ->
        this.mutation(mutation.mutationObject)
    }
    return this
}