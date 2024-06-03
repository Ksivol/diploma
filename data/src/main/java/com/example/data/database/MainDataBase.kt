package com.example.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.data.dao.CoolerDAO
import com.example.data.dao.CpuDAO
import com.example.data.dao.HardDriveDAO
import com.example.data.dao.MotherboardDAO
import com.example.data.dao.PcCaseDAO
import com.example.data.dao.PsuDAO
import com.example.data.dao.RamDAO
import com.example.data.dao.VideoCardDAO
import com.example.data.entities.CPU
import com.example.data.entities.Cooler
import com.example.data.entities.HardDrive
import com.example.data.entities.Motherboard
import com.example.data.entities.PSU
import com.example.data.entities.PcCase
import com.example.data.entities.RAM
import com.example.data.entities.VideoCard

@Database(entities = [Cooler::class, CPU::class, HardDrive::class, Motherboard::class, PcCase::class, PSU::class, RAM::class, VideoCard::class], version = 1)
abstract class MainDataBase : RoomDatabase() {

    abstract fun getCoolerDAO(): CoolerDAO
    abstract fun getCpuDAO(): CpuDAO
    abstract fun getHardDriveDAO(): HardDriveDAO
    abstract fun getMotherboardDAO(): MotherboardDAO
    abstract fun getPcCaseDAO(): PcCaseDAO
    abstract fun getPsuDAO(): PsuDAO
    abstract fun getRamDAO(): RamDAO
    abstract fun getVideoCardDAO(): VideoCardDAO

    companion object {
        private var INSTANCE: MainDataBase? = null

        fun getDatabase(context: Context): MainDataBase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context = context,
                    klass = MainDataBase::class.java,
                    "main_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}