package com.example.day1.data.remote.responed

data class ResponedItem(
    val area: Double = 0.0,

    val capitalInfo: CapitalInfo = CapitalInfo(),
    val car: Car = Car(),
    val cca2: String = "",
    val cca3: String = "",
    val ccn3: String = "",
    val cioc: String = "",
    val coatOfArms: CoatOfArms = CoatOfArms(),
    val currencies: Currencies = Currencies(),
    val demonyms: Demonyms = Demonyms(),
    val fifa: String = "",
    val flag: String = "",
    val flags: Flags = Flags(),
    val gini: Gini = Gini(),
    val idd: Idd = Idd(),
    val independent: Boolean = false,
    val landlocked: Boolean = false,
    val languages: Languages = Languages(),
    val maps: Maps = Maps(),
    val name: Name = Name(),
    val population: Int = 0,
    val postalCode: PostalCode = PostalCode(),
    val region: String = "",
    val startOfWeek: String = "",
    val status: String = "",
    val subregion: String = "",

    val translations: Translations = Translations(),
    val unMember: Boolean = false
)