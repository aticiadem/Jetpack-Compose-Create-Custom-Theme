package com.adematici.customtheme

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.compositeOver
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.adematici.customtheme.ui.theme.ComposeCustomTheme
import com.adematici.customtheme.ui.theme.DefaultTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeCustomTheme {
                val context = LocalContext.current
                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .fillMaxSize()
                        .background(ComposeCustomTheme.colors.background)
                ) {
                    Text(
                        text = if (isSystemInDarkTheme()) {
                            stringResource(id = R.string.dark_theme)
                        } else {
                            stringResource(id = R.string.light_theme)
                        }
                    )
                    Spacer(modifier = Modifier.height(20.dp))
                    CustomButton(
                        onClick = {
                            Toast.makeText(
                                context,
                                getString(R.string.hello),
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    ) { Text(text = "Click Me!") }
                }
            }
        }
    }
}

@Composable
fun CustomButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    content: @Composable RowScope.() -> Unit,
) {
    Button(
        colors = ButtonDefaults.buttonColors(
            backgroundColor = ComposeCustomTheme.colors.primary,
            contentColor = ComposeCustomTheme.colors.secondary,
            disabledBackgroundColor = ComposeCustomTheme.colors.onBackground
                .copy(alpha = 0.12f)
                .compositeOver(ComposeCustomTheme.colors.primaryVariant),
            disabledContentColor = ComposeCustomTheme.colors.onBackground
                .copy(alpha = ContentAlpha.disabled)
        ),
        shape = ComposeCustomTheme.shapes.buttonShape.small,
        elevation = ButtonDefaults.elevation(
            defaultElevation = ComposeCustomTheme.elevation.defaultElevation,
            pressedElevation = ComposeCustomTheme.elevation.pressedElevation
        ),
        onClick = onClick,
        modifier = modifier,
        content = {
            ProvideTextStyle(
                value = ComposeCustomTheme.typography.h1
            ) {
                content()
            }
        }
    )
}


@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    DefaultTheme {
        Greeting("Android")
    }
}