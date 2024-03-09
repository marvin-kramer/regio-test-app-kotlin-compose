package screens

import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.PointerIcon
import androidx.compose.ui.input.pointer.pointerHoverIcon

@Composable
fun AddUserDisplay(
    onAddUser: (userName: String) -> Unit
) {
    var newUserName by remember { mutableStateOf("") }

    OutlinedTextField(
        placeholder = {
            Text("Username")
        },
        value = newUserName,
        onValueChange = {
            newUserName = it
        },
        trailingIcon = {
            IconButton(
                onClick = {
                    onAddUser(newUserName)
                },
                modifier = Modifier.pointerHoverIcon(PointerIcon.Hand)
            ) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = "Add Button"
                )
            }
        },
    )
}