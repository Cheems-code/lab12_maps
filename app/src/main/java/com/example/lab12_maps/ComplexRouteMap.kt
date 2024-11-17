package com.example.lab12_maps

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.Polyline
import com.google.maps.android.compose.rememberCameraPositionState

@Composable
fun ComplexRouteMap() {
    val cameraPositionState = rememberCameraPositionState {
        position = com.google.android.gms.maps.model.CameraPosition.fromLatLngZoom(
            LatLng(-16.432292, -71.509145), 12f
        ) // Mall Aventura
    }

    val complexRoute = listOf(
        LatLng(-16.432292, -71.509145), // Mall Aventura
        LatLng(-16.422704, -71.530830), // Parque Lambramani
        LatLng(-16.4040102, -71.559611), // Arequipa
        LatLng(-16.3524187, -71.5675994) // Zamacola
    )

    Box(modifier = Modifier.fillMaxSize()) {
        GoogleMap(
            modifier = Modifier.fillMaxSize(),
            cameraPositionState = cameraPositionState
        ) {
            // Dibujar polilínea compleja
            Polyline(
                points = complexRoute,
                color = Color.Red,
                width = 8f
            )
        }
    }
}
