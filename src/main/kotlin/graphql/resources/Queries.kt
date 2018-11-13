package graphql.resources

object Queries {

    val saveManualAccountMutation = """
        mutation SaveAccountMutation {
            a: saveAccount(payload: {name: "Jony"} ) {
                name
            }
            b: saveAccount(payload: {name: "Terry"} ) {
                name
                bank
                password
            }
            c: saveAccount2(payload: {name: "Jaina"}) {
                name
                bank
            }
        }
    """.trimIndent()

    val queryWithoutNestedObject = """
        query MyQuery {
            a: account {
                name
                bank
                password
            }
        }
    """.trimIndent()

    val queryWithNestedObject = """
        query MyQuery {
            b: account {
                name
                bank
                password
                statement(statementId: 1) {
                    name
                }
            }
        }
    """.trimIndent()
}