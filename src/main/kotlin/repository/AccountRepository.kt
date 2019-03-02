package repository

import graphql.types.Account

class AccountRepository {

    private val accounts = listOf(
        Account("account1", "bank1", "password1"),
        Account("account2", "bank2", "password2"),
        Account("account3", "bank3", "password3"),
        Account("account4", "bank4", "password4"),
        Account("account5", "bank5", "password5"),
        Account("account6", "bank6", "password6"),
        Account("account7", "bank7", "password7")
    )

    fun first() = accounts.first()

    fun all() = accounts
}