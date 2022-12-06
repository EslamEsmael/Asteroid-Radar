package com.eslam.asteroidradar.presentation

import android.view.View
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.lifecycle.LiveData
import androidx.recyclerview.widget.RecyclerView
import com.eslam.asteroidradar.R
import com.eslam.asteroidradar.data.model.Asteroid
import com.eslam.asteroidradar.data.model.ImageOfDay
import com.eslam.asteroidradar.presentation.mainFragment.AsteroidsAdapter
import com.squareup.picasso.Picasso

@BindingAdapter("listData")
fun bindRecyclerView(recyclerView: RecyclerView, data: List<Asteroid>?) {
    val adapter = recyclerView.adapter as AsteroidsAdapter
    adapter.submitList(data)
}

@BindingAdapter("imageUrl")
fun setImageUrl(imageView: ImageView, image: ImageOfDay?) {
    image.let {
        Picasso.get().load(image?.url).into(imageView)
    }
}

@BindingAdapter("auText")
fun setAstronomicalUnit(textView: TextView, number: Double) {
    textView.text =
        String.format(textView.context.getString(R.string.astronomical_unit_format), number)
}

@BindingAdapter("estimatedDiameter")
fun setEstimatedDiameter(textView: TextView, number: Double) {
    textView.text =
        String.format(textView.context.getString(R.string.estimated_diameter_format), number)
}

@BindingAdapter("relativeVelocity")
fun setRelativeVelocity(textView: TextView, number: Double) {
    textView.text =
        String.format(textView.context.getString(R.string.relative_velocity_format), number)
}

@BindingAdapter("distanceFromEarth")
fun setDistanceFromEarth(textView: TextView, number: Double) {
    textView.text =
        String.format(textView.context.getString(R.string.astronomical_unit_format), number)
}

@BindingAdapter("asteroidStatusImage")
fun bindDetailsStatusImage(imageView: ImageView, isHazardous: Boolean) {
    if (isHazardous) {
        imageView.setImageResource(R.drawable.asteroid_hazardous)
    } else {
        imageView.setImageResource(R.drawable.asteroid_safe)
    }
}

@BindingAdapter("isHazardous")
fun bindEmojiImage(imageView: ImageView, isHazardous: Boolean) {
    if (isHazardous) {
        imageView.setImageResource(R.drawable.ic_status_potentially_hazardous)
    } else {
        imageView.setImageResource(R.drawable.ic_status_normal)
    }
}

@BindingAdapter("hideIfDataAvailable")
fun hideIfDataAvailable(relativeLayout: RelativeLayout, data: LiveData<List<Asteroid>>?) {
    if (data != null && data.value?.size != 0)
        relativeLayout.visibility = View.GONE
    else
        relativeLayout.visibility = View.VISIBLE
}

@BindingAdapter("hideIfImageAvailable")
fun hideIfImageAvailable(relativeLayout: RelativeLayout, data: LiveData<ImageOfDay>?) {
    if (data != null && data.value != null)
        relativeLayout.visibility = View.GONE
    else
        relativeLayout.visibility = View.VISIBLE
}

