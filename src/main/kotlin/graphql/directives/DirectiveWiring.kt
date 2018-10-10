package graphql.directives

import graphql.schema.idl.SchemaDirectiveWiring

interface DirectiveWiring : SchemaDirectiveWiring {

    val directiveName: String
}