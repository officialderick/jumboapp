import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.jumboapp.ui.theme.JumboAppTheme


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BookshelfScreen(navController: NavController) {
    var newBookshelfName by remember { mutableStateOf(TextFieldValue()) }
    var creatingBookshelf by remember { mutableStateOf(false) }
    var bookshelves by remember { mutableStateOf(listOf("Fiction", "Non-Fiction")) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = "Bookshelves",
            modifier = Modifier.padding(bottom = 8.dp)
        )

        LazyColumn {
            items(bookshelves.size) { index ->
                val bookshelfName = bookshelves[index]
                BookshelfItem(bookshelfName, navController)
            }
        }

        if (creatingBookshelf) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 8.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                OutlinedTextField(
                    value = newBookshelfName,
                    onValueChange = {
                        newBookshelfName = it
                    },
                    label = { Text("New Bookshelf Name") },
                    keyboardOptions = KeyboardOptions(
                        capitalization = KeyboardCapitalization.Words,
                        keyboardType = KeyboardType.Text,
                        imeAction = ImeAction.Done
                    ),
                    keyboardActions = KeyboardActions(
                        onDone = {
                            if (newBookshelfName.text.isNotEmpty()) {
                                bookshelves = bookshelves + newBookshelfName.text
                                newBookshelfName = TextFieldValue()
                                creatingBookshelf = false
                            }
                        }
                    ),
                    modifier = Modifier
                        .weight(1f)
                        .padding(end = 8.dp)
                )

                IconButton(
                    onClick = {
                        creatingBookshelf = false
                    }
                ) {
                    Icon(imageVector = Icons.Default.Clear, contentDescription = null)
                }
            }
        } else {
            IconButton(
                onClick = {
                    creatingBookshelf = true
                }
            ) {
                Icon(imageVector = Icons.Default.Add, contentDescription = null)
            }
        }
    }
}

@Composable
fun BookshelfItem(bookshelfName: String, navController: NavController) {
    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
            .clickable {
                navController.navigate("bookshelf/$bookshelfName")
            }
            .padding(16.dp)
    ) {
        Text(
            text = bookshelfName,
            modifier = Modifier
                .weight(1f)
                .padding(bottom = 4.dp)
        )

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "15 Books",
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }
}

@Composable
fun BookshelfDetailScreen(navController: NavController, bookshelfName: String?) {
    val context = LocalContext.current
    var books by remember { mutableStateOf(List(15) { "Book ${it + 1}" }) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            IconButton(
                onClick = {
                    navController.popBackStack()
                }
            ) {
                Icon(imageVector = Icons.Default.KeyboardArrowRight, contentDescription = null)
            }

            Text(
                text = bookshelfName ?: "Bookshelf",
                style = MaterialTheme.typography.bodySmall,
                modifier = Modifier
                    .weight(1f)
                    .padding(end = 8.dp)
            )

            IconButton(
                onClick = {
                    // Add book logic here
                }
            ) {
                Icon(imageVector = Icons.Default.Add, contentDescription = null)
            }
        }

        LazyColumn {
            items(books.size) { index ->
                BookItem(books[index])
            }
        }
    }
}

@Composable
fun BookItem(bookTitle: String) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
            .padding(16.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = bookTitle,
                modifier = Modifier
                    .weight(1f)
                    .padding(bottom = 4.dp)
            )

            IconButton(
                onClick = {
                    // Delete book logic here
                }
            ) {
                Icon(imageVector = Icons.Default.Delete, contentDescription = null)
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
fun BookshelfScreenPreview() {
    JumboAppTheme {
        BookshelfScreen(navController = rememberNavController())
    }
}

@Composable
@Preview(showBackground = true)
fun BookshelfDetailScreenPreview() {
    JumboAppTheme {
        BookshelfDetailScreen(navController = rememberNavController(), bookshelfName = "Fiction")
    }
}

@Composable
@Preview(showBackground = true)
fun BookItemPreview() {
JumboAppTheme {
        BookItem(bookTitle = "Sample Book Title")
    }
}


