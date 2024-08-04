import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Button
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.coisas.Notes
import com.example.coisas.ui.theme.BlackL
import com.example.coisas.ui.theme.CoisasTheme
import androidx.compose.ui.Alignment
import com.example.coisas.ui.theme.GoldL
import com.example.coisas.ui.theme.testeroboto
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon


@Composable
fun NotePage(viewModel: NoteViewModel = viewModel()) {
    // Column layout para a pagina das notas
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            //.padding(bottom = bottomPadding)// tentativa de tirar os butões em cima da navbar
    ) {
        // Input field do titulo
        BasicTextField(
            value = viewModel.currentTitle.value,
            onValueChange = { viewModel.currentTitle.value = it },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp),
            decorationBox = { innerTextField ->
                if (viewModel.currentTitle.value.isEmpty()) {
                    Text("Enter title...", color = BlackL, fontFamily = testeroboto)
                }
                innerTextField()
            }
        )

        // Input field do conteudo
        BasicTextField(
            value = viewModel.currentContent.value,
            onValueChange = { viewModel.currentContent.value = it },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp),
            decorationBox = { innerTextField ->
                if (viewModel.currentContent.value.isEmpty()) {
                    Text("Enter content...", color = BlackL, fontFamily = testeroboto)
                }
                innerTextField()
            }
        )

        // Button para adicionar/mudar nota
        Button(
            colors = ButtonDefaults.buttonColors(containerColor = GoldL),
            onClick = { viewModel.addOrUpdateNote() },
            modifier = Modifier
                .padding(bottom = 16.dp)
                .align(Alignment.End)

        ) {
            Text("Create Note", color = BlackL, fontFamily = testeroboto)
        }

        // List of existing notes with scrolling support
        LazyColumn {
            items(viewModel.notes) { note ->
                NoteItem(note = note, viewModel = viewModel)
            }
        }
    }
}


@Composable
fun NoteItem(note: Notes, viewModel: NoteViewModel) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp)
    ) {
        // Display nota e o seu titulo
        Column(modifier = Modifier.weight(1f).background(color = GoldL, shape = RoundedCornerShape(10.dp)).border(width = 2.dp, color = Color.Black, shape = RoundedCornerShape(10.dp))) {
            Text(text = note.title, fontSize = 25.sp, color = BlackL, fontFamily = testeroboto, modifier = Modifier.padding(16.dp))
            Text(text = note.content, fontSize = 18.sp, color = Color.DarkGray, fontFamily = testeroboto, modifier = Modifier.padding(16.dp))
        }

        // butao para editar a nota
        IconButton(
            onClick = { viewModel.editNote(note) }) {
            Text("Edit")
        }

        // butao para dar delete de nota
        IconButton(onClick = { viewModel.deleteNote(note) }) {
            Icon(imageVector = Icons.Default.Delete, contentDescription = "Delete")
        }
    }
}

@Preview
@Composable
fun NotePagePreview() {
    CoisasTheme {
        NotePage()
    }
}
