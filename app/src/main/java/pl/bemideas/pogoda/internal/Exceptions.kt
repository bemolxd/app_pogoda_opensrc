package pl.bemideas.pogoda.internal

import java.io.IOException
import java.lang.Exception

class NoConnectivityException: IOException()
class LocationPremissionNotGrantedException: Exception()