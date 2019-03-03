package repository

import graphql.types.User

class UserRepository {

    private val users = listOf(
        User("chih1"),
        User("chih2"),
        User("chih3"),
        User("chih4"),
        User("chih5"),
        User("chih6"),
        User("chih7")
    )

    fun first() = users.first()

    fun findById(userId: Int) = users[userId]
    fun all() = users

}