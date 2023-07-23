package com.example.loginflow.app

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.loginflow.R
import com.example.loginflow.ui.theme.BgColor
import com.example.loginflow.ui.theme.Gray
import com.example.loginflow.ui.theme.GrayColor
import com.example.loginflow.ui.theme.Primary
import com.example.loginflow.ui.theme.Secondary
import com.example.loginflow.ui.theme.TextColor
import androidx.compose.material3.Text as Text

@Composable
fun TextComponent(
    text:String
) {
    Text(
        text = text,
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(min = 40.dp),
        style = TextStyle(
            fontStyle = FontStyle.Normal,
            fontSize = 24.sp,
            fontWeight = FontWeight.Normal
        ),
        color = TextColor,
        textAlign = TextAlign.Center
        )
}

@Composable
fun HeadingTextComponent(
    text:String
) {
    Text(
        text = text,
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(),
        style = TextStyle(
            fontStyle = FontStyle.Normal,
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold
        ),
        color = TextColor,
        textAlign = TextAlign.Center
    )
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTextField(LabelValue: String, painterResource: Painter) {

val textValue = remember {
    mutableStateOf("")
}
    OutlinedTextField(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(4.dp))
            .padding(bottom = 10.dp),
        label={ Text(text = LabelValue)},
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = Primary,
            focusedLabelColor = Primary,
            cursorColor = Primary,
            containerColor = BgColor
        ),
        keyboardOptions = KeyboardOptions.Default,
        value = textValue.value,
        onValueChange = {
        textValue.value = it
    },
        leadingIcon = {
            Icon(painter = painterResource, contentDescription = "")
        }

    )


}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PassMyTextField(LabelValue: String, painterResource: Painter) {

    val password = remember {
        mutableStateOf("")
    }

    val passIsVisible = remember {
        mutableStateOf(false)
    }
    OutlinedTextField(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(4.dp))
            .padding(bottom = 10.dp),
        label={ Text(text = LabelValue)},
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = Primary,
            focusedLabelColor = Primary,
            cursorColor = Primary,
            containerColor = BgColor
        ),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        value = password.value,
        onValueChange = {
            password.value = it
        },
        leadingIcon = {
            Icon(painter = painterResource, contentDescription = "")
        },
        trailingIcon = {
            val IconImg = if(passIsVisible.value){
                Icons.Filled.Visibility
            }
            else{
                Icons.Filled.VisibilityOff
            }

            val description = if(passIsVisible.value){
                stringResource(R.string.hide_password)
            }
            else{
                stringResource(R.string.show_password)
            }

            IconButton(onClick = { passIsVisible.value = !passIsVisible.value}) {
                Icon(imageVector = IconImg, contentDescription = description)
            }
        },
        visualTransformation = if(passIsVisible.value) VisualTransformation.None else PasswordVisualTransformation()

    )


}

@Composable
fun CheckBoxComponent() {
    Row (
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(56.dp),
        verticalAlignment = Alignment.CenterVertically
    ){
        val isChecked = remember {
            mutableStateOf(false)
        }
        Checkbox(checked = isChecked.value, onCheckedChange ={
            isChecked.value = !isChecked.value
        }
        )

        ClickableTextComponent()
        

    }

}

@Composable
fun ClickableTextComponent() {
    val initialText = "By continuing you accept our ";
    val privacyyPolicyText="Privacy Policies";
    val andText=" and ";
    val termAndConditionText="Term of Use";

    val annotatedString = buildAnnotatedString {
        append(initialText);
        withStyle(style = SpanStyle(color = Primary)){
            pushStringAnnotation(tag = privacyyPolicyText , annotation = privacyyPolicyText)
            append(privacyyPolicyText)
        }
        append(andText)
        withStyle(style = SpanStyle(color = Primary)){
            pushStringAnnotation(tag = termAndConditionText , annotation = termAndConditionText)
            append(termAndConditionText)
        }

    }

    ClickableText(text = annotatedString, onClick = {offset->
        annotatedString.getStringAnnotations(offset,offset)
            .firstOrNull()?.also {span->
                Log.d("ClickableTextComponent","{$span}")
            }
    })
}

@Composable
fun ButtonComponent(value: String) {
    Button(
        onClick = {
        },
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(48.dp),
        contentPadding = PaddingValues(),
        colors = ButtonDefaults.buttonColors(Color.Transparent)
        ) {
        Box(modifier = Modifier
            .fillMaxWidth()
            .heightIn(48.dp)
            .background(
                brush = Brush.horizontalGradient(listOf(Secondary, Primary)),
                shape = RoundedCornerShape(50.dp)
            ),
            contentAlignment = Alignment.Center
        ){
            Text(
                text = value ,
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp
                )
        }
    }
}

@Composable
fun DeviderComponent() {
    Row (
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ){
        Divider(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            color = GrayColor,
            thickness = 1.dp
        )
        Text(
            modifier = Modifier.padding(8.dp),
            text = "or",
            fontSize = 18.sp,
            color = GrayColor)
        Divider(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            color = GrayColor,
            thickness = 1.dp
        )
    }
}

@Composable
fun BottomClickableTextComponent(onTextSelected:(String) -> Unit) {
    val initialText = "Already have an account? "
    val loginText = "Login"



    val annotatedString = buildAnnotatedString {
        append(initialText)
        withStyle(style = SpanStyle(color = Primary)){
            pushStringAnnotation(tag = loginText , annotation = loginText)
            append(loginText)
        }


    }

    ClickableText(  modifier = Modifier
        .fillMaxWidth()
        .heightIn(min = 40.dp),
        style = TextStyle(
            fontStyle = FontStyle.Normal,
            fontSize = 21.sp,
            fontWeight = FontWeight.Normal,
            textAlign = TextAlign.Center
        ),
        text = annotatedString,
        onClick = {offset->
        annotatedString.getStringAnnotations(offset,offset)
            .firstOrNull()?.also {span->
                Log.d("ClickableTextComponent","{$span}")

                if(span.item == loginText){
                    onTextSelected(span.item)
                }
            }
    })
}

@Composable
fun GoogleAndFacebookLogin() {
    Row (
        modifier = Modifier
            .fillMaxWidth()
            .padding(15.dp),
        Arrangement.Center
            ){
        Box(
            modifier = Modifier
                .height(70.dp)
                .width(60.dp)
                .border(
                width = 1.dp ,
                brush = Brush.horizontalGradient(listOf(Secondary , Primary)),
                shape = RoundedCornerShape(10.dp))
                .clip(RoundedCornerShape(15.dp))
                .background(BgColor),
            contentAlignment = Alignment.Center,

        ){
        Image(
            painter = painterResource(id = R.drawable.google),
            contentDescription ="",
            modifier = Modifier.padding(8.dp)
            )
        }
        Spacer(modifier = Modifier.width(60.dp))
        Box(
            modifier = Modifier
                .height(70.dp)
                .width(60.dp)
                .border(
                    width = 1.dp ,
                    brush = Brush.horizontalGradient(listOf(Secondary , Primary)),
                    shape = RoundedCornerShape(10.dp))
                .clip(RoundedCornerShape(15.dp))
                .background(BgColor)
                ,
            contentAlignment = Alignment.Center,

            ){
            Image(
                painter = painterResource(id = R.drawable.facebook),
                contentDescription ="",
                modifier = Modifier.padding(10.dp)
                )
        }
    }
}


