package com.example.client.ui.normalNoteScreen.detail

import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.client.R


@Composable
fun AddImageButton(modifier: Modifier = Modifier, onLoadImages : (List<Uri>) -> Unit) {
    val pickMedia = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.PickMultipleVisualMedia(maxItems = 4)
    ) { uris ->
        onLoadImages(uris)
    }
    Box(
        modifier = modifier
            .clip(RoundedCornerShape(16.dp))
            .background(MaterialTheme.colorScheme.primaryContainer)
            .clickable(onClick = {
                pickMedia.launch(
                    PickVisualMediaRequest(ActivityResultContracts.PickVisualMedia.ImageOnly)
                )
            }),
        contentAlignment = Alignment.Center
    ) {
        Icon(
            imageVector = Icons.Default.Add,
            contentDescription = stringResource(R.string.load_image),
            tint = MaterialTheme.colorScheme.onPrimaryContainer,
            modifier = Modifier.size(45.dp)
        )
    }
}

@Composable
fun NoteImageItem(modifier: Modifier = Modifier, index: Int, imageUri: Uri, onDeleteImage: (Uri) -> Unit = {}) {
    Box(
        modifier = modifier
    ) {
        AsyncImage(
            model = imageUri,
            contentDescription = "Note image $index",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )


    }
}