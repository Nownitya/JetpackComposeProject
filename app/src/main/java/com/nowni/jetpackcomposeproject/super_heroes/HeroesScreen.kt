package com.nowni.jetpackcomposeproject.super_heroes

import android.annotation.SuppressLint
import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.*
import androidx.compose.animation.core.Spring.DampingRatioLowBouncy
import androidx.compose.animation.core.Spring.StiffnessVeryLow
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.nowni.jetpackcomposeproject.R
import com.nowni.jetpackcomposeproject.super_heroes.data.DataSourceHeroes
import com.nowni.jetpackcomposeproject.super_heroes.model.HeroesList
import com.nowni.jetpackcomposeproject.super_heroes.ui.theme.SuperheroesTheme

class HeroesScreen : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SuperheroesTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
                ) {
                    HeroesScreenApp()

                }
            }
        }
    }
}

//@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun HeroesScreenApp() {
//    HeroesList(heroesList = DataSourceHeroes.heroes)
//    HeroesListItem(hero = DataSourceHeroes.heroes.first())
//    HeroesList(heroes = DataSourceHeroes.heroes)
    Scaffold(topBar = {
        TopAppBar()
    }) {
        val heroes = DataSourceHeroes.heroes
        HeroesList(heroes= heroes, contentPadding = it)

    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBar(modifier: Modifier = Modifier) {
    CenterAlignedTopAppBar(title = {
        Text(text = stringResource(id = R.string.super_heroes),
            style = MaterialTheme.typography.displayLarge)

    }, modifier = modifier)

}


@OptIn(ExperimentalAnimationApi::class)
@Composable
fun HeroesList(heroes: List<HeroesList>, modifier: Modifier = Modifier,
               contentPadding:PaddingValues= PaddingValues(0.dp)
) {
    val visibleState = remember {
        MutableTransitionState(false).apply {
            targetState = true
        }
    }

    AnimatedVisibility(
        visible = visibleState.targetState,
        enter = fadeIn(
            animationSpec = spring(
                dampingRatio = DampingRatioLowBouncy
            )
        ),
        exit = fadeOut(),
        modifier = modifier

    ) {
        LazyColumn(contentPadding = contentPadding){
            itemsIndexed(heroes) {index, hero ->
                HeroesListItem(
                    hero = hero,
                    modifier = Modifier
                        .padding(horizontal = 16.dp, vertical = 8.dp)
                        .animateEnterExit(
                            enter = slideInVertically(
                                animationSpec = spring(
                                    stiffness = StiffnessVeryLow,
                                    dampingRatio = DampingRatioLowBouncy

                                ),
                                initialOffsetY = { it * (index + 1) }

                            )
                        )
                )
            }
        }

    }
    

}


@Composable
fun HeroesListItem(hero:HeroesList , modifier: Modifier = Modifier) {
    Card(
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
        modifier = modifier
    ) {
        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .sizeIn(minHeight = 72.dp)) {
            Column(modifier = Modifier.weight(1f)) {
                Text(text = stringResource(id = hero.superHeroesName),
                    style = MaterialTheme.typography.displaySmall
                )
                Text(text = stringResource(id = hero.superHeroesDescription),
                    style = MaterialTheme.typography.bodyLarge)
            }
            Spacer(modifier = Modifier.width(16.dp))
            Box(
                modifier = Modifier
                    .size(72.dp)
                    .clip(RoundedCornerShape(8.dp))
            ){
                Image(
                    painter = painterResource(id = hero.superHeroesImage),
                    contentDescription = (stringResource(id = hero.superHeroesDescription)),
                    alignment = Alignment.TopCenter,
                    contentScale = ContentScale.FillWidth
                )
            }


        }

    }

}



@Preview(
    showBackground = true, showSystemUi = true, name = "Superheroes_Light"
)
@Composable
fun SuperheroesLPreview1() {
    SuperheroesTheme(darkTheme = false) {
        Surface(color = MaterialTheme.colorScheme.background) {
            HeroesScreenApp()
        }

    }
}

@Preview(
    showBackground = true, showSystemUi = true, name = "Superheroes_Dark",
    uiMode = Configuration.UI_MODE_NIGHT_YES, device = Devices.DEFAULT
)
@Composable
fun SuperheroesDPreview2() {
    SuperheroesTheme() {
        Surface {
            HeroesScreenApp()
        }

    }
}



//@Composable
//fun HeroesList(heroesList: List<HeroesList>, modifier: Modifier = Modifier) {
//    Scaffold (topBar = {
//        HeroesTopAppBar()
//    }){ it->
//        LazyColumn(modifier = modifier.padding(top = 4.dp), contentPadding = it) {
//            items(heroesList) {
//                HeroesCard(heroes = it, modifier = Modifier)
//            }
//        }
//    }
//
//    /*LazyColumn(modifier = modifier.padding(top = 4.dp)) {
//        items(heroesList) {
//            HeroesCard(heroes = it, modifier = Modifier)
//        }
//    }*/
//}
//
//@OptIn(ExperimentalMaterial3Api::class)
//@Composable
//fun HeroesTopAppBar(modifier: Modifier = Modifier) {
//    CenterAlignedTopAppBar(title = {
//        Text(text = stringResource(id = R.string.super_heroes),
//            style = MaterialTheme.typography.displayLarge)
//    },modifier=modifier)
//
//}
//
//@Composable
//fun HeroesCard(heroes: HeroesList, modifier: Modifier = Modifier) {
//    Card(
//        modifier
//            .fillMaxWidth()
//            .padding(start = 16.dp, top = 8.dp, end = 16.dp, bottom = 8.dp),
//        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
//    ) {
//        Row(
//            modifier = modifier
//                .fillMaxWidth()
//                .padding(dimensionResource(id = R.dimen.padding_medium))
//                .sizeIn(minHeight = 72.dp)
//        ) {
//            Box(modifier.weight(1f)) {
//                HeroesInfo(
//                    heroesName = heroes.superHeroesName,
//                    heroesDesp = heroes.superHeroesDescription
//                )
//            }
//            Spacer(modifier = Modifier.width(16.dp))
//
//            Box(
//                modifier = Modifier
//                    .size(72.dp)
//                    .clip(RoundedCornerShape(8.dp)),
//                contentAlignment = Alignment.Center
//            ) { HeroesImage(imageResource = heroes.superHeroesImage) }
//        }
//    }
//}
//
//@Composable
//fun HeroesInfo(heroesName: Int, heroesDesp: Int, modifier: Modifier = Modifier) {
//    Column {
//        Text(text = stringResource(id = heroesName), style = MaterialTheme.typography.displaySmall)
//        Text(text = stringResource(id = heroesDesp), style = MaterialTheme.typography.bodyLarge)
//
//    }
//
//}
//
//@Composable
//fun HeroesImage(@DrawableRes imageResource: Int, modifier: Modifier = Modifier) {
//    Image(
//        painter = painterResource(imageResource),
//        contentDescription = null,
//        alignment = Alignment.TopCenter,
//        contentScale = ContentScale.FillBounds
//    )
//}