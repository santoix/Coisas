import androidx.lifecycle.ViewModel
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.coisas.Notes

class NoteViewModel : ViewModel() {
    // Lista de notas
    var notes = mutableStateListOf<Notes>()
        private set

    var currentTitle = mutableStateOf("")
    var currentContent = mutableStateOf("")
    var editingNoteId = mutableStateOf<Int?>(null) // mantem o id do que esta a ser editado

    // metodo para adicionar e dar update a notas
    fun addOrUpdateNote() {
        val id = editingNoteId.value
        if (id == null) {
            // Add a new note
            val newNote = Notes(
                id = notes.size,
                title = currentTitle.value,
                content = currentContent.value
            )
            notes.add(newNote)
        } else {
            // caso id exista é dar update com as novo titulo e conteudo
            notes[id] = notes[id].copy(title = currentTitle.value, content = currentContent.value)
        }
        // resetar a nota
        currentTitle.value = ""
        currentContent.value = ""
        editingNoteId.value = null
    }

    // metodo para editar
    fun editNote(note: Notes) {
        editingNoteId.value = note.id
        currentTitle.value = note.title
        currentContent.value = note.content
    }

    // metodo para eliminar
    fun deleteNote(note: Notes) {
        notes.remove(note)
    }
}
