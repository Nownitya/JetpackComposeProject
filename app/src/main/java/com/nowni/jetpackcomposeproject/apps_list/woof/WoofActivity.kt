package com.nowni.jetpackcomposeproject.apps_list.woof

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ExpandLess
import androidx.compose.material.icons.rounded.ExpandMore
import androidx.compose.material3.Card
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.nowni.jetpackcomposeproject.R
import com.nowni.jetpackcomposeproject.apps_list.woof.data.DataSourceDogs
import com.nowni.jetpackcomposeproject.apps_list.woof.model.DogsList
import com.nowni.jetpackcomposeproject.apps_list.woof.ui.theme.Shape
import com.nowni.jetpackcomposeproject.apps_list.woof.ui.theme.WoofTheme

import kotlin.math.exp

class WoofActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WoofTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
//                    color = MaterialTheme.colorScheme.background
                ) {
                    WoofApp()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WoofTopAppBar(modifier: Modifier = Modifier) {
    CenterAlignedTopAppBar(
        title = {
            Row {
                Image(
                    painter = painterResource(id = R.drawable.ic_woof_logo),
                    contentDescription = null,
                    modifier = Modifier
                        .size(dimensionResource(id = R.dimen.image_size))
                        .padding(dimensionResource(id = R.dimen.padding_small))
                )
                Text(
                    text = stringResource(id = R.string.activity_woof_app),
                    style = MaterialTheme.typography.displayLarge
                )
            }
        }, modifier = modifier
    )
}

@Composable
fun WoofApp() {
    WoofList(
        dogList = DataSourceDogs.dogs
    )
}

@Composable
fun WoofList(dogList: List<DogsList>, modifier: Modifier = Modifier) {/*LazyColumn(modifier = modifier) {
        items(dogList) {
//            dog->
            WoofLayout(
//                dog = dog,
                dog = it,
                modifier = modifier.padding(dimensionResource(id = R.dimen.padding_small))
            )
        }
    }*/

    Scaffold(topBar = {
        WoofTopAppBar()
    }) { it ->
        LazyColumn(modifier = modifier, contentPadding = it) {
            items(dogList) {
                WoofLayout(
                    dog = it,
                    modifier = modifier.padding(dimensionResource(id = R.dimen.padding_small))
                )
            }
        }
    }
}

@Composable
fun WoofLayout(dog: DogsList, modifier: Modifier = Modifier) {
    var expanded by remember { mutableStateOf(false) }
//    val color by animateColorAsState(
//        targetValue = if (expanded) MaterialTheme.colorScheme.tertiaryContainer else MaterialTheme.colorScheme.primaryContainer,
//        label = "",
//    )
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp, vertical = 0.dp)
    ) {
        Column(
            modifier = Modifier
                .animateContentSize(
                    animationSpec = spring(
                        dampingRatio = Spring.DampingRatioNoBouncy,
                        stiffness = Spring.StiffnessMedium
                    )
                )
//                .background(color = color)
        ) {

            Row(modifier = Modifier.padding(dimensionResource(id = R.dimen.padding_small))) {
                Box {
                    DogIcon(dogIcon = dog.imageResId)
                }
                DogInfo(dogName = dog.name, dogAge = dog.age)
                Spacer(modifier = Modifier.weight(1f))
//                DogHobby(dogHobby = dog.hobbies)
                DogItemButton(expanded = expanded, onClick = { expanded = !expanded })
            }
            if (expanded) {
                DogHobby(
                    dogHobby = dog.hobbies, modifier = Modifier.padding(
                        start = dimensionResource(id = R.dimen.padding_medium),
                        top = dimensionResource(id = R.dimen.padding_small),
                        end = dimensionResource(id = R.dimen.padding_medium),
                        bottom = dimensionResource(id = R.dimen.padding_medium)

                    )
                )
            }
        }
    }
}

@Composable
fun DogItemButton(
    expanded: Boolean, onClick: () -> Unit, modifier: Modifier = Modifier
) {
    IconButton(
        onClick = onClick, modifier = modifier
    ) {
        Icon(
            imageVector = if (expanded) Icons.Rounded.ExpandLess else Icons.Rounded.ExpandMore,
            contentDescription = stringResource(id = R.string.expand_button_content_description),
            tint = MaterialTheme.colorScheme.secondary
        )
    }
}

@Composable
fun DogIcon(
    @DrawableRes dogIcon: Int,
    modifier: Modifier = Modifier
) {
    Image(
        painter = painterResource(dogIcon),
        contentDescription = null,
        modifier = modifier
            .size(dimensionResource(id = R.dimen.image_size))
            .padding(dimensionResource(id = R.dimen.padding_small))
            .clip(Shape.small),
        contentScale = ContentScale.Crop
    )
}

@Composable
fun DogInfo(
    @StringRes dogName: Int, dogAge: Int, modifier: Modifier = Modifier
) {
    Column {
        Text(
            text = stringResource(id = dogName),
            fontStyle = FontStyle.Normal,
            style = MaterialTheme.typography.displayMedium,
            fontSize = 16.sp,
            modifier = modifier.padding(top = 4.dp)
        )

        Text(
            text = stringResource(id = R.string.years_old, dogAge),
            fontStyle = FontStyle.Normal,
            style = MaterialTheme.typography.bodyLarge,
            fontSize = 12.sp,
            fontWeight = FontWeight.Light,
            modifier = modifier


        )
    }

}

//@Composable
//fun DogAge(
//
//    modifier: Modifier = Modifier
//) {
//
//}

@Composable
fun DogHobby(
    @StringRes dogHobby: Int, modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        Text(
            text = stringResource(id = R.string.about), style = MaterialTheme.typography.labelSmall
        )
        Text(
            text = stringResource(dogHobby), style = MaterialTheme.typography.bodyLarge
        )
    }
}

@Preview(
    showBackground = true, showSystemUi = true, name = "Woof"
)
@Composable
fun WoofPreview() {
    WoofTheme {
        // A surface container using the 'background' color from the theme
        Surface(
            modifier = Modifier.fillMaxSize(),
        ) {
            WoofApp()
        }
    }
}