package com.droiddeck.launcher.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.droiddeck.launcher.R

@Composable
fun DeveloperDisplayChoiceDialog(
    displays: List<Pair<Int, String>>,
    onMainScreen: () -> Unit,
    onSecondaryScreen: (Int) -> Unit,
    onDismiss: () -> Unit,
) {
    AlertDialog(
        onDismissRequest = onDismiss,
        title = { Text(stringResource(R.string.gate_open_dev)) },
        text = {
            Column(verticalArrangement = Arrangement.spacedBy(4.dp), modifier = Modifier.fillMaxWidth()) {
                Text(stringResource(R.string.gate_choose_display))
                TextButton(modifier = Modifier.fillMaxWidth(), onClick = onMainScreen) { Text(stringResource(R.string.gate_main_screen)) }
                displays.forEach { (id, label) ->
                    TextButton(modifier = Modifier.fillMaxWidth(), onClick = { onSecondaryScreen(id) }) { Text(label) }
                }
            }
        },
        confirmButton = { TextButton(onClick = onDismiss) { Text(stringResource(R.string.common_cancel)) } },
    )
}
