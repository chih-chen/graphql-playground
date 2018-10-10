package graphql.mutations

import graphql.schema.DataFetchingEnvironment
import graphql.schema.GraphQLArgument
import graphql.schema.GraphQLInputObjectType
import graphql.schema.GraphQLObjectType

interface GraphQLMutationResolver<T> {

    /**
     * Name of the type from your SDL definition
     */
    val typeName: String

    /**
     * Name of the field from your schema which wants to provide data fetcher
     */
    val fieldName: String

    /**
     * Data fetcher for your field
     */
    fun fieldDataFetcher(): (environment: DataFetchingEnvironment) -> T
}