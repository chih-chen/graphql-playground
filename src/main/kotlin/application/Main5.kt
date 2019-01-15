package application

import com.google.gson.Gson
import graphql.ExecutionInput
import graphql.GraphQL
import graphql.schema.idl.RuntimeWiring
import graphql.schema.idl.SchemaGenerator
import graphql.schema.idl.SchemaParser

fun main(args: Array<String>) {

    val repo = MockPokemonRepo()
    val gson = Gson()

    val schema = """

        schema {
            query: Query
            mutation: Mutation
        }

        type Query {
            pokemon(name: String!): Pokemon!
        }

        type Mutation {
            savePokemon(name: String!, age: Int!): Pokemon!
        }

        type Pokemon {
            name: String!
            age: Int!
        }

    """.run { SchemaParser().parse(this) }

    val binding = RuntimeWiring.newRuntimeWiring().apply {
        type("Query") {
            it.dataFetcher("pokemon") {
                it.getArgument<String>("name").run {
                    repo.findByName(this)
                }
            }
        }
        type("Pokemon") {
            it.dataFetcher("name") {
                it.getSource<Pokemon>().name.toUpperCase()
            }
        }
        type("Mutation") {
            it.dataFetcher("savePokemon") {
                val name = it.getArgument<String>("name")
                val age = it.getArgument<Int>("age")
                Pokemon(name, age).run { repo.save(this) }
            }
        }
    }.build()

    val graphqlSchema = SchemaGenerator()
        .makeExecutableSchema(schema, binding)

    val engine = GraphQL
        .newGraphQL(graphqlSchema)
        .build()

    val input = ExecutionInput
        .newExecutionInput()
        .query(
            """
            mutation(${"$"}name: String!, ${"$"}age: Int!) {
                savePokemon(name: ${"$"}name, age: ${"$"}age) {
                    name
                    age
                }
            }
        """.trimIndent()
        )
        .variables(mapOf("name" to "pikachu", "age" to 10))
        .build()

    val result1 = engine
        .execute(input)
        .toSpecification()

    println(gson.toJson(result1))
}

class MockPokemonRepo {

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

    fun findByName(name: String) = pokemons.first { it.name == name }

    fun save(pokemon: Pokemon): Pokemon {
        println("Saved $pokemon")
        return pokemon
    }
}

data class Pokemon(val name: String, val age: Int)