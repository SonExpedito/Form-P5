package com.example.form_p5

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.text.selection.TextSelectionColors
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.form_p5.ui.theme.Form_P5Theme
import java.lang.Appendable

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            form()
        }
    }
}

@Composable
fun form (){
    Form_P5Theme {
        // A surface container using the 'background' color from the theme
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            SimpleCenterAlignedTopAppBar()
        }
    }


}

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun SimpleCenterAlignedTopAppBar() {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                colors = TopAppBarDefaults.smallTopAppBarColors(
                    containerColor = Color(0xFE, 0x0, 0x0, 0xFF)
                ),
                title = {
                    Text(
                        " Feedback",
                        style = TextStyle(
                            fontWeight = FontWeight.ExtraBold,
                            color = Color(1, 0, 0, 255),
                            fontSize = 30.sp
                        ),


                        maxLines = 2,
                        overflow = TextOverflow.Ellipsis
                    )
                },
                navigationIcon = {
                    IconButton(onClick = { /* doSomething() */ }) {
                        Icon(
                            imageVector = Icons.Filled.Menu,
                            contentDescription = "Localized description"
                        )
                    }
                },
                actions = {
                    IconButton(onClick = { /* doSomething() */ }) {
                        Icon(
                            painter = painterResource(id = com.example.form_p5.R.drawable.zapzapp5),
                            contentDescription = "Localized description",
                            tint = Color.Unspecified,
                            modifier = Modifier.size(24.dp)


                            )
                    }
                },

                )

        }


        ,content = { innerPadding ->  ProjetoConfig() }

    )
}


@Preview
@Composable
fun PreviewApp(){
    form()
}




@Composable
fun ProjetoConfig(){


        Column(
            Modifier
                .background(color = Color(0, 0, 0, 255))
                .fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally)
        {
                Spacer(modifier = Modifier.height(80.dp))
                Row {
                    TituloForm()
                }

                Row(){
                    Spacer(modifier = Modifier.height(55.dp) )

                    Text(text = "Preencha os Campos", style = TextStyle(
                        color = Color.White,
                        fontSize = 28.sp,
                        fontWeight = FontWeight.Bold,
                         )
                    )
                }
                Row {
                        InputsForm()
                    }

                Spacer(modifier = Modifier.height(14.dp))

                Row{
                    DropdownTipOCel()
                }

            Spacer(modifier = Modifier.height(14.dp))

                Row{
                        TextArea()
                 }
                Spacer(modifier = Modifier.height(14.dp))

                Row{
                            Botoes()

                }

    }
}



