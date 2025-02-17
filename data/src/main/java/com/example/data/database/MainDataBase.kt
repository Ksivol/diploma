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
import com.example.data.dao.PcDAO
import com.example.data.dao.PsuDAO
import com.example.data.dao.RamDAO
import com.example.data.dao.VideoCardDAO
import com.example.data.entities.CPUEntity
import com.example.data.entities.CoolerEntity
import com.example.data.entities.HardDriveEntity
import com.example.data.entities.MotherboardEntity
import com.example.data.entities.PSUEntity
import com.example.data.entities.PcCaseEntity
import com.example.data.entities.PcEntity
import com.example.data.entities.RAMEntity
import com.example.data.entities.VideoCardEntity

@Database(
    entities = [
        CoolerEntity::class,
        CPUEntity::class,
        HardDriveEntity::class,
        MotherboardEntity::class,
        PcCaseEntity::class,
        PSUEntity::class,
        RAMEntity::class,
        VideoCardEntity::class,
        PcEntity::class,
    ],
    version = 1,
    exportSchema = true,
)
abstract class MainDataBase : RoomDatabase() {
    abstract fun getCoolerDAO(): CoolerDAO

    abstract fun getCpuDAO(): CpuDAO

    abstract fun getHardDriveDAO(): HardDriveDAO

    abstract fun getMotherboardDAO(): MotherboardDAO

    abstract fun getPcCaseDAO(): PcCaseDAO

    abstract fun getPsuDAO(): PsuDAO

    abstract fun getRamDAO(): RamDAO

    abstract fun getVideoCardDAO(): VideoCardDAO

    abstract fun getPcDao(): PcDAO

    companion object {
        private var INSTANCE: MainDataBase? = null

        fun getDatabase(context: Context): MainDataBase =
            INSTANCE ?: synchronized(this) {
                val instance =
                    Room
                        .databaseBuilder(
                            context = context,
                            klass = MainDataBase::class.java,
                            "main_database",
                        ).createFromAsset("database/db_test.db")
                        .build()
                INSTANCE = instance
                instance
            }
    }
}
