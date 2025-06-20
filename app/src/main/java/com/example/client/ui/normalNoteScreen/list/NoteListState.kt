package com.example.client.ui.normalNoteScreen.list

import com.example.client.data.model.NoteDTO
import com.example.client.ui.common.UiEvent

data class NoteListState(
    val notes: List<NoteDTO> = emptyList(),
    val isLoading: Boolean = false,
    val selectedNoteId: Int = 0,
    val aviso: UiEvent? = null,
    val isChronologicalSelected: Boolean = false,
    val isChronologicalAsc: Boolean = true,
)