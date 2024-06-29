package com.example.pag3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.*

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.pag3.ui.theme.Pag3Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Pag3Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    DialogExamples()
                }
            }
        }
    }
}

@Composable

fun DialogExamples() {
    val openAlertDialog = remember { mutableStateOf(false) }

    // Exibir o AlertDialog quando openAlertDialog for true
    if (openAlertDialog.value) {
        AlertDialogExample(
            onDismissRequest = { openAlertDialog.value = false },
            onConfirmation = {
                openAlertDialog.value = false
                println("Confirmação registrada") // Lógica para lidar com a confirmação
            },
            dialogTitle = "Confirmação de compra",
            dialogText = "Essa é uma confirmação da sua compra, deseja continuar?",
            icon = Icons.Default.Info
        )
    }

    // Exemplo de botão para abrir o AlertDialog
    Button(
        onClick = { openAlertDialog.value = true },
        modifier = Modifier
            .padding(160.dp) // Adicionando padding para espaçamento
            .size(width = 250.dp, height = 50.dp) // Definindo um tamanho adequado para o botão
    ) {
        Text("Confirmação de compra")
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AlertDialogExample(
    onDismissRequest: () -> Unit,
    onConfirmation: () -> Unit,
    dialogTitle: String,
    dialogText: String,
    icon: ImageVector,
) {
    AlertDialog(
        icon = {
            Icon(icon, contentDescription = "Ícone de Exemplo")
        },
        title = {
            Text(text = dialogTitle)
        },
        text = {
            Text(text = dialogText)
        },
        onDismissRequest = {
            onDismissRequest()
        },
        confirmButton = {
            TextButton(
                onClick = {
                    onConfirmation()
                }
            ) {
                Text("Confirmar")
            }
        },
        dismissButton = {
            TextButton(
                onClick = {
                    onDismissRequest()
                }
            ) {
                Text("Cancelar")
            }
        }
    )
}

@Preview(showBackground = true)
@Composable
fun DialogExamplesPreview() {
    Pag3Theme {
        DialogExamples()
    }
}
