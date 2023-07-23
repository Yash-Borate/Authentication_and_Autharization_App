package com.example.loginflow.Screens

import android.support.v4.os.IResultReceiver2.Default
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.loginflow.R
import com.example.loginflow.app.BottomClickableTextComponent
import com.example.loginflow.app.ButtonComponent
import com.example.loginflow.app.CheckBoxComponent
import com.example.loginflow.app.DeviderComponent
import com.example.loginflow.app.GoogleAndFacebookLogin
import com.example.loginflow.app.HeadingTextComponent
import com.example.loginflow.app.MyTextField
import com.example.loginflow.app.PassMyTextField
import com.example.loginflow.app.TextComponent

@Composable
fun LoginScreen() {

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(28.dp)
    ){
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            TextComponent(text = stringResource(R.string.hey_there))
            HeadingTextComponent(text = stringResource(R.string.welcome_back))
            Spacer(modifier = Modifier.height(20.dp))

            MyTextField(
                LabelValue = stringResource(R.string.email),
                painterResource(id = R.drawable.message)
            )
            PassMyTextField(
                LabelValue = stringResource(R.string.password),
                painterResource(id = R.drawable.lock)
            )


            Spacer(modifier = Modifier.height(240.dp))
            ButtonComponent(value = stringResource(R.string.login))
            Spacer(modifier = Modifier.height(15.dp))
            DeviderComponent()

            GoogleAndFacebookLogin()
            Spacer(modifier = Modifier.height(25.dp))
            BottomClickableTextComponent(onTextSelected = {})

        }

    }

}

@Preview
@Composable
fun DefaultPreview() {
    LoginScreen()
}




