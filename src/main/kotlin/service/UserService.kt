package service

import androidx.compose.runtime.mutableStateMapOf
import java.util.UUID

class UserService {
    private var users = mutableStateMapOf<UUID, User>()

    fun getAllUsers(): List<User> {
        return users.values.toList().sortedBy { it.name }
    }
    fun newUser(userName: String) {
        val newUser = User(UUID.randomUUID(), userName)
        users[newUser.id] = newUser
    }

    fun deleteUser(userId: UUID) {
        users.remove(userId)
    }
}