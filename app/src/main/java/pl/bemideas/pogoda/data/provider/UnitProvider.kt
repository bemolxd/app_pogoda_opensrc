package pl.bemideas.pogoda.data.provider

import pl.bemideas.pogoda.internal.UnitSystem

interface UnitProvider {
    fun getUnitSystem(): UnitSystem
}