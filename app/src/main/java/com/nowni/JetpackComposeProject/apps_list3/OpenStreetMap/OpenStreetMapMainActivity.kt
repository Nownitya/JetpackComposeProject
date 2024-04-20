package com.nowni.JetpackComposeProject.apps_list3.OpenStreetMap

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.viewinterop.AndroidView
import org.osmdroid.config.Configuration
import org.osmdroid.util.GeoPoint
import org.osmdroid.views.MapView
import org.osmdroid.views.overlay.Marker
import org.osmdroid.views.overlay.Polyline

class OpenStreetMapMainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        Configuration.getInstance().load(applicationContext, androidx.preference.PreferenceManager.getDefaultSharedPreferences(applicationContext))
        setContent {
            MyApp{
                MapViewComponent()
            }
        }
    }
}

@Composable
fun MyApp(content: @Composable () -> Unit) {
    MaterialTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
           color = MaterialTheme.colorScheme.background
        ){
            content()
        }

    }

}

@Composable
fun MapViewComponent() {

    AndroidView(
        modifier = Modifier.fillMaxSize(),
        factory = { context ->
            MapView(context).apply {
                setMultiTouchControls(true)
                controller.setZoom(7.0)
                controller.setCenter(GeoPoint(30.0668, 79.0193))

                val locations = mapOf(
                    "Haridwar" to GeoPoint(29.9457, 78.1642),
                    "Barkot" to GeoPoint(30.8073, 78.2058),
                    "Jankichatti" to GeoPoint(31.0109, 78.4581),
                    "Yamunotri" to GeoPoint(31.0143, 78.4629),
                    "Uttarkashi" to GeoPoint(30.7290, 78.4558),
                    "Gangotri" to GeoPoint(30.9943, 78.9398),
                    "Sitapur" to GeoPoint(30.5345, 79.0303),
                    "Kedarnath" to GeoPoint(30.7352, 79.0669),
                    "Pipalkoti" to GeoPoint(30.4117, 79.3681),
                    "Badrinath" to GeoPoint(30.7447, 79.4930)
                )

                for ((place, coordinates) in locations) {
                    val marker = Marker(this).apply {
                        position = coordinates
                        setAnchor(Marker.ANCHOR_CENTER, Marker.ANCHOR_BOTTOM)
                        title = place
                    }
                    overlays.add(marker)
                }

                val routeCoordinates = listOf(
                    GeoPoint(29.9457, 78.1642),  // Haridwar
                    GeoPoint(30.8073, 78.2058),   // Barkot
                    GeoPoint(31.0109, 78.4581),   // Jankichatti
                    GeoPoint(31.0143, 78.4629),   // Yamunotri
                    GeoPoint(30.7290, 78.4558),   // Uttarkashi
                    GeoPoint(30.9943, 78.9398),   // Gangotri
                    GeoPoint(30.5345, 79.0303),   // Sitapur
                    GeoPoint(30.7352, 79.0669),   // Kedarnath
                    GeoPoint(30.4117, 79.3681),   // Pipalkoti
                    GeoPoint(30.7447, 79.4930)    // Badrinath

                )
                val pollyLine = Polyline().apply {
                    setPoints(routeCoordinates)
                    outlinePaint.color = Color.Red.toArgb()
                    outlinePaint.strokeWidth = 5f

                }
                overlays.add(pollyLine)



            } },


    )


}


@Preview(showBackground = true)
@Composable
fun OpenStreetMapPreview() {
    MyApp{

        MapViewComponent()

    }
}





//                val tileSource = org.osmdroid.tileprovider.tilesource.TileSourceFactory.MAPNIK
//                val tilesProvider = MapTileProviderBasic(context.applicationContext)
//                tilesProvider.tileSource = tileSource
//                val tilesOverlay = org.osmdroid.views.overlay.TilesOverlay(tilesProvider,context)
//                tilesOverlay.loadingBackgroundColor = Color.Transparent.toArgb()
//                overlays.add(tilesOverlay)

/*val tileSource = org.osmdroid.tileprovider.tilesource.TileSourceFactory.MAPNIK
val tilesProvider = MapTileProviderBasic(context.applicationContext).apply {
    this.tileSource = tileSource
}
//                tilesProvider.tileSource = tileSource
val tilesOverlay = TilesOverlay(tilesProvider, context).apply {
    loadingBackgroundColor = Color.Transparent.toArgb()
}
//                tilesOverlay.loadingBackgroundColor = Color.Transparent.toArgb()
overlays.add(tilesOverlay)*/