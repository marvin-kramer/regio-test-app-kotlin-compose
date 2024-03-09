import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import screens.AddUserDisplay
import screens.UserListDisplay
import service.UserService

@Composable
@Preview
fun App() {
    MaterialTheme {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxSize()
        ) {
            val userService = remember { UserService() }

            Spacer(Modifier.height(16.dp))
            AddUserDisplay(
                onAddUser = userService::newUser
            )
            Spacer(Modifier.height(36.dp))
            UserListDisplay(
                onRemoveUser = userService::deleteUser,
                users = userService.getAllUsers()
            )
        }
    }
}

fun main() = application {
    Window(onCloseRequest = ::exitApplication, title = "Regio") {
        App()
    }
}
