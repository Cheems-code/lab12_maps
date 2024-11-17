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
fun SimpleRouteMap() {
    val cameraPositionState = rememberCameraPositionState {
        position = com.google.android.gms.maps.model.CameraPosition.fromLatLngZoom(
            LatLng(-16.398866, -71.536961), 12f
        ) // Plaza de Armas
    }

    val simpleRoute = listOf(
        LatLng(-16.398866, -71.536961), // Plaza de Armas
        LatLng(-16.4205151, -71.4945209), // Paucarpata
        LatLng(-16.433415, -71.5442652)  // JLByR
    )

    Box(modifier = Modifier.fillMaxSize()) {
        GoogleMap(
            modifier = Modifier.fillMaxSize(),
            cameraPositionState = cameraPositionState
        ) {
            // Dibujar polilínea simple
            Polyline(
                points = simpleRoute,
                color = Color.Blue,
                width = 5f
            )
        }
    }
}
