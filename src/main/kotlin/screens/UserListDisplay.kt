package screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import service.User
import java.util.UUID

@Composable
fun UserListDisplay (
    onRemoveUser: (userId: UUID) -> Unit,
    users: List<User>
) {
    LazyColumn {
        items(users) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(it.name)
                Spacer(Modifier.width(16.dp))
                IconButton(
                    onClick = {
                        onRemoveUser(it.id)
                    }
                ) {
                    Icon(
                        imageVector = Icons.Default.Delete,
                        contentDescription = "Remove Button"
                    )
                }
            }
        }
    }
}