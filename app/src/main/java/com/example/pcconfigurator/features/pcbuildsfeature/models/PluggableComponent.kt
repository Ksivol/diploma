package com.example.pcconfigurator.features.pcbuildsfeature.models

import kotlin.jvm.internal.Intrinsics

sealed class PluggableComponent(
    open val id: Int,
    open val name: String,
    open val price: String,
    open val photo: String
) {
    override fun equals(other: Any?): Boolean {
        return if (this === other) {
            true
        } else if (other !is PluggableComponent) {
            false
        } else {
            if (this.id != other.id) {
                false
            } else if (!Intrinsics.areEqual(this.name, other.name)) {
                false
            } else if (!Intrinsics.areEqual(this.price, other.price)) {
                false
            } else {
                Intrinsics.areEqual(this.photo, other.photo)
            }
        }
    }

    override fun hashCode(): Int {
        var result = Integer.hashCode(this.id)
        result = result * 31 + name.hashCode()
        result = result * 31 + price.hashCode()
        result = result * 31 + photo.hashCode()
        return result
    }
}




