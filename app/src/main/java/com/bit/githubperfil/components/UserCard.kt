package com.bit.githubperfil.components

import android.content.res.Configuration
import android.graphics.RenderEffect
import android.graphics.Shader
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asComposeRenderEffect
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.bit.githubperfil.R
import com.bit.githubperfil.framework.model.User
import com.bit.githubperfil.ui.theme.GitHubPerfilTheme

/**
 * @Author:  Vitor Rey
 * @Date: 28,setembro,2024
 * @Email: vitorrey.dev@gmail.com
 **/

@Composable
fun UserCard(modifier: Modifier = Modifier, user: User) {
    fun removeLineBreaks(input: String): String {
        return input.replace("\r\n", "").replace("\n", "")
    }
    Card(
        modifier = modifier
            .fillMaxWidth()
            .height(250.dp)
            .padding(15.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFF2b3137).copy(alpha = 0.9f))
                .padding(16.dp),
            contentAlignment = Alignment.Center
        ) {
            Column(modifier = Modifier.fillMaxHeight()) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    AsyncImage(
                        model = user.avatar,
                        contentDescription = "${user.name} avatar",
                        placeholder = painterResource(id = R.drawable.baseline_account_circle_24),
                        modifier = modifier
                            .size(48.dp)
                            .clip(CircleShape)
                    )
                    Spacer(modifier = Modifier.width(16.dp))
                    Text(
                        text = user.name,
                        fontSize = 24.sp,
                        color = MaterialTheme.colorScheme.primary
                    )
                    Spacer(modifier = Modifier.width(10.dp))
                    Text(
                        text = "(${user.login})",
                        fontStyle = FontStyle.Italic,
                        color = Color.Gray.copy(alpha = 0.5f)
                    )
                }
                Spacer(modifier = Modifier.height(20.dp))
                Text(
                    "Bio: ${removeLineBreaks(user.bio)}",
                    color = MaterialTheme.colorScheme.primary
                )
                Text(
                    text = "Company: ${user.company}",
                    color = MaterialTheme.colorScheme.primary,
                    style = TextStyle().copy(MaterialTheme.typography.titleSmall)
                )
                Text(
                    text = "Repositories: ${user.repos}",
                    color = MaterialTheme.colorScheme.primary
                )
            }
        }
    }


}

@Preview(name = "Light Mode", showBackground = true)
@Preview(name = "Dark Mode", uiMode = Configuration.UI_MODE_NIGHT_YES, showBackground = true)
@Preview(
    name = "Full Preview",
    showSystemUi = true,
    showBackground = true,
    device = Devices.PIXEL_7_PRO
)
@Composable
private fun UserCardPreview() {
    GitHubPerfilTheme {
        Column(
            Modifier
                .fillMaxSize()
                .background(Color(0xFF24292e))
        ) {
            UserCard(
                user = User(
                    "vitormfrey",
                    1,
                    "https://api.github.com/users/vitormfrey",
                    "Vitor Rey",
                    "SRBR (Samsung Research Brazil)",
                    "Graduate in System Analysis and Dev at SRBR.",
                    21,
                    "https://avatars.githubusercontent.com/u/59583956?v=4"
                )
            )
        }
    }
}