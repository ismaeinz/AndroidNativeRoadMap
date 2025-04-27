package com.example.carexample.app

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.components.SingletonComponent
import javax.inject.Inject
import javax.inject.Qualifier
import javax.inject.Singleton

const val TAG = "Domex"

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @Inject
    lateinit var car: Car
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        car.startCar()
        car.flashLightes()
        car.printCarBrand()
        car.printCarDetails()
    }


    class Car @Inject constructor(
        val carBrand: CarBrand,
        val engine: Engine,
        @CarColor val carColor: String,
        @PlateNumber val carNumber: String
    ) {

        fun printCarDetails() {
            Log.d(TAG, "Color ${carColor} , PlateNumber :${carNumber}")

        }

        fun printCarBrand() {
            Log.d(TAG, carBrand.getCarBrand())

        }

        fun startCar() {
            Log.d(TAG, engine.start())
            Log.d(TAG, "Starting Car")

        }

        fun flashLightes() {
            Log.d(TAG, "flashLightes")

        }
    }

    class Engine @Inject constructor() {
        fun start(): String {
            return "Starting Engine"
        }
    }

    class Bmw @Inject constructor() : CarBrand {
        override fun getCarBrand(): String {
            return "BMW M2"
        }

    }
//
//    class Marcides @Inject constructor() : CarBrand {
//        override fun getCarBrand(): String {
//            return "Marcides "
//        }
//
//    }

    interface CarBrand {
        fun getCarBrand(): String
    }

    @InstallIn(SingletonComponent::class)
    @Module

    class MyModule {
        @Singleton
        @Provides
        fun provideBmwCar(): CarBrand {
            return Bmw()
        }

        @CarColor
        @Singleton
        @Provides
        fun provideCarColor(): String {
            return "Blue"
        }

        @PlateNumber
        @Singleton
        @Provides
        fun providePlateNumber(): String {
            return "Abs 123"
        }

    }


}

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class CarColor

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class PlateNumber
