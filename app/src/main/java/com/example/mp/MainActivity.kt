package com.example.mp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mp.ui.theme.MPTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MPTheme {
                val text = remember { mutableStateOf("") }
                val list = remember {
                    mutableStateOf(listOf<String>())
                }

                Box(
                    modifier = Modifier.padding(12.dp)
                ) {
                    Column {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth(),
                            horizontalArrangement = Arrangement.Center,
                        ) {
                            Box(modifier = Modifier.height(52.dp))

                            TextField(
                                value = text.value,
                                onValueChange = { newText ->
                                    text.value = newText
                                }
                            )
                            Box(modifier = Modifier.width(12.dp))
                            Button(onClick = {
                                val l = listOf(text.value)
                                list.value = list.value + l
                                text.value = ""
                            }) {
                                Text("Ok!")
                            }


                        }
                        Box(modifier = Modifier.height(32.dp))
                        Box(modifier = Modifier.fillMaxSize()) {
                            LazyColumn {
                                items(list.value.size) { index ->
                                    Row(
                                        modifier = Modifier.fillMaxWidth(),
                                        horizontalArrangement = Arrangement.SpaceBetween
                                    ) {
                                        Text(
                                            text = list.value[index],
                                            fontSize = 32.sp
                                        )

                                        IconButton(
                                            onClick = {
                                                val l =
                                                    listOf(list.value[index])
                                                list.value = list.value - l.toSet()
                                            },
                                        ) {
                                            Icon(
                                                imageVector = Icons.Default.Delete,
                                                contentDescription = null
                                            )
                                        }

                                    }
                                }
                            }
                        }
                    }
                }

            }
        }
    }
}
