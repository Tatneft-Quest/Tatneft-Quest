package com.example.tatneft_quest.utils

import android.content.Context
import android.graphics.Bitmap
import android.view.ViewGroup
import android.widget.ImageView
import com.example.tatneft_quest.R
import com.example.tatneft_quest.models.ClusterMarkerPoints
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.Marker
import com.google.android.gms.maps.model.MarkerOptions
import com.google.maps.android.clustering.Cluster
import com.google.maps.android.clustering.ClusterManager
import com.google.maps.android.clustering.view.DefaultClusterRenderer
import com.google.maps.android.ui.IconGenerator

class MyClusterManagerRendererPoints(
    context: Context,
    googleMap: GoogleMap?,
    clusterManager: ClusterManager<ClusterMarkerPoints>?,
) :
    DefaultClusterRenderer<ClusterMarkerPoints>(context, googleMap, clusterManager) {

    private var iconGenerator: IconGenerator? = IconGenerator(context.applicationContext)
    private var imageView: ImageView = ImageView(context.applicationContext)
    private val markerWidth: Int =
        context.resources.getDimension(R.dimen.custom_marker_image).toInt()
    private val markerHeight: Int =
        context.resources.getDimension(R.dimen.custom_marker_image).toInt()

    init {
        imageView.layoutParams = ViewGroup.LayoutParams(markerWidth, markerHeight)
        imageView.scaleType = ImageView.ScaleType.CENTER_CROP
        val padding: Int = context.resources.getDimension(R.dimen.custom_marker_padding).toInt()
        imageView.setPadding(padding, padding, padding, padding)
        iconGenerator!!.setContentView(imageView)
    }

    @Suppress("NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")
    override fun onBeforeClusterItemRendered(
        item: ClusterMarkerPoints,
        markerOptions: MarkerOptions,
    ) {
        imageView.setImageResource(item.getIconPicture())
        val icon: Bitmap? = iconGenerator?.makeIcon()
        markerOptions.icon(BitmapDescriptorFactory.fromBitmap(icon)).title(item.title)
    }

    override fun shouldRenderAsCluster(cluster: Cluster<ClusterMarkerPoints?>): Boolean {
        return false
    }

    fun setUpdateMarker(clusterMarker: ClusterMarkerPoints) {
        val marker: Marker = getMarker(clusterMarker)
        marker.position = clusterMarker.position
    }
}