@Composable
fun TituloForm(){
    Row {


        Box(
            contentAlignment = Alignment.Center
        ){
                    Image(painter = painterResource(id = R.drawable.detail), contentDescription ="Fundo" )
                    Text(text = "Suporte",style = androidx.compose.ui.text.TextStyle(
                        color = Color.White,
                        fontSize = 36.sp,
                        fontWeight = FontWeight.Bold,
                        shadow = Shadow(
                            color = Color(254, 0, 0, 255),
                            offset = Offset(0f,9f),

                            )  ),



                    )


        }
    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InputsForm(){
    Column (
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        var texto by rememberSaveable { mutableStateOf("") }
        TextField(
            value = texto,
            maxLines = 2,
            onValueChange = { texto = it },
            colors = TextFieldDefaults.textFieldColors(
                containerColor = Color(19, 19, 19, 255),
                textColor = Color(254, 254, 254, 255),
                cursorColor = Color(254, 254, 254, 255),

                selectionColors = TextSelectionColors(
                    handleColor = Color(254, 254, 254, 255),
                    backgroundColor = Color(254, 254, 254, 255)),

                placeholderColor = Color(254, 254, 254, 255),
                focusedIndicatorColor = Color(254, 0, 0, 255),
                unfocusedIndicatorColor = Color(254, 0, 0, 255),

                focusedLabelColor = Color(254, 254, 254, 255),
                unfocusedLabelColor = Color(254, 254, 254, 255)
            ),

            label = { Text("Nome") },
            placeholder = { Text(text = "Coloque seu nome aqui") },

            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Text,
                imeAction = ImeAction.Next,
                capitalization = KeyboardCapitalization.Words
            ),
            )

        Spacer(modifier = Modifier.height(14.dp))

        var telefone by rememberSaveable { mutableStateOf("") }
        TextField(
            value = telefone,
            maxLines = 2,
            onValueChange = { telefone = it },
            colors = TextFieldDefaults.textFieldColors(
                containerColor = Color(19, 19, 19, 255),
                textColor = Color(254, 254, 254, 255),
                cursorColor = Color(254, 254, 254, 255),

                selectionColors = TextSelectionColors(
                    handleColor = Color(254, 254, 254, 255),
                    backgroundColor = Color(254, 254, 254, 255)),

                placeholderColor = Color(254, 254, 254, 255),
                focusedIndicatorColor = Color(254, 0, 0, 255),
                unfocusedIndicatorColor = Color(254, 0, 0, 255),

                focusedLabelColor = Color(254, 254, 254, 255),
                unfocusedLabelColor = Color(254, 254, 254, 255)
            ),
            label = { Text("Num-Telefone") },
            placeholder = { Text(text = "Coloque seu número aqui aqui") },

            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number,
                imeAction = ImeAction.Next,
                capitalization = KeyboardCapitalization.Words
            ))
    }



}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DropdownTipOCel() {
    val options = listOf("Whatzapp", "Fixo", "Celular")
    var expanded by remember { mutableStateOf(false) }
    var selectedOptionText by remember { mutableStateOf("") }
    ExposedDropdownMenuBox(
        expanded = expanded,
        onExpandedChange = { expanded = !expanded },
    ) {
        TextField(
            // The `menuAnchor` modifier must be passed to the text field for correctness.
            modifier = Modifier.menuAnchor(),
            value = selectedOptionText,
            onValueChange = { selectedOptionText = it },
            readOnly = false //*vai ser necessário posteriormente
            ,label = { Text("Selecione o Tipo") },
            trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded) },
            colors = ExposedDropdownMenuDefaults.textFieldColors(
                containerColor = Color(19, 19, 19, 255),
                textColor = Color(254, 254, 254, 255),
                cursorColor = Color(254, 254, 254, 255),

                selectionColors = TextSelectionColors(
                    handleColor = Color(254, 254, 254, 255),
                    backgroundColor = Color(254, 254, 254, 255)),

                placeholderColor = Color(254, 254, 254, 255),
                focusedIndicatorColor = Color(254, 0, 0, 255),
                unfocusedIndicatorColor = Color(254, 0, 0, 255),

                focusedLabelColor = Color(254, 254, 254, 255),
                unfocusedLabelColor = Color(254, 254, 254, 255)
            ),

        )
        // filter options based on text field value
        val filteringOptions = options.filter { it.contains(selectedOptionText, ignoreCase = true) }
        if (filteringOptions.isNotEmpty()) {
            ExposedDropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false },
            ) {
                filteringOptions.forEach { selectionOption ->
                    DropdownMenuItem(
                        text = { Text(selectionOption) },
                        onClick = {
                            selectedOptionText = selectionOption
                            expanded = false
                        },
                        contentPadding = ExposedDropdownMenuDefaults.ItemContentPadding,
                    )
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TextArea(){
        var observacao by rememberSaveable { mutableStateOf("") }
            TextField(
                value = observacao,
                maxLines = 8,
                onValueChange = { observacao = it },
                colors = TextFieldDefaults.textFieldColors(
                    containerColor = Color(19, 19, 19, 255),
                    textColor = Color(254, 254, 254, 255),
                    cursorColor = Color(254, 254, 254, 255),

                    selectionColors = TextSelectionColors(
                        handleColor = Color(254, 254, 254, 255),
                        backgroundColor = Color(254, 254, 254, 255)),

                    placeholderColor = Color(254, 254, 254, 255),
                    focusedIndicatorColor = Color(254, 0, 0, 255),
                    unfocusedIndicatorColor = Color(254, 0, 0, 255),

                    focusedLabelColor = Color(254, 254, 254, 255),
                    unfocusedLabelColor = Color(254, 254, 254, 255)
                ),

                label = { Text("Observações") },
                placeholder = { Text(text = "Coloque suas necessidades aqui") },
                modifier = Modifier.height(126.dp),
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Next,
                    capitalization = KeyboardCapitalization.Words
                ),
            )

}

@Composable
fun Botoes(){
    Box(
        contentAlignment = Alignment.TopCenter
    ) {
        Image(painter = painterResource(id = R.drawable.city), contentDescription = "Cidade", contentScale = ContentScale.FillBounds)
        Row {
            FilledTonalButton(
                onClick = { /*TODO*/ },

                modifier = Modifier
                    .border(
                        width = 2.dp,
                        color = Color(19, 19, 19, 255),
                        shape = RoundedCornerShape(size = 25.dp)
                    ),
                colors = ButtonDefaults.filledTonalButtonColors(
                    Color(0, 0, 0, 255),
                )
            ) {

                Text(
                    "Cadastrar", style = TextStyle(
                        color = Color.White,
                        fontSize = 13.sp,
                        fontWeight = FontWeight.Bold
                    )
                )
            }

            Spacer(modifier = Modifier.width(10.dp))

            FilledTonalButton(
                onClick = { /*TODO*/ },

                modifier = Modifier
                    .border(
                        width = 2.dp,
                        color = Color(19, 19, 19, 255),
                        shape = RoundedCornerShape(size = 25.dp)
                    ),
                colors = ButtonDefaults.filledTonalButtonColors(
                    Color(0, 0, 0, 255),
                )
            ) {

                Text(
                    "Cancelar", style = TextStyle(
                        color = Color.White,
                        fontSize = 13.sp,
                        fontWeight = FontWeight.Bold
                    )
                )
            }
        }
    }
}