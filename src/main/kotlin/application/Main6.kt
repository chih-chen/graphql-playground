package application

import com.google.gson.Gson
import graphql.ExecutionInput
import graphql.GraphQL
import graphql.schema.idl.RuntimeWiring
import graphql.schema.idl.SchemaGenerator
import graphql.schema.idl.SchemaParser

fun main(args: Array<String>) {

    val gson = Gson()
    val repo = MockRepo()

    val schema = """

        schema {
            query: Query
        }

        type Query {
            pokemon(name: String!): Pokemon
        }

        type Pokemon {
            name: String!
            age: Int!
        }

    """.trimIndent().run {
        SchemaParser().parse(this)
    }

    val binding = RuntimeWiring
        .newRuntimeWiring()
        .apply {
            // RESOLVERS
            type("Query") {
                it.dataFetcher("pokemon") {
                    val name = it.getArgument<String>("name")
                    repo.getByName(name)
                }
            }
        }
        .build()

    val graphqlSchema = SchemaGenerator()
        .makeExecutableSchema(schema, binding)

    val engine = GraphQL
        .newGraphQL(graphqlSchema)
        .build()

    // ==== FIM DA CONFIGURAÇÃO =======

    val input = ExecutionInput
        .newExecutionInput()
        .query(
            """
            query(${"$"}name: String!) {
                pokemon(name: ${"$"}name) {
                    name
                    age
                }
            }
        """.trimIndent()
        )
        .variables(mapOf("name" to "charmander"))

    val result = engine.execute(input)

    println(gson.toJson(result))
}

class MockRepo {

    private val pokemons = listOf(
        Pokemon("charmander", 1),
        Pokemon("squritle", 2),
        Pokemon("bulbassaur", 3),
        Pokemon("golfish", 4),
        Pokemon("pikachu", 5),
        Pokemon("totodile", 6),
        Pokemon("beedrill", 7),
        Pokemon("sunflower", 8)
    )

    fun getByName(name: String) =
        pokemons
            .first { it.name == name }

